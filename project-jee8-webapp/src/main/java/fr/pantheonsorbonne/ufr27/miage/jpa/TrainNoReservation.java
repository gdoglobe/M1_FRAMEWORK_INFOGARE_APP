package fr.pantheonsorbonne.ufr27.miage.jpa;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class TrainNoReservation extends TrainAbstract{


	
	//protected boolean reservation;
   
	public TrainNoReservation() {
			super.reservation = false;
            this.trainType = "";
            this.departure = new Departure();           		
            this.arrivalTerminus = new ArrivalTerminus();
            this.location = new Location();
            this.stopPoints = new ArrayList<ArrivalStopPoint>();
    }
    
    private void newinstance (TrainNoReservation t)
    {
    	this.id = t.getId();
        this.departure = t.getDeparture();
        this.arrivalTerminus = t.getArrival();
        this.location = t.getLocation();
        this.stopPoints = t.getStopPoints();
    }
    
    public TrainNoReservation(String id, TrainTypeNoReservation trainTypeNoReservation, Departure departure, ArrivalTerminus arrivalTerminus,Location location, List<ArrivalStopPoint> stopPoints) {
        this.id = id;
        super.reservation = false;
        this.trainType = trainTypeNoReservation.toString();
        this.departure = departure;
        this.arrivalTerminus = arrivalTerminus;
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
	
	public ArrivalTerminus getArrival() {
		this.arrivalTerminus.setRank(stopPoints.size());
		return arrivalTerminus;
	}

	public List<ArrivalStopPoint> getStopPoints() {
		Collections.sort( this.stopPoints);
		return  this.stopPoints;
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
	
	public void addStopPoint(ArrivalStopPoint stopPoint)
	{
		this.stopPoints.add(stopPoint);
	}

    
	
    
}
