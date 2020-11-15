package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.XmlAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class TrainAbstractImpl implements ITrain{
	@XmlElement
	protected String id;


	@XmlElement
	protected Location location;
	//====================
	@XmlElement
	protected double speedKM;
	@XmlElement
	protected boolean reservation = false;
	//@XmlElement

	@XmlElement
	protected String trainType;
	//====================
	@XmlElement
	protected Departure departure;
	@XmlElement
	protected Arrival arrival;
	@XmlElement
	protected List<Arrival> stopPoints; //maybe LinkedList for rank insersion // or tree set to have sorted stop point


	public TrainAbstractImpl() {
		this.id = "";
		this.departure = new Departure();
		this.arrival = new Arrival();
		this.location = new Location("", "");
		this.stopPoints = new ArrayList<Arrival>();
	}
	public TrainAbstractImpl(String id, ITrainType trainType, Departure departure, Arrival arrival,Location location, List<Arrival> stopPoints) {
		this.id = id;

		this.trainType = trainType.toString();
		this.departure = departure;
		this.arrival = arrival;
		this.location = location;
		this.stopPoints = stopPoints;

	}

	static class TrainXmlAdapter  extends XmlAdapter<TrainAbstractImpl,ITrain>{

		@Override
		public ITrain unmarshal(TrainAbstractImpl v) throws Exception {
			// TODO Auto-generated method stub
			return v;
		}

		@Override
		public TrainAbstractImpl marshal(ITrain v) throws Exception {
			// TODO Auto-generated method stub
			return (TrainAbstractImpl)v;
		}

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
	public Arrival getArrival() {
		return arrival;
	}
	public List<Arrival> getStopPoints() {
		return stopPoints;
	}

}
