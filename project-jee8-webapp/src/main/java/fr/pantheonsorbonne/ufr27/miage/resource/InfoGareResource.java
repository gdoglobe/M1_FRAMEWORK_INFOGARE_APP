package fr.pantheonsorbonne.ufr27.miage.resource;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.Arrival;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.Departure;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ITrain;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.InfoCentre;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.Location;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainReservation;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainTypeReservation;





@Path("infoCentre")
public class InfoGareResource {
	InfoCentre infoCentre;
	
	@GET
	@Path("/test")
	@javax.ws.rs.Produces(MediaType.TEXT_PLAIN)
	public String test()
	{
		return "test OK!";
	}
	
	@GET
	@Path("/gares")
	@javax.ws.rs.Produces(MediaType.APPLICATION_XML)
	public Response getMessage() {
	   // Map<String, String> map = new HashMap<>();
		//message destinateur
		
		
		List<Arrival> stopPoints = new ArrayList<Arrival>();
		stopPoints.add(new Arrival("Tours", Long.valueOf(0), new Location("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()));
		stopPoints.add(new Arrival("Limoges", Long.valueOf(1), new Location("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()));
	    infoCentre = new InfoCentre();
	    
	    
	  
		
		infoCentre.addDeparture(new TrainReservation("TGV1",TrainTypeReservation.TVG, new Departure("Paris", new Location("11331111", "11111111") , new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new Arrival("Bordeaux", Long.valueOf(0), new Location("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new Location("1111111", "11111111"), stopPoints));
		
		infoCentre.addDeparture(new TrainReservation("TGV2",TrainTypeReservation.TVG, new Departure("Rouen", new Location("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new Arrival("Bordeaux", Long.valueOf(0), new Location("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new Location("1111111", "11111111"), stopPoints));
		
		infoCentre.addDeparture(new TrainReservation("TGV3",TrainTypeReservation.TVG, new Departure("Bordeaux", new Location("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new Arrival("Rouen", Long.valueOf(0), new Location("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new Location("1111111", "11111111"), stopPoints));
		
		infoCentre.addDeparture(new TrainReservation("TGV4",TrainTypeReservation.TVG, new Departure("Paris", new Location("1111111", "11111111") , new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new Arrival("Rouen", Long.valueOf(0), new Location("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new Location("1111111", "11111111"), stopPoints));
		
	    
		System.out.println(infoCentre.getGaresToString());
		return Response.ok(infoCentre).build();
	   // return Response.status(Status.OK).entity(map).build();
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
