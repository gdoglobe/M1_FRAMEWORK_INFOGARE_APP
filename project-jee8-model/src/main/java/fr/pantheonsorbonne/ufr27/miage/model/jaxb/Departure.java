package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class Departure {
	@XmlElement
	private Long id;
	@XmlElement
	private String name;
	@XmlElement
	private String location;
	@XmlElement
	private String dateTime;
	
	public Departure() {
		// TODO Auto-generated constructor stub
	}
	
	public Departure(String name, String location, String dateTime) {
		this.name = name;
		this.location = location;
		this.dateTime = dateTime;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
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
		return 	"Departure : [ id = "+this.getId()+" , name = "+this.getName()+" , dateTime = "+this.getDateTime()+" ];\n";

	}
}
