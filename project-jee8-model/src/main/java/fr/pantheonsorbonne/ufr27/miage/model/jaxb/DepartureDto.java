package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class DepartureDto {
	@XmlElement
	private Long id;
	@XmlElement
	private String stationName;
	
	@XmlElement
	@XmlJavaTypeAdapter(DateAdapterDto.class)
	private Date dateTime;
	
	public DepartureDto() {
		// TODO Auto-generated constructor stub
	}
	
	public DepartureDto(Long id, String stationName, Date dateTime) {
		this.id = id;
		this.stationName = stationName;
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
		return 	"Departure : [ id = "+this.getId()+" , TrainStationName = "+this.getStationName()+" , dateTime = "+this.getDateTime()+" ];\n";
	}
}
