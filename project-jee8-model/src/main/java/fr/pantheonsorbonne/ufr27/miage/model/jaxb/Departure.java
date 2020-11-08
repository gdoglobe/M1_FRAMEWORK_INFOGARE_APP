package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class Departure {
	@XmlElement
	private Long id;
	@XmlElement
	private String name;
	@XmlElement
	private Location location;
	
	@XmlElement
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date dateTime;
	
	public Departure() {
		// TODO Auto-generated constructor stub
	}
	
	public Departure(String name, Location location, Date dateTime) {
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
	public Location getLocation() {
		return this.location;
	}
	public Date getDateTime() {
		return dateTime;
	}
	@Override
	public String toString() {
		return 	"Departure : [ id = "+this.getId()+" , name = "+this.getName()+" , dateTime = "+this.getDateTime()+" ];\n";
	}
}
