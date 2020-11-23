package fr.pantheonsorbonne.ufr27.miage.jpa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Departure {
	@Id
	@GeneratedValue
	private Long id;
	private Date dateTime;
	@OneToOne
	private Station station;
	
	public Departure() {
		
	}
	
	public Departure(Date dateTime,Station station ) {
		this.dateTime = dateTime;
		this.station = station;
	}
	public Long getId() {
		return id;
	}
	
	public Date getDateTime() {
		return dateTime;
	}
	
	public Station getStation() {
		return this.station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	@Override
	public String toString() {
		return 	"Departure : [ id = "+this.getId()+" , TrainStationName = "+this.station.getName()+" , dateTime = "+this.getDateTime()+" ];\n";
	}
}
