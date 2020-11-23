package fr.pantheonsorbonne.ufr27.miage.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ArrivalStopPointEntityDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainEntityDto;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class TrainAbstract {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected String id;

	protected Location location;
	
	protected double speedKM;
	
	protected boolean reservation = false; 

	protected String trainType;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	protected Departure departure;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	protected ArrivalTerminus arrivalTerminus;
	@OneToMany(cascade=CascadeType.PERSIST)
	protected List<ArrivalStopPoint> stopPoints; //maybe LinkedList for rank insersion // or tree set to have sorted stop point
	
	//private String variationTimeEstimate;

	public TrainAbstract() {
		this.id = "";
		this.departure = new Departure();
		this.arrivalTerminus = new ArrivalTerminus();
		this.location = new Location("", "");
		this.stopPoints = new ArrayList<ArrivalStopPoint>();
	}
	public TrainAbstract(String id, ITrainType trainType, Departure departure, ArrivalTerminus arrivalTerminus,Location location, List<ArrivalStopPoint> stopPoints) {
		this.id = id;
		this.trainType = trainType.toString();
		this.departure = departure;
		this.arrivalTerminus = arrivalTerminus;
		this.location = location;
		this.stopPoints = stopPoints;
	}
	public  TrainEntityDto getDto()
	{
		List<ArrivalStopPointEntityDto> stopPointsEntityDto = new ArrayList<ArrivalStopPointEntityDto>();
		for(ArrivalStopPoint arrivalStopPoint : this.getStopPoints())
		{
			ArrivalStopPointEntityDto arrivalStopPointEntityDto = arrivalStopPoint.getDto();
			stopPointsEntityDto.add(arrivalStopPointEntityDto);
		}
		return new TrainEntityDto(this.getId(), this.getLocation().getDto(), this.getSpeedKM(), this.isReservation(), this.getTrainType(), this.getDeparture().getDto(), this.getArrival().getDto(), stopPointsEntityDto);
	}
	
	public void addStopPoint(ArrivalStopPoint stopPoint)
	{
		this.stopPoints.add(stopPoint);
	}

	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getTrainType() {
		return trainType;
	}
	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}
	public String getId() {
		return id;
	}
	public double getSpeedKM() {
		return speedKM;
	}
	public boolean isReservation() {
		return reservation;
	}
	public Departure getDeparture() {
		return departure;
	}
	public ArrivalTerminus getArrival() {
		return arrivalTerminus;
	}
	public List<ArrivalStopPoint> getStopPoints() {
		return stopPoints;
	}
	public ArrivalStopPoint getArrivalStopPointByStationName(String stationName)
	{
		for(ArrivalStopPoint stopPoint : this.stopPoints)
		{
			if(stopPoint.getStation().getName().equalsIgnoreCase(stationName))
				return stopPoint;
		}
		return null;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setSpeedKM(double speedKM) {
		this.speedKM = speedKM;
	}
	public void setReservation(boolean reservation) {
		this.reservation = reservation;
	}
	public void setDeparture(Departure departure) {
		this.departure = departure;
	}
	public void setArrivalTerminus(ArrivalTerminus arrivalTerminus) {
		this.arrivalTerminus = arrivalTerminus;
	}
	public void setStopPoints(List<ArrivalStopPoint> stopPoints) {
		this.stopPoints = stopPoints;
	}

	
}
