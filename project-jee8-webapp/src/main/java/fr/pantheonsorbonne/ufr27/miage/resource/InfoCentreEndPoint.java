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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	 @Consumes({MediaType.APPLICATION_XML })
	public Response postTrain(TrainEntityDto trainEntityDto, @Context UriInfo uriInfo) throws DatatypeConfigurationException {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(trainEntityDto);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Train recieve\n" + json);
		try {
			Thread.sleep(20000);
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
	@Path("/InfoGare/Departure/{stationName}")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public Response getMessage(@PathParam("stationName") String stationName) {
		InfoCentreDao ifcDao = new InfoCentreDao();
		InfoCentre ifc = ifcDao.find(Long.valueOf(1));
		return Response.ok(ifc.getTrainsDtoByDepartureStationName(stationName)).build();
	}
	
	
	
	
	
	
    
}
