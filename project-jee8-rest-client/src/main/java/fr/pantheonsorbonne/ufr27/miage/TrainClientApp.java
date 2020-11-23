package fr.pantheonsorbonne.ufr27.miage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ArrivalStopPointEntityDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ArrivalTerminusEntityDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.DepartureEntityDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.LocationDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.StationEntityDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainEntityDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainTypeNoReservationDto;

public class TrainClientApp {

	private static final Client client = ClientBuilder.newClient();
	private static final WebTarget webTarget = client.target("http://localhost:8080/");

	public static void main(String[] args) throws InterruptedException {
		TrainClientApp app = new TrainClientApp();
		app.run();
	}
//	public static Entity<String> getGPSCoordinates() {
//		return Entity.entity("48.840399, 2.341958", MediaType.TEXT_PLAIN);
//	}

	public void run() throws InterruptedException {

		Client client = ClientBuilder.newClient();

		
		//GET ======================
		WebTarget target = client.target("http://localhost:8080/infoCentre/Train/TGV1");
			//TrainEntityDto trainEntityDto = target.request().get().readEntity(TrainEntityDto.class);
			//System.out.println(trainEntityDto);
		System.out.println(target.request(MediaType.APPLICATION_JSON).get().readEntity(String.class));
		
		//POST ======================
		
		List<ArrivalStopPointEntityDto> stopPoints = new ArrayList<ArrivalStopPointEntityDto>();
		LocationDto location = new LocationDto("1111111", "11111111");
		StationEntityDto Bourges = new StationEntityDto(Long.valueOf(6), "Bourges", location);
		StationEntityDto Brest = new StationEntityDto(Long.valueOf(7), "Brest", location);
		StationEntityDto tours = new StationEntityDto(Long.valueOf(1), "Tours", location);
		StationEntityDto limoges = new StationEntityDto(Long.valueOf(2), "Limoges", location);
		
		stopPoints.add(new ArrivalStopPointEntityDto(Long.valueOf(0), 1, new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), tours));
		stopPoints.add(new ArrivalStopPointEntityDto(Long.valueOf(1), 2, new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), limoges));
		
		DepartureEntityDto dp = new DepartureEntityDto(Long.valueOf(6), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), Bourges);
		ArrivalTerminusEntityDto at = new ArrivalTerminusEntityDto(Long.valueOf(7), 3, new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime(), Brest);
		TrainEntityDto train = new TrainEntityDto("TER2",location,0,false,TrainTypeNoReservationDto.RER.toString(), dp, at, stopPoints);
				target = client.target("http://localhost:8080/infoCentre/Train");
					//TrainEntityDto trainEntityDto = target.request().get().readEntity(TrainEntityDto.class);
					//System.out.println(trainEntityDto);
				target.request().post(Entity.entity(train , MediaType.APPLICATION_JSON));;
		
	}

}
