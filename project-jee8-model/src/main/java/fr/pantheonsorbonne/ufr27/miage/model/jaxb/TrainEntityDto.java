package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TrainEntityDto {
	@XmlElement
	private String id;

	@XmlElement
	private LocationDto location;
	@XmlElement
	private double speedKM = 0;
	@XmlElement
	private boolean reservation = false;
	@XmlElement
	private String trainType;
	
	@XmlElement
	private DepartureEntityDto departure;
	
	@XmlElement
	private ArrivalTerminusEntityDto arrivalTerminus;
	@XmlElement
	private List<ArrivalStopPointEntityDto> stopPoints;
	public TrainEntityDto() {}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocationDto getLocation() {
		return location;
	}
	public void setLocation(LocationDto location) {
		this.location = location;
	}
	public double getSpeedKM() {
		return speedKM;
	}
	public void setSpeedKM(double speedKM) {
		this.speedKM = speedKM;
	}
	public boolean isReservation() {
		return reservation;
	}
	public void setReservation(boolean reservation) {
		this.reservation = reservation;
	}
	public String getTrainType() {
		return trainType;
	}
	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}
	public DepartureEntityDto getDeparture() {
		return departure;
	}
	public void setDeparture(DepartureEntityDto departure) {
		this.departure = departure;
	}
	public ArrivalTerminusEntityDto getArrivalTerminus() {
		return arrivalTerminus;
	}
	public void setArrivalTerminus(ArrivalTerminusEntityDto arrivalTerminus) {
		this.arrivalTerminus = arrivalTerminus;
	}
	public List<ArrivalStopPointEntityDto> getStopPoints() {
		return stopPoints;
	}
	public void setStopPoints(List<ArrivalStopPointEntityDto> stopPoints) {
		this.stopPoints = stopPoints;
	}
	public TrainEntityDto(String id, LocationDto location, double speedKM, boolean reservation, String trainType,
			DepartureEntityDto departure, ArrivalTerminusEntityDto arrivalTerminus,
			List<ArrivalStopPointEntityDto> stopPoints) {
		this.id = id;
		this.location = location;
		this.speedKM = speedKM;
		this.reservation = reservation;
		this.trainType = trainType;
		this.departure = departure;
		this.arrivalTerminus = arrivalTerminus;
		this.stopPoints = stopPoints;
	}
	
	

}
