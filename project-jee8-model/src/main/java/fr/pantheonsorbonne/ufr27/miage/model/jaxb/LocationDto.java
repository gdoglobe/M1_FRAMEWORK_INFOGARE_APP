package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class LocationDto {
	@XmlElement
	private String logitude;
	@XmlElement
	private String latitude;
	
	
	public LocationDto() {
		this.logitude = "";
		this.latitude = "";
	
	}
	public LocationDto(String logitude, String latitude) {
		this.logitude = logitude;
		this.latitude = latitude;
	}
	public String getLogitude() {
		return logitude;
	}
	
	public void setLogitude(String logitude) {
		this.logitude = logitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public void setCoordinates(String logitude, String latitude) {
		this.logitude = logitude;
		this.latitude = latitude;
	}
	public String getCoordinatesToString() {
		return "Logitude : "+this.logitude+"; Latitude : "+ this.latitude;

	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Logitude : "+this.logitude+"; Latitude : "+ this.latitude;
	}
	
	
	
}
