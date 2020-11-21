package fr.pantheonsorbonne.ufr27.miage;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.inject.Singleton;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.bridge.SLF4JBridgeHandler;

import fr.pantheonsorbonne.ufr27.miage.conf.EMFFactory;
import fr.pantheonsorbonne.ufr27.miage.conf.EMFactory;
import fr.pantheonsorbonne.ufr27.miage.conf.PersistenceConf;
import fr.pantheonsorbonne.ufr27.miage.dao.InvoiceDAO;
import fr.pantheonsorbonne.ufr27.miage.dao.PaymentDAO;
import fr.pantheonsorbonne.ufr27.miage.exception.ExceptionMapper;
import fr.pantheonsorbonne.ufr27.miage.jms.PaymentValidationAckownledgerBean;
import fr.pantheonsorbonne.ufr27.miage.jms.conf.ConnectionFactorySupplier;
import fr.pantheonsorbonne.ufr27.miage.jms.conf.JMSProducer;
import fr.pantheonsorbonne.ufr27.miage.jms.conf.PaymentAckQueueSupplier;
import fr.pantheonsorbonne.ufr27.miage.jms.conf.PaymentQueueSupplier;
import fr.pantheonsorbonne.ufr27.miage.jms.utils.BrokerUtils;
import fr.pantheonsorbonne.ufr27.miage.jpa.ArrivalStopPoint;
import fr.pantheonsorbonne.ufr27.miage.jpa.ArrivalTerminus;
import fr.pantheonsorbonne.ufr27.miage.jpa.Departure;
import fr.pantheonsorbonne.ufr27.miage.jpa.InfoCentre;
import fr.pantheonsorbonne.ufr27.miage.jpa.Location;
import fr.pantheonsorbonne.ufr27.miage.jpa.Station;
import fr.pantheonsorbonne.ufr27.miage.jpa.TrainNoReservation;
import fr.pantheonsorbonne.ufr27.miage.jpa.TrainReservation;
import fr.pantheonsorbonne.ufr27.miage.jpa.TrainTypeNoReservation;
import fr.pantheonsorbonne.ufr27.miage.jpa.TrainTypeReservation;
import fr.pantheonsorbonne.ufr27.miage.service.GymService;
import fr.pantheonsorbonne.ufr27.miage.service.InvoicingService;
import fr.pantheonsorbonne.ufr27.miage.service.MailingService;
import fr.pantheonsorbonne.ufr27.miage.service.PaymentService;
import fr.pantheonsorbonne.ufr27.miage.service.UserService;
import fr.pantheonsorbonne.ufr27.miage.service.impl.GymServiceImpl;
import fr.pantheonsorbonne.ufr27.miage.service.impl.InvoicingServiceImpl;
import fr.pantheonsorbonne.ufr27.miage.service.impl.MailingServiceImpl;
import fr.pantheonsorbonne.ufr27.miage.service.impl.PaymentServiceImpl;
import fr.pantheonsorbonne.ufr27.miage.service.impl.UserServiceImpl;

/**
 * Main class.
 *
 */
public class Main {

	public static final String BASE_URI = "http://localhost:8080/";

