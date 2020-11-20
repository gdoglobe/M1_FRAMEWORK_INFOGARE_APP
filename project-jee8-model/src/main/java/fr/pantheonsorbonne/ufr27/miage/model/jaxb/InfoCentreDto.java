package fr.pantheonsorbonne.ufr27.miage.model.jaxb;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)

public class InfoCentreDto {
	
	private String id;
	
	HashMap<String, ITrainDto> trainDtos;
	
	@XmlElement
	private Set<TrainStationDto> trainStationList;	
	//@XmlElement
	//private List<TrainStationDto> trainStationList;
	
	
	@XmlElement
	HashMap<String, TrainStationDto> trainStationDtos;
	public InfoCentreDto() {
		// TODO Auto-generated constructor stub
		trainDtos = new HashMap<String, ITrainDto>();
		trainStationDtos = new HashMap<String, TrainStationDto>();
		//use index as key for set ins list
		
		trainStationList = new HashSet<TrainStationDto>();
		//trainStationList = new ArrayList<TrainStationDto>();
	}
	public HashMap<String, TrainStationDto> getGares() {
		return trainStationDtos;
	}
	public String getGaresToString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("deparutres[\n");
		
		for(Entry<String, TrainStationDto> trainStationDto : trainStationDtos.entrySet())
		{
			
			sb.append("\t"+trainStationDto.getKey()+"{==========================\n");
			
			TrainStationDto g = trainStationDto.getValue();
			sb.append(g.getDepartureToString()+"\n\t};\n");
		}
		sb.append("]");
		//System.out.println(sb.toString());
		return sb.toString();
	}
	public void addTrain(TrainReservationDto t) {
		//t.getDeparture();
		trainDtos.put(t.getId(), t);
	}
	
	public HashMap<String, ITrainDto> getTrains() {
		return trainDtos;
	}
	public double calculerTrainVariationDepart(ITrainDto t)
	{
		return 0;	
	}
	public double calculerTrainVariationArrive(ITrainDto t)
	{
		return 0;
	}
	
	public void addDeparture(ITrainDto t)
	{
		
		TrainStationDto g = new TrainStationDto();
		
		if(trainStationDtos.get(t.getDeparture().getTrainStationName()) != null )
		{
			g = trainStationDtos.get(t.getDeparture().getTrainStationName());
			g.addDepartureTrain(t);
			trainStationDtos.replace(t.getDeparture().getTrainStationName(), g);
		}
		else
		{
			g.setId(t.getDeparture().getTrainStationName());
			g.addDepartureTrain(t);			
			trainStationDtos.putIfAbsent(t.getDeparture().getTrainStationName(), g);		
		}
		
		//### use index as key for set in list for optimisation
		//trainStationList = new HashSet<TrainStationDto>();
		//trainStationList = new ArrayList<TrainStationDto>();
		for(Entry<String, TrainStationDto> trainStationDto : trainStationDtos.entrySet())
		{
			trainStationList.add(trainStationDto.getValue());
		}
		
	}
	public void setArrive(ITrainDto t)
	{}
	

}
