package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class ArrivalDto {
	@XmlElement
	private Long id;
	@XmlElement
	protected String stationName;
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
	/*public ArrivalDto(ArrivalAbstract arrivalAbstractJpa) {
		this.id = arrivalAbstractJpa.getId();
		this.dateTime = arrivalAbstractJpa.getDateTime();
		this.stationName = arrivalAbstractJpa.getStation().getName();	
	}*/
	
		
}


/*
public String getStationName() {
return stationName;
}
public Integer getRank() {
return rank;
}

public Date getDateTime() {
return dateTime;
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return 	"Arrival : [ rank "+this.getRank()+" , TrainStationName = "+this.getStationName()+" , dateTime = "+this.getDateTime()+" ];\n";

}
*/