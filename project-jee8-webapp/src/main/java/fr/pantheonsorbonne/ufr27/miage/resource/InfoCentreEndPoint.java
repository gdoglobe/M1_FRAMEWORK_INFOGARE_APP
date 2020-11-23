package fr.pantheonsorbonne.ufr27.miage.resource;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import fr.pantheonsorbonne.ufr27.miage.dao.InfoCentreDao;
import fr.pantheonsorbonne.ufr27.miage.jpa.ArrivalStopPoint;
import fr.pantheonsorbonne.ufr27.miage.jpa.ArrivalTerminus;
import fr.pantheonsorbonne.ufr27.miage.jpa.Departure;
import fr.pantheonsorbonne.ufr27.miage.jpa.InfoCentre;
import fr.pantheonsorbonne.ufr27.miage.jpa.Location;
import fr.pantheonsorbonne.ufr27.miage.jpa.Station;
import fr.pantheonsorbonne.ufr27.miage.jpa.TrainAbstract;
import fr.pantheonsorbonne.ufr27.miage.jpa.TrainFactory;
import fr.pantheonsorbonne.ufr27.miage.jpa.TrainNoReservation;
import fr.pantheonsorbonne.ufr27.miage.jpa.TrainReservation;
import fr.pantheonsorbonne.ufr27.miage.jpa.TrainTypeNoReservation;
import fr.pantheonsorbonne.ufr27.miage.jpa.TrainTypeReservation;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ArrivalDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.DepartureDto;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.InfoCentreDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainEntityDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainNoReservationDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainReservationDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainTypeNoReservationDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainTypeReservationDto;





@Path("infoCentre")
public class InfoCentreEndPoint {
	InfoCentreDto infoCentreDto;
	InfoCentreDao infoCentreDao = new InfoCentreDao();
	InfoCentre infoCentreEntity;
	@GET
	@Path("/test")
	@javax.ws.rs.Produces(MediaType.TEXT_PLAIN)
	public String test()
	{
		return "test OK!";
	}
	
	@GET
	@Path("/Train/{trainId}")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public Response getTrain(@PathParam("trainId") String trainId) {
		return Response.ok(infoCentreDao.find(Long.valueOf(1)).getTrainEntityDtoById(trainId)).build();
	}
	
	@POST
	@Path("/Train")
	 @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response postTrain(TrainEntityDto trainEntityDto, @Context UriInfo uriInfo) throws DatatypeConfigurationException {
		System.out.println("Train recieve" + trainEntityDto.getId());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TrainAbstract trainEntity = new TrainFactory().getInstance(trainEntityDto);
		infoCentreEntity = infoCentreDao.find(Long.valueOf(1));
		infoCentreEntity.addTrain(trainEntity);
		infoCentreDao.update(infoCentreEntity);
		 return Response.status(Response.Status.CREATED.getStatusCode()).header("Location", String.format("%s/%s", uriInfo.getAbsolutePath().toString(), trainEntity.getId())).build();

		//return Response.ok(t).build();
		
	}
	
	
	@GET
	@Path("/gares/{stationName}")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public Response getMessage(@PathParam("stationName") String stationName) {
	  
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
		
		InfoCentreDao ifcDao = new InfoCentreDao();//new InfoCentreDao(pc.getEM());
		//infoCentre.setId(Long.valueOf(1));
		//ifc.save(infoCentre);
		InfoCentre ifc = ifcDao.find(Long.valueOf(1));
		
		//System.out.println(infoCentreDto.getGaresToString());
		//return Response.ok(infoCentreDto.getGares().get("Rouen")).build();
		//InfoCentreDao ifc = new InfoCentreDao();
		//InfoCentre infoCentre2 = null;
		//for(InfoCentre ifcE : ifc.findAll())
		//	infoCentre2 = ifcE;
		
		//return Response.ok(infoCentre2.getTrainsDtoByDepartureStationName("Tours")).build();
		return Response.ok(ifc.getTrainsDtoByDepartureStationName(stationName)).build();
	}
	
	
	
	
	
	/*@GET
	@Path("/gares")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMessage() {
	   // Map<String, String> map = new HashMap<>();
	    infoCentre = new InfoCentre();
		infoCentre.addTrain(new Train("TGV1", "Paris", "Bordeaux", "lat:1, lon:2", "23/12/2020 12h:30min:20s", "23/12/2020 14h:20min:20s"));

		//infoCentre.setDepart(new Train("TGV1", "Paris", "Bordeaux", "lat:1, lon:2", "23/12/2020 12h:30min:20s", "23/12/2020 14h:20min:20s"));
		//infoCentre.setDepart(new Train("TGV2", "Paris", "Bordeaux", "lat:1, lon:2", "24/12/2020 02h:53min:20s", "23/12/2020 14h:20min:20s"));
		
		return Response.status(Status.OK).entity(infoCentre.getTrains()).build();
	   // return Response.status(Status.OK).entity(map).build();
	}*/
    
}
