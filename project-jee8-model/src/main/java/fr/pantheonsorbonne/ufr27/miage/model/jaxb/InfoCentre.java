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
	HashMap<String, Train> trains;
	
	@XmlElement
	private List<Gare> garesList;
	
	HashMap<String, Gare> gares;
	public InfoCentre() {
		// TODO Auto-generated constructor stub
		trains = new HashMap<String, Train>();
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
	public void addTrain(Train t) {
		//t.getDeparture();
		trains.put(t.getId(), t);
	}
	
	public HashMap<String, Train> getTrains() {
		return trains;
	}
	public double calculerTrainVariationDepart(Train t)
	{
		return 0;	
	}
	public double calculerTrainVariationArrive(Train t)
	{
		return 0;
	}
	
	public void addDeparture(Train t)
	{
		
		Gare g = new Gare();
		
		if(gares.get(t.getDeparture().getName()) != null )
		{
			
			g = gares.get(t.getDeparture().getName());
			
			g.addDepartureTrain(t);
			//(t.getId(), t.getArrival(), new TraiSystem.out.println("   InfoCentr 4");
			gares.replace(t.getDeparture().getName(), g);
			
		}
		else
		{
			g.setId(t.getDeparture().getName());
			//g.addTrainDeparture(t.getId(), t.getArrival(), new TrainInfo(t.getLocation(),t.getDepartureTime(),t.getAvrrivalTime(),"300s"));
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
	public void setArrive(Train t)
	{}
	

}
