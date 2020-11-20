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

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ArrivalStopPointDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ArrivalTerminusDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.DepartureDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ITrainDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.InfoCentreDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.LocationDto;
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
	   // Map<String, String> map = new HashMap<>();
		//message destinateur
		
		
		List<ArrivalStopPointDto> stopPoints = new ArrayList<ArrivalStopPointDto>();
		stopPoints.add(new ArrivalStopPointDto("Tours", 0, new LocationDto("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()));
		stopPoints.add(new ArrivalStopPointDto("Limoges", 1, new LocationDto("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()));
	    infoCentreDto = new InfoCentreDto();
	    
	    
	  
	    infoCentreDto.addDeparture(new TrainNoReservationDto("TER",TrainTypeNoReservationDto.RER, new DepartureDto("Rouen", new LocationDto("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new ArrivalTerminusDto("Bordeaux", 0, new LocationDto("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new LocationDto("1111111", "11111111"), stopPoints));
		
		infoCentreDto.addDeparture(new TrainReservationDto("TGV1",TrainTypeReservationDto.TVG, new DepartureDto("Paris", new LocationDto("11331111", "11111111") , new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new ArrivalTerminusDto("Bordeaux", 0, new LocationDto("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new LocationDto("1111111", "11111111"), stopPoints));
		
		infoCentreDto.addDeparture(new TrainReservationDto("TGV2",TrainTypeReservationDto.TVG, new DepartureDto("Rouen", new LocationDto("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new ArrivalTerminusDto("Bordeaux", 0, new LocationDto("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new LocationDto("1111111", "11111111"), stopPoints));
		
		infoCentreDto.addDeparture(new TrainReservationDto("TGV3",TrainTypeReservationDto.TVG, new DepartureDto("Bordeaux", new LocationDto("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new ArrivalTerminusDto("Rouen", 0, new LocationDto("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new LocationDto("1111111", "11111111"), stopPoints));
		
		infoCentreDto.addDeparture(new TrainReservationDto("TGV4",TrainTypeReservationDto.TVG, new DepartureDto("Paris", new LocationDto("1111111", "11111111") , new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new ArrivalTerminusDto("Rouen", 0, new LocationDto("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new LocationDto("1111111", "11111111"), stopPoints));
		
	    
		System.out.println(infoCentreDto.getGaresToString());
		return Response.ok(infoCentreDto).build();
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
