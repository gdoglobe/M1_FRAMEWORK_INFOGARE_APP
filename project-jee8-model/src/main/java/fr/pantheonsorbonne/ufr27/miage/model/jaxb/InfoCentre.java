package fr.pantheonsorbonne.ufr27.miage.model.jaxb;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class InfoCentre {
	
	private String id;
	
	HashMap<String, ITrain> trains;
	@XmlElement
	private List<Gare> garesList;
	
	//@XmlElement
	HashMap<String, Gare> gares;
	public InfoCentre() {
		// TODO Auto-generated constructor stub
		trains = new HashMap<String, ITrain>();
		gares = new HashMap<String, Gare>();
		//use index as key for set ins list
		garesList = new ArrayList<Gare>();
	}
	public HashMap<String, Gare> getGares() {
		return gares;
	}
	public String getGaresToString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("deparutres[\n");
		
		for(Entry<String, Gare> gare : gares.entrySet())
		{
			
			sb.append("\t"+gare.getKey()+"{==========================\n");
			
			Gare g = gare.getValue();
			sb.append(g.getDepartureToString()+"\n\t};\n");
		}
		sb.append("]");
		//System.out.println(sb.toString());
		return sb.toString();
	}
	public void addTrain(TrainReservation t) {
		//t.getDeparture();
		trains.put(t.getId(), t);
	}
	
	public HashMap<String, ITrain> getTrains() {
		return trains;
	}
	public double calculerTrainVariationDepart(ITrain t)
	{
		return 0;	
	}
	public double calculerTrainVariationArrive(ITrain t)
	{
		return 0;
	}
	
	public void addDeparture(ITrain t)
	{
		
		Gare g = new Gare();
		
		if(gares.get(t.getDeparture().getName()) != null )
		{
			g = gares.get(t.getDeparture().getName());
			g.addDepartureTrain(t);
			gares.replace(t.getDeparture().getName(), g);
		}
		else
		{
			g.setId(t.getDeparture().getName());
			g.addDepartureTrain(t);			
			gares.putIfAbsent(t.getDeparture().getName(), g);		
		}
		
		//### use index as key for set in list for optimisation
		garesList = new ArrayList<Gare>();
		for(Entry<String, Gare> gare : gares.entrySet())
		{
			garesList.add(gare.getValue());
		}
		
	}
	public void setArrive(ITrain t)
	{}
	

}
