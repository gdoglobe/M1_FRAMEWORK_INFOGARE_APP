package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Trip implements Comparable<Trip>{
	@XmlElement
	protected String trainId;
	@XmlElement
	protected String trainType;
	@XmlElement
	private Long rank;
	@XmlElement
	protected Departure departure;
	@XmlElement
	protected Arrival arrival;
	@Override
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
	public Arrival getArrival() {
		return arrival;
	}
}
