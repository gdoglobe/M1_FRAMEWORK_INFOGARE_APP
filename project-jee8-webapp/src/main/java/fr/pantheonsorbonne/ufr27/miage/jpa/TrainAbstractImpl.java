package fr.pantheonsorbonne.ufr27.miage.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
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

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class TrainAbstractImpl implements ITrain{
	
	@Id
	protected String id;

	protected Location location;
	
	protected double speedKM;
	
	protected boolean reservation = false;

	protected String trainType;
	
	@OneToOne
	protected Departure departure;
	
	@OneToOne
	protected ArrivalTerminus arrivalTerminus;
	@OneToMany
	protected List<ArrivalStopPoint> stopPoints; //maybe LinkedList for rank insersion // or tree set to have sorted stop point
	
	//private String variationTimeEstimate;

	public TrainAbstractImpl() {
		this.id = "";
		this.departure = new Departure();
		this.arrivalTerminus = new ArrivalTerminus();
		this.location = new Location("", "");
		this.stopPoints = new ArrayList<ArrivalStopPoint>();
	}
	public TrainAbstractImpl(String id, ITrainType trainType, Departure departure, ArrivalTerminus arrivalTerminus,Location location, List<ArrivalStopPoint> stopPoints) {
		this.id = id;

		this.trainType = trainType.toString();
		this.departure = departure;
		this.arrivalTerminus = arrivalTerminus;
		this.location = location;
		this.stopPoints = stopPoints;
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

	
}