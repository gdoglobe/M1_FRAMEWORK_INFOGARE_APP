package fr.pantheonsorbonne.ufr27.miage.jpa;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.MissingFormatArgumentException;

import javax.persistence.Entity;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ArrivalStopPointEntityDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainEntityDto;



@Entity
public class TrainReservation extends TrainAbstract{

	//protected boolean reservation;

	public TrainReservation() {
		super.reservation = true;
        this.trainType = "";
        this.departure = new Departure();           		
        this.arrivalTerminus = new ArrivalTerminus();
        this.location = new Location();
        this.stopPoints = new ArrayList<ArrivalStopPoint>();
	}

	public TrainReservation (TrainEntityDto trainEntityDto)
    {
    	if(trainEntityDto.isReservation())
    	{
    		this.id = trainEntityDto.getId();
    		this.trainType = trainEntityDto.getTrainType();
    		super.reservation = trainEntityDto.isReservation();
    		this.departure = new Departure(trainEntityDto.getDeparture());
    		this.arrivalTerminus = new ArrivalTerminus(trainEntityDto.getArrivalTerminus());
    		this.location = new Location(trainEntityDto.getLocation());
    		this.stopPoints = new ArrayList<ArrivalStopPoint>();
    		for(ArrivalStopPointEntityDto arrivalStopPointEntityDto : trainEntityDto.getStopPoints())
    		{
    			ArrivalStopPoint arrivalStopPoint = new ArrivalStopPoint(arrivalStopPointEntityDto);
    			this.stopPoints.add(arrivalStopPoint);
    		}
        }
    	else
    	{
    		throw new MissingFormatArgumentException("Reservation must be true");
    	}
        
    }
    

	public TrainReservation(String id, TrainTypeReservation trainreservationtype, Departure departure, ArrivalTerminus arrivalTerminus,Location location, List<ArrivalStopPoint> stopPoints) {
		this.id = id;
		super.reservation = true;
		this.trainType = trainreservationtype.toString();
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
	public List<ArrivalStopPoint> getStopPoints() {
		return  this.stopPoints;
	}

	public void addStopPoint(ArrivalStopPoint stopPoint)
	{
		this.stopPoints.add(stopPoint);
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

}
