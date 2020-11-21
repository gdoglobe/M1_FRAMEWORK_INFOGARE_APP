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
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ArrivalDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.DepartureDto;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.InfoCentreDto;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainNoReservationDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainReservationDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainTypeNoReservationDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainTypeReservationDto;





@Path("infoCentre")
public class InfoGareResource {
	InfoCentreDto infoCentreDto;
	
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
	  
		List<ArrivalStopPoint> stopPoints = new ArrayList<ArrivalStopPoint>();
		Location location = new Location("1111111", "11111111");

		stopPoints.add(new ArrivalStopPoint(Long.valueOf(0), 0, new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), new Station(Long.valueOf(0), "Tours", location)));
		stopPoints.add(new ArrivalStopPoint(Long.valueOf(1), 0, new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), new Station(Long.valueOf(0), "Limoge", location)));
		InfoCentre infoCentre = new InfoCentre();


		Departure dp = new Departure(Long.valueOf(1), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), new Station(Long.valueOf(0), "Rouen", location));
		ArrivalTerminus at = new ArrivalTerminus(Long.valueOf(1), 0, new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), new Station(Long.valueOf(0), "Bordeaux", location));
		infoCentre.addTrain(new TrainNoReservation("TER",TrainTypeNoReservation.RER, dp, at,location, stopPoints));

		dp = new Departure(Long.valueOf(1), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), new Station(Long.valueOf(0), "Paris", location));
		at = new ArrivalTerminus(Long.valueOf(1), 0, new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), new Station(Long.valueOf(0), "Bordeaux", location));


		infoCentre.addTrain(new TrainReservation("TGV1",TrainTypeReservation.TVG, dp, at, location, stopPoints));
		dp = new Departure(Long.valueOf(1), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), new Station(Long.valueOf(0), "Paris", location));
		at = new ArrivalTerminus(Long.valueOf(1), 0, new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), new Station(Long.valueOf(0), "Bordeaux", location));

		infoCentre.addTrain(new TrainReservation("TGV2",TrainTypeReservation.TVG, dp, at, location, stopPoints));
		dp = new Departure(Long.valueOf(1), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), new Station(Long.valueOf(0), "Bordeaux", location));
		at = new ArrivalTerminus(Long.valueOf(1), 0, new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), new Station(Long.valueOf(0), "Paris", location));

		infoCentre.addTrain(new TrainReservation("TGV3",TrainTypeReservation.TVG, dp, at, location, stopPoints));
		dp = new Departure(Long.valueOf(1), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), new Station(Long.valueOf(0), "Paris", location));
		at = new ArrivalTerminus(Long.valueOf(1), 0, new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), new Station(Long.valueOf(0), "Rouen", location));

		infoCentre.addTrain(new TrainReservation("TGV4",TrainTypeReservation.TVG, dp, at, location, stopPoints));
		
		/*
		 infoCentreDto = new InfoCentreDto();

	    infoCentreDto.addDeparture(new TrainNoReservationDto("TER",TrainTypeNoReservationDto.RER.toString(), new DepartureDto(Long.valueOf(1),"Rouen", new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new ArrivalDto(Long.valueOf(1),"Bordeaux", new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime())));

	  		infoCentreDto.addDeparture(new TrainReservationDto("TGV1",TrainTypeReservationDto.TVG.toString(), new DepartureDto(Long.valueOf(2),"Paris",  new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new ArrivalDto(Long.valueOf(2),"Bordeaux", new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime())));
	  		
	  		infoCentreDto.addDeparture(new TrainReservationDto("TGV2",TrainTypeReservationDto.TVG.toString(), new DepartureDto(Long.valueOf(3),"Rouen",  new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new ArrivalDto(Long.valueOf(3),"Bordeaux", new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime())));
	  		
	  		infoCentreDto.addDeparture(new TrainReservationDto("TGV3",TrainTypeReservationDto.TVG.toString(), new DepartureDto(Long.valueOf(4),"Bordeaux", new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new ArrivalDto(Long.valueOf(4),"Rouen", new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime())));
	  		
	  		infoCentreDto.addDeparture(new TrainReservationDto("TGV4",TrainTypeReservationDto.TVG.toString(), new DepartureDto(Long.valueOf(5),"Paris", new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new ArrivalDto(Long.valueOf(5),"Rouen", new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime())));
	  		
	    
		System.out.println(infoCentreDto.getGaresToString());
		return Response.ok(infoCentreDto.getGares().get("Rouen")).build();*/
		return Response.ok(infoCentre.getTrainsDtoByDepartureStationName("Tours")).build();
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
