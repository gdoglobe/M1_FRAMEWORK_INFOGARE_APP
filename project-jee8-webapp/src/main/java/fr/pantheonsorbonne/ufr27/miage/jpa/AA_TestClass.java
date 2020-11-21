package fr.pantheonsorbonne.ufr27.miage.jpa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainAbstractImplDto;

public class AA_TestClass {

	public static void main(String[] args) {
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

		List<String> stations = new ArrayList<String>();
		stations.add("Tours");
		stations.add("Limoge");
		stations.add("Paris");
		stations.add("Rouen");
		stations.add("Bordeaux");
		List<TrainAbstractImplDto> arrives = new ArrayList<TrainAbstractImplDto>();
		List<TrainAbstractImplDto> departs = new ArrayList<TrainAbstractImplDto>();
		
		
		for(String station : stations)
		{
			arrives = infoCentre.getTrainsByArrivalStationName(station);
			departs = infoCentre.getTrainsByDepartureStationName(station);
			System.out.println(station);
			for(TrainAbstractImplDto d : departs)
			{
				System.out.println("\t\tDéparts");
				System.out.println(d.toString());
			}
			for(TrainAbstractImplDto a : arrives)
			{	
				System.out.println("\t\tArrivés");
				System.out.println(a.toString());
			}
			
		}
		
		

	}

}
