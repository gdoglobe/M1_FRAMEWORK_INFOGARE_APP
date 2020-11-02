package fr.pantheonsorbonne.ufr27.miage.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.Arrival;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.Departure;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.InfoCentre;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.Train;





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
		stopPoints.add(new Arrival("Tours", Long.valueOf(0), "lat:3, lon:4", "23/12/2020 14h:20min:20s"));
		stopPoints.add(new Arrival("Limoges", Long.valueOf(1), "lat:3, lon:4", "23/12/2020 14h:20min:20s"));
	    infoCentre = new InfoCentre();
	  
		//infoCentre.addTrain(new Train("TGV1", "Paris", "Bordeaux", "lat:1, lon:2", "23/12/2020 12h:30min:20s", "23/12/2020 14h:20min:20s"));
		
		infoCentre.addDeparture(new Train("TGV1", new Departure("Paris", "lat:1, lon:2" , "23/12/2020 12h:30min:20s"), new Arrival("Bordeaux", Long.valueOf(0), "lat:3, lon:4", "23/12/2020 14h:20min:20s"), "lat:3, lon:4", stopPoints));
		
		infoCentre.addDeparture(new Train("TGV2", new Departure("Rouen", "lat:1, lon:2" , "24/12/2020 12h:30min:20s"), new Arrival("Bordeaux", Long.valueOf(0), "lat:3, lon:4", "24/12/2020 14h:20min:20s"), "lat:3, lon:4", stopPoints));
		
		infoCentre.addDeparture(new Train("TGV3", new Departure("Bordeaux", "lat:1, lon:2" , "25/12/2020 12h:30min:20s"), new Arrival("Rouen", Long.valueOf(0), "lat:3, lon:4", "25/12/2020 14h:20min:20s"), "lat:3, lon:4", stopPoints));
		
		infoCentre.addDeparture(new Train("TGV4", new Departure("Paris", "lat:1, lon:2" , "26/12/2020 12h:30min:20s"), new Arrival("Rouen", Long.valueOf(0), "lat:3, lon:4", "26/12/2020 14h:20min:20s"), "lat:3, lon:4", stopPoints));
		
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
