package fr.pantheonsorbonne.ufr27.miage.model.jaxb;


import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class InfoCentre {
	
	private String id;
	HashMap<String, Train> trains;
	HashMap<String, Gare> gares;
	public InfoCentre() {
		// TODO Auto-generated constructor stub
		trains = new HashMap<String, Train>();
		gares = new HashMap<String, Gare>();
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
		System.out.println(sb.toString());
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
	
	public void setDepart(Train t)
	{
		System.out.println("   InfoCentr 1");
		Gare g = new Gare();;
		System.out.println("   InfoCentr 1/1 "+t.getDeparture());
		if(gares.get(t.getDeparture()) != null )
		{
			System.out.println("   InfoCentr 2");
			g = gares.get(t.getDeparture());
			System.out.println("   InfoCentr 3");
			g.addTrainDeparture(t.getId(), t.getArrival(), new TrainInfo(t.getLocation(),t.getDepartureTime(),t.getAvrrivalTime(),"300s"));
			System.out.println("   InfoCentr 4");
			gares.replace(t.getDeparture(), g);
			System.out.println("   InfoCentr 5");
		}
		else
		{
			System.out.println("   InfoCentr 6");
			g.setId(t.getDeparture());
			g.addTrainDeparture(t.getId(), t.getArrival(), new TrainInfo(t.getLocation(),t.getDepartureTime(),t.getAvrrivalTime(),"300s"));
			System.out.println("   InfoCentr 7");
			
			gares.putIfAbsent(t.getDeparture(), g);
			System.out.println("   InfoCentr 8");
		}
	}
	public void setArrive(Train t)
	{}
	

}
