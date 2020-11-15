package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Arrival implements Comparable<Arrival> {
		@XmlElement
		private Long id;
		@XmlElement
		private String trainStationName;
		@XmlElement
		private Long rank;
		@XmlElement
		private Location location;
		@XmlElement
		@XmlJavaTypeAdapter(DateAdapter.class)
		private Date dateTime;
		public Arrival() {
			// TODO Auto-generated constructor stub
		}
		public Arrival(String name, Long rank, Location location, Date dateTime) {
			this.trainStationName = name;
			this.rank = rank;
			this.location = location;
			this.dateTime = dateTime;
		}
		
		
		
		public void setRank(Long rank) {
			this.rank = rank;
		}
		
		
		@Override
		public int compareTo(Arrival arrivale) {
			// TODO Auto-generated method stub
			return this.rank.compareTo(arrivale.getRank());
		}
		public Long getId() {
			return id;
		}
		public String getTrainStationName() {
			return trainStationName;
		}
		public Long getRank() {
			return rank;
		}
		public Location getLocation() {
			return this.location ;
		}
		public Date getDateTime() {
			return dateTime;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return 	"Arrival : [ rank "+this.getRank()+" , id = "+this.getId()+" , TrainStationName = "+this.getTrainStationName()+" , dateTime = "+this.getDateTime()+" ];\n";

		}
		
}
