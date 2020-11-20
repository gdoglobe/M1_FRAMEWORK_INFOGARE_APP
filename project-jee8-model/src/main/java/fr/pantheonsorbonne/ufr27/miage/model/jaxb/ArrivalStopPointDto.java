package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import java.util.Date;

public class ArrivalStopPointDto extends ArrivalAbstractImplDto {
	
	
	
	public ArrivalStopPointDto() {
		// TODO Auto-generated constructor stub
	}
	public ArrivalStopPointDto(String name, Integer rank, LocationDto locationDto, Date dateTime) {
		this.trainStationName = name;
		this.rank = rank;
		this.locationDto = locationDto;
		this.dateTime = dateTime;
	}
	
	
	
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
	public int compareTo(ArrivalStopPointDto arrivale) {
		// TODO Auto-generated method stub
		return this.rank.compareTo(arrivale.getRank());
	}
	
	public String getTrainStationName() {
		return trainStationName;
	}
	public Integer getRank() {
		return rank;
	}
	public LocationDto getLocation() {
		return this.locationDto ;
	}
	public Date getDateTime() {
		return dateTime;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return 	"Arrival : [ rank "+this.getRank()+" , TrainStationName = "+this.getTrainStationName()+" , dateTime = "+this.getDateTime()+" ];\n";

	}
	
}
