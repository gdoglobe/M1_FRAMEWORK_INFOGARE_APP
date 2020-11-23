package fr.pantheonsorbonne.ufr27.miage.jpa;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.bind.annotation.XmlRootElement;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ITrainDto;

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
	private List<TrainAbstract> trains; //= new ArrayList<TrainAbstractImpl>();
	
	public InfoCentre() {	
		
	}
	
	
	public void addTrain(TrainAbstract t) {
		trains.add(t);
	}
	
	public List<TrainAbstract> getTrains() {
		return trains;
	}
		
	

	public double calculerTrainVariationDepart(TrainAbstract t)
	{
		return 0;	
	}
	public double calculerTrainVariationArrive(TrainAbstract t)
	{
		return 0;
	}

}
