package fr.pantheonsorbonne.ufr27.miage.jpa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


public class Trip implements Comparable<Trip>{

	protected String trainId;

	protected String trainType;

	private Long rank;

	protected Departure departure;

	protected ArrivalTerminus arrivalTerminus;

	public int compareTo(Trip trip) {
		return this.rank.compareTo(trip.getRank());
	}
	private Long getRank() {
		return this.rank;
	}
	public String getTrainId() {
		return trainId;
	}
	public String getTrainType() {
		return trainType;
	}
	public Departure getDeparture() {
		return departure;
	}
	public ArrivalTerminus getArrival() {
		return arrivalTerminus;
	}
}
