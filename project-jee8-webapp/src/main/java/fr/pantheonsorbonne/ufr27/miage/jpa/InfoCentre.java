package fr.pantheonsorbonne.ufr27.miage.jpa;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;



@Entity
public class InfoCentre {
	@Id
	private Long id;
	@OneToMany
	private List<TrainAbstractImpl> trains; //= new ArrayList<TrainAbstractImpl>();
	
	public InfoCentre() {	
		
	}
	
	
	public void addTrain(TrainAbstractImpl t) {
		trains.add(t);
	}
	
	public List<TrainAbstractImpl> getTrains() {
		return trains;
	}
		

}
