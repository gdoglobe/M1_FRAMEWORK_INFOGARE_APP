package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import java.util.Date;

<<<<<<< HEAD
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
=======
>>>>>>> 0daeee1c89cbfd83476ee76144643d470f714b93
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement

public class ArrivalDto  {
		
	@XmlElement
	private Long id;
	@XmlElement
	private String stationName;
	
	@XmlElement
	@XmlJavaTypeAdapter(DateAdapterDto.class)
	private Date dateTime;
		
		public ArrivalDto() {
			// TODO Auto-generated constructor stub
		}
		
		public ArrivalDto(Long id, String name, Date dateTime) {
			this.id = id;
			this.stationName = name;
			this.dateTime = dateTime;
		}
		
		
		
		public Long getId() {
			return id;
		}
		public String getStationName() {
			return stationName;
		}
		
		public Date getDateTime() {
			return dateTime;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return 	"Arrival : [ "+" , TrainStationName = "+this.getStationName()+" , dateTime = "+this.getDateTime()+" ];\n";

		}
		
}