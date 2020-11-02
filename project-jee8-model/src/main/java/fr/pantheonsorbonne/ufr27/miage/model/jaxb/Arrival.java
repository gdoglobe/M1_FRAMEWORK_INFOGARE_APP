package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class Arrival implements Comparable<Arrival> {
		//@XmlElement
		private Long id;
		private String name;
		//@XmlElement
		private Long rank;
		//@XmlElement
		private String location;
		//@XmlElement
		private String dateTime;
		public Arrival(String name, Long rank, String location, String dateTime) {
			this.name = name;
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
		public String getName() {
			return name;
		}
		public Long getRank() {
			return rank;
		}
		public String getLocation() {
			return location;
		}
		public String getDateTime() {
			return dateTime;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return 	"Arrival : [ rank "+this.getRank()+" , id = "+this.getId()+" , name = "+this.getName()+" , dateTime = "+this.getDateTime()+" ];\n";

		}
		
}
