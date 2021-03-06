package fr.pantheonsorbonne.ufr27.miage.model.jaxb;



import java.util.HashMap;
import java.util.HashSet;

import java.util.Map.Entry;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlElement;


@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)

public class InfoCentreDto {
	@XmlElement
	private String id;

	//@XmlElement
	private Set<TrainStationDto> trainStationList;
	@XmlElement
	private TrainsDto trainsDto;
	
	
	//@XmlElement
	//private List<TrainStationDto> trainStationList;

	

	HashMap<String, TrainStationDto> trainStationDtos;
	
	public InfoCentreDto() {

		
		trainStationDtos = new HashMap<String, TrainStationDto>();
		//use index as key for set ins list
		
		trainStationList = new HashSet<TrainStationDto>();
		//trainStationList = new ArrayList<TrainStationDto>();
		
		trainsDto = new TrainsDto();

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
	
	public void addTrainDto(ITrainDto t)
	{
		this.trainsDto.addTrain(t);
	}

	public TrainsDto getTrainsDto() {
		return trainsDto;
	}

	public void setTrainsDto(TrainsDto trainsDto) {
		this.trainsDto = trainsDto;
	}
	

}
