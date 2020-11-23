package fr.pantheonsorbonne.ufr27.miage.jpa;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ArrivalTerminusEntityDto;



@Entity
public class ArrivalTerminus {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer rank;
	private Date dateTime;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Station station;
		public ArrivalTerminus() {
			
		}
		public ArrivalTerminus(Long id, Integer rank, Date dateTime, Station station) {
			this.rank = rank;
			this.dateTime = dateTime;
			this.station = station;
			this.id = id;
		}
		public ArrivalTerminus(ArrivalTerminusEntityDto arrivalTerminusEntityDto) {
			this.rank = arrivalTerminusEntityDto.getRank();
			this.dateTime = arrivalTerminusEntityDto.getDateTime();
			this.station = new Station(arrivalTerminusEntityDto.getStation());
			this.id = arrivalTerminusEntityDto.getId();
		}
		
		
		public ArrivalTerminusEntityDto getDto()
		{
			return new ArrivalTerminusEntityDto(this.getId(), this.getRank(), this.getDateTime(), station.getDto());
		}
		public void setRank(Integer rank) {
			this.rank = rank;
		}
		
		
		
		public int compareTo(ArrivalTerminus arrivale) {
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
			return 	"Arrival : [  id = "+this.getId()+" , rank "+this.getRank()+" , TrainStationName = "+this.getStation().getName() +" , dateTime = "+this.getDateTime()+" ];\n";

		}
		
}
