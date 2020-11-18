package fr.pantheonsorbonne.ufr27.miage.model.jaxb;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

public class TrainNoReservation extends TrainAbstractImpl{


	
	protected boolean reservation;
   
	public TrainNoReservation() {
			super.reservation = false;
    		List<Arrival> stopPoints = new ArrayList<Arrival>();
    		stopPoints.add(new Arrival("Tours", Long.valueOf(0), new Location("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()));
    		stopPoints.add(new Arrival("Limoges", Long.valueOf(1), new Location("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()));
    		TrainNoReservation t = new TrainNoReservation("TGV1", TrainTypeNoReservation.TER, new Departure("Paris", new Location("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new Arrival("Bordeaux", Long.valueOf(0), new Location("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new Location("1111111", "11111111"), stopPoints);
    		this.newinstance(t);
    }
    
    private void newinstance (TrainNoReservation t)
    {
    	this.id = t.getId();
        this.departure = t.getDeparture();
        this.arrival = t.getArrival();
        this.location = t.getLocation();
        this.stopPoints = t.getStopPoints();
    }
    
    public TrainNoReservation(String id, TrainTypeNoReservation trainTypeNoReservation, Departure departure, Arrival arrival,Location location, List<Arrival> stopPoints) {
        this.id = id;
        super.reservation = false;
        this.trainType = trainTypeNoReservation.toString();
        this.departure = departure;
        this.arrival = arrival;
        this.location = location;
        this.stopPoints = stopPoints;
    }

    public String getId() {
        return id;
    }
    public Location getLocation() {
		return this.location;
	}
    public void setId(String pId) {
        this.id = pId;
    }

	public Departure getDeparture() {
		return departure;
	}
	
	public Arrival getArrival() {
		this.arrival.setRank(Long.valueOf(stopPoints.size()));
		return arrival;
	}

	public List<Arrival> getStopPoints() {
		Collections.sort(this.stopPoints);
		return  this.stopPoints;
	}
	
	

	

    public void addStopPoint(Arrival stopPoint)
    {
    	this.stopPoints.add(stopPoint);
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
	
	public double getSpeedKM() {
		return speedKM;
	}
	public boolean isReservation() {
		return super.reservation;
	}
	
	
    
	@Override
	public String getLocationCoordinatesToString() {
		// TODO Auto-generated method stub
		return this.location.getCoordinatesToString();
	}
    
}
