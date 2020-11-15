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
	private List<TrainStation> trainStationList;
	
	//@XmlElement
	HashMap<String, TrainStation> trainStations;
	public InfoCentre() {
		// TODO Auto-generated constructor stub
		trains = new HashMap<String, ITrain>();
		trainStations = new HashMap<String, TrainStation>();
		//use index as key for set ins list
		trainStationList = new ArrayList<TrainStation>();
	}
	public HashMap<String, TrainStation> getGares() {
		return trainStations;
	}
	public String getGaresToString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("deparutres[\n");
		
		for(Entry<String, TrainStation> trainStation : trainStations.entrySet())
		{
			
			sb.append("\t"+trainStation.getKey()+"{==========================\n");
			
			TrainStation g = trainStation.getValue();
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
		
		TrainStation g = new TrainStation();
		
		if(trainStations.get(t.getDeparture().getTrainStationName()) != null )
		{
			g = trainStations.get(t.getDeparture().getTrainStationName());
			g.addDepartureTrain(t);
			trainStations.replace(t.getDeparture().getTrainStationName(), g);
		}
		else
		{
			g.setId(t.getDeparture().getTrainStationName());
			g.addDepartureTrain(t);			
			trainStations.putIfAbsent(t.getDeparture().getTrainStationName(), g);		
		}
		
		//### use index as key for set in list for optimisation
		trainStationList = new ArrayList<TrainStation>();
		for(Entry<String, TrainStation> trainStation : trainStations.entrySet())
		{
			trainStationList.add(trainStation.getValue());
		}
		
	}
	public void setArrive(ITrain t)
	{}
	

}
