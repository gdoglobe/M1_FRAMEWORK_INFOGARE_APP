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
	private String trainStationName;
	@XmlElement
	private LocationDto locationDto;
	
	@XmlElement
	@XmlJavaTypeAdapter(DateAdapterDto.class)
	private Date dateTime;
	
	public DepartureDto() {
		// TODO Auto-generated constructor stub
	}
	
	public DepartureDto(String name, LocationDto locationDto, Date dateTime) {
		this.trainStationName = name;
		this.locationDto = locationDto;
		this.dateTime = dateTime;
	}
	public Long getId() {
		return id;
	}
	public String getTrainStationName() {
		return trainStationName;
	}
	public LocationDto getLocation() {
		return this.locationDto;
	}
	public Date getDateTime() {
		return dateTime;
	}
	@Override
	public String toString() {
		return 	"Departure : [ id = "+this.getId()+" , TrainStationName = "+this.getTrainStationName()+" , dateTime = "+this.getDateTime()+" ];\n";
	}
}
