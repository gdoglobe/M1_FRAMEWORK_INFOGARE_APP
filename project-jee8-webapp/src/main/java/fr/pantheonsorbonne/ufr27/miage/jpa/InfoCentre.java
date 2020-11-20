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




public class InfoCentre {
	
	private Long id;
	
	
	private List<ITrain> trains = new ArrayList<ITrain>();
	
	public InfoCentre() {	
		
	}
	
	
	public void addTrain(TrainReservation t) {
		trains.add(t);
	}
	
	public List<ITrain> getTrains() {
		return trains;
	}
		

}
