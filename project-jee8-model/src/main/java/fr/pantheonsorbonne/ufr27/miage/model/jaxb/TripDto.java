package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TripDto implements Comparable<TripDto>{
	@XmlElement
	protected String trainId;
	@XmlElement
	protected String trainType;
	@XmlElement
	private Long rank;
	@XmlElement
	protected DepartureDto departureDto;
	@XmlElement
	protected ArrivalTerminusDto arrivalTerminusDto;
	@Override
	public int compareTo(TripDto tripDto) {
		return this.rank.compareTo(tripDto.getRank());
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
	public DepartureDto getDeparture() {
		return departureDto;
	}
	public ArrivalTerminusDto getArrival() {
		return arrivalTerminusDto;
	}
}
