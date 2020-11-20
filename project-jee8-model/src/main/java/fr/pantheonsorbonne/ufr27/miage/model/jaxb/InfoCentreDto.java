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
	
	@XmlElement
	HashMap<String, TrainStationDto> trainStationDtos;
	
	public InfoCentreDto() {
		trainStationDtos = new HashMap<String, TrainStationDto>();		
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
	
	

	
	public void addDeparture(ITrainDto t)
	{
		
		TrainStationDto g = new TrainStationDto();
		
		if(trainStationDtos.get(t.getDeparture().getStationName()) != null )
		{
			g = trainStationDtos.get(t.getDeparture().getStationName());
			g.addDepartureTrain(t);
			trainStationDtos.replace(t.getDeparture().getStationName(), g);
		}
		else
		{
			g.setId(t.getDeparture().getStationName());
			g.addDepartureTrain(t);			
			trainStationDtos.putIfAbsent(t.getDeparture().getStationName(), g);		
		}
		
		
		
	}
	public void addArrival(ITrainDto t)
	{}
	

}
