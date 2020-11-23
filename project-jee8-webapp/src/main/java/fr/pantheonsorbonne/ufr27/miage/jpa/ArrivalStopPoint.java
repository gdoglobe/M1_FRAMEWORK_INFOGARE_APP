package fr.pantheonsorbonne.ufr27.miage.jpa;

import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class ArrivalStopPoint{
	
	@Id
	private Long id;
	private Integer rank;
	private Date dateTime;
	private Station station;
	
	public ArrivalStopPoint() {
		
	}
	public ArrivalStopPoint(Integer rank, Date dateTime, Station station) {
		this.rank = rank;
		this.dateTime = dateTime;
		this.station = station;
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
