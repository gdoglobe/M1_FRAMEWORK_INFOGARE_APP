package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Location {
	@XmlElement
	private String logitude;
	@XmlElement
	private String latitude;
	private String adress;
	
	public Location() {
		this.logitude = "";
		this.latitude = "";
		this.adress = "";
	}
	public Location(String logitude, String latitude) {
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
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
