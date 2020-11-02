package fr.pantheonsorbonne.ufr27.miage.model.jaxb;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class Train {
	@XmlElement
	private String id;
	//@XmlElement
    private Departure departure;
	//@XmlElement
    private Arrival arrival;
	
    //maybe LinkedList for rank insersion // or tree set to have sorted stop point
	//@XmlElement
    private List<Arrival> stopPoints;
	@XmlElement
    private String location;
    
    public Train() {
    }

    public String getLocation() {
		return location;
	}

	public Train(String id, Departure departure, Arrival arrival,String location, List<Arrival> stopPoints) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
        this.location = location;
        this.stopPoints = stopPoints;
        
        
    }

    public String getId() {
        return id;
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
}
