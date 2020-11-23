package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ArrivalTerminusEntityDto {
	@XmlElement
	private Long id;
	@XmlElement
	private Integer rank;
	@XmlElement
	@XmlJavaTypeAdapter(DateAdapterDto.class)
	private Date dateTime;
	@XmlElement
	private StationEntityDto station;
	public ArrivalTerminusEntityDto() {}
	
	public ArrivalTerminusEntityDto(Long id, Integer rank, Date dateTime, StationEntityDto station) {
	
		this.id = id;
		this.setRank(rank);
		this.dateTime = dateTime;
		this.station = station;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
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
