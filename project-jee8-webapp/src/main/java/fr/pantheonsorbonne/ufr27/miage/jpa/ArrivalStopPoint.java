package fr.pantheonsorbonne.ufr27.miage.jpa;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ArrivalStopPointEntityDto;

@Entity
public class ArrivalStopPoint{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer rank;
	private Date dateTime;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Station station;
	
	public ArrivalStopPoint() {
		
	}
	public ArrivalStopPoint(Long id, Integer rank, Date dateTime, Station station) {
		this.rank = rank;
		this.dateTime = dateTime;
		this.station = station;
		this.id = id;
	}
	
	public ArrivalStopPoint(ArrivalStopPointEntityDto arrivalStopPointEntityDto) {
		this.rank = arrivalStopPointEntityDto.getRank();
		this.dateTime = arrivalStopPointEntityDto.getDateTime();
		this.station = new Station(arrivalStopPointEntityDto.getStation());
		this.id = arrivalStopPointEntityDto.getId();
	}
	public ArrivalStopPointEntityDto getDto()
	{
		return new ArrivalStopPointEntityDto(this.getId(), this.getRank(), this.getDateTime(), station.getDto());
	}
	
	
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
	
	
	public int compareTo(ArrivalStopPoint arrivale) {
		// TODO Auto-generated method stub
		return this.rank.compareTo(arrivale.getRank());
	}
	public Long getId() {
		return id;
	}
	
	public Integer getRank() {
		return rank;
	}
	
	public Date getDateTime() {
		return dateTime;
	}
	public Station getStation() {
		return this.station;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return 	"Arrival : [ rank "+this.getRank()+" , id = "+this.getId()+" , TrainStationName = "+this.getStation().getName() +" , dateTime = "+this.getDateTime()+" ];\n";

	}
	
}