	public static HttpServer startServer() {

		final ResourceConfig rc = new ResourceConfig()//
				.packages(true, "fr.pantheonsorbonne.ufr27.miage")//
				.register(DeclarativeLinkingFeature.class)//
				.register(JMSProducer.class).register(ExceptionMapper.class).register(PersistenceConf.class)
				.register(new AbstractBinder() {

					@Override
					protected void configure() {

						bind(GymServiceImpl.class).to(GymService.class);

						bind(PaymentServiceImpl.class).to(PaymentService.class);
						bind(InvoicingServiceImpl.class).to(InvoicingService.class);
						bind(InvoiceDAO.class).to(InvoiceDAO.class);
						bind(UserServiceImpl.class).to(UserService.class);
						bind(MailingServiceImpl.class).to(MailingService.class);
						bind(PaymentDAO.class).to(PaymentDAO.class);
						bindFactory(EMFFactory.class).to(EntityManagerFactory.class).in(Singleton.class);
						bindFactory(EMFactory.class).to(EntityManager.class).in(RequestScoped.class);
						bindFactory(ConnectionFactorySupplier.class).to(ConnectionFactory.class).in(Singleton.class);
						bindFactory(PaymentAckQueueSupplier.class).to(Queue.class).named("PaymentAckQueue")
								.in(Singleton.class);
						bindFactory(PaymentQueueSupplier.class).to(Queue.class).named("PaymentQueue")
								.in(Singleton.class);

						bind(PaymentValidationAckownledgerBean.class).to(PaymentValidationAckownledgerBean.class)
								.in(Singleton.class);

					}

				});

		return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
	}

	/**
	 * Main method.beanbeanbeanbean
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		Locale.setDefault(Locale.ENGLISH);
		SLF4JBridgeHandler.removeHandlersForRootLogger();
		SLF4JBridgeHandler.install();
		final HttpServer server = startServer();

		BrokerUtils.startBroker();

		PersistenceConf pc = new PersistenceConf();
		//pc.getEM();
		
		
		/**
		 * 
		 * TEST EM
		 */
		
		EntityManager em = pc.getEM();
		em.getTransaction().begin();		
				
		List<ArrivalStopPoint> stopPoints = new ArrayList<ArrivalStopPoint>();
		Location location = new Location("1111111", "11111111");
		Station tours = new Station(Long.valueOf(1), "Tours", location);
		Station limoge = new Station(Long.valueOf(2), "Limoge", location);
		Station rouen = new Station(Long.valueOf(3), "Rouen", location);
		Station bordeaux = new Station(Long.valueOf(4), "Bordeaux", location);
		Station paris = new Station(Long.valueOf(5), "Paris", location);
		

		stopPoints.add(new ArrivalStopPoint(Long.valueOf(0), 1, new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), tours));
		stopPoints.add(new ArrivalStopPoint(Long.valueOf(1), 2, new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), limoge));
		InfoCentre infoCentre = new InfoCentre();


		Departure dp = new Departure(Long.valueOf(1), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), rouen);
		ArrivalTerminus at = new ArrivalTerminus(Long.valueOf(1), 3, new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), bordeaux);
		infoCentre.addTrain(new TrainNoReservation("TER",TrainTypeNoReservation.RER, dp, at,location, stopPoints));

		dp = new Departure(Long.valueOf(2), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), paris);
		at = new ArrivalTerminus(Long.valueOf(2), 4, new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), bordeaux);


		infoCentre.addTrain(new TrainReservation("TGV1",TrainTypeReservation.TVG, dp, at, location, stopPoints));
		dp = new Departure(Long.valueOf(3), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), paris);
		at = new ArrivalTerminus(Long.valueOf(3), 5, new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), bordeaux);

		infoCentre.addTrain(new TrainReservation("TGV2",TrainTypeReservation.TVG, dp, at, location, stopPoints));
		dp = new Departure(Long.valueOf(4), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), bordeaux);
		at = new ArrivalTerminus(Long.valueOf(4), 6, new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), paris);

		infoCentre.addTrain(new TrainReservation("TGV3",TrainTypeReservation.TVG, dp, at, location, stopPoints));
		dp = new Departure(Long.valueOf(5), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), paris);
		at = new ArrivalTerminus(Long.valueOf(5), 7, new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), rouen);

		infoCentre.addTrain(new TrainReservation("TGV4",TrainTypeReservation.TVG, dp, at, location, stopPoints));
		
		
		
		em.persist(infoCentre);
		em.getTransaction().commit();
		
		/**
		 * TEST EM END
		 * 
		 */
		pc.launchH2WS();

		System.out.println(String.format(
				"Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...",
				BASE_URI));
		System.in.read();
		server.stop();

	}
}
