package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DepartureEntityDto {
	@XmlElement
	private Long id;
	@XmlElement
	@XmlJavaTypeAdapter(DateAdapterDto.class)
	private Date dateTime;
	
	@XmlElement
	private StationEntityDto station;
	
	public DepartureEntityDto() {}
	public DepartureEntityDto(Long id, Date dateTime, StationEntityDto station) {
		this.id = id;
		this.dateTime = dateTime;
		this.station = station;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public StationEntityDto getStation() {
		return station;
	}
	public void setStation(StationEntityDto station) {
		this.station = station;
	}
}
