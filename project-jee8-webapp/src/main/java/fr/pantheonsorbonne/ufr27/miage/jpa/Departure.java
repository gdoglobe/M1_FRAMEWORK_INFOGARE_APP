package fr.pantheonsorbonne.ufr27.miage.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ArrivalTerminusEntityDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.DepartureEntityDto;


@Entity
public class Departure{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date dateTime;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Station station;
	
	public Departure() {
		
	}
	
	public Departure(Long id, Date dateTime,Station station) {
		this.dateTime = dateTime;
		this.station = station;
		this.id = id;
	}
	
	public Departure(DepartureEntityDto departureEntityDto) {
		this.dateTime = departureEntityDto.getDateTime();
		this.station = new Station(departureEntityDto.getStation());
		this.id = departureEntityDto.getId();
	}
	public Departure(Date dateTime,Station station) {
		this.dateTime = dateTime;
		this.station = station;
	}

	public DepartureEntityDto getDto()
	{
		return new DepartureEntityDto(this.getId(), this.getDateTime(), station.getDto());
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
