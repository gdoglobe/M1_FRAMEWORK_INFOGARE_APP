
package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class TrainStationDto {
	private String id;
	// idTrain/ dest/prov TrainInfo
	@XmlElement
	private List<ITrainDto> departureTrains;
	
	
	
	private List<ITrainDto> arrivalTrains;
	private List<DisturbanceTrainDto> disturbanceDepartureTrains;
	private List<DisturbanceTrainDto> disturbanceArrivalTrains;

	public TrainStationDto() {
		this.departureTrains = new ArrayList<ITrainDto>();
		this.arrivalTrains = new ArrayList<ITrainDto>();
		this.disturbanceDepartureTrains = new ArrayList<DisturbanceTrainDto>();
		this.disturbanceArrivalTrains = new ArrayList<DisturbanceTrainDto>();
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getDepartureToString() {

		StringBuilder sb = new StringBuilder();
		for (ITrainDto trainDto : departureTrains) {
			sb.append("\t\tTrainId : " + trainDto.getId() + "{\n");
			sb.append("\t\t"+trainDto.getDeparture().toString());
			sb.append("\t\t"+trainDto.getArrival().toString());
			for (ArrivalStopPointDto stopPoint : trainDto.getStopPoints()) {
				
				sb.append("\n\t\t\t StopPoint : " +stopPoint.toString());
			}
			sb.append("\n\t\t},\n");
		}
		return sb.toString();
	}

	public void addDepartureTrain(ITrainDto t) {
		this.departureTrains.add(t);
	}

	public void addArrivalTrain(ITrainDto t) {
		arrivalTrains.add(t);
	}

	public void addPerturbationDepart(DisturbanceTrainDto disturbanceTrainDto) {
		
		disturbanceDepartureTrains.add(disturbanceTrainDto);
	}

	public void addPerturbationArrive(DisturbanceTrainDto disturbanceTrainDto) {
		disturbanceArrivalTrains.add(disturbanceTrainDto);
	}
}