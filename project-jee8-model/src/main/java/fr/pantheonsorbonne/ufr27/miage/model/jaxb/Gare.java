
package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class Gare {
	private String id;
	// idTrain/ dest/prov TrainInfo
	@XmlElement
	private List<ITrain> departureTrains;
	
	
	
	private List<ITrain> arrivalTrains;
	private List<DisturbanceTrain> disturbanceDepartureTrains;
	private List<DisturbanceTrain> disturbanceArrivalTrains;

	public Gare() {
		this.departureTrains = new ArrayList<ITrain>();
		this.arrivalTrains = new ArrayList<ITrain>();
		this.disturbanceDepartureTrains = new ArrayList<DisturbanceTrain>();
		this.disturbanceArrivalTrains = new ArrayList<DisturbanceTrain>();
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getDepartureToString() {

		StringBuilder sb = new StringBuilder();
		for (ITrain train : departureTrains) {
			sb.append("\t\tTrainId : " + train.getId() + "{\n");
			sb.append("\t\t"+train.getDeparture().toString());
			sb.append("\t\t"+train.getArrival().toString());
			for (Arrival stopPoint : train.getStopPoints()) {
				
				sb.append("\n\t\t\t StopPoint : " +stopPoint.toString());
			}
			sb.append("\n\t\t},\n");
		}
		return sb.toString();
	}

	public void addDepartureTrain(ITrain t) {
		this.departureTrains.add(t);
	}

	public void addArrivalTrain(ITrain t) {
		arrivalTrains.add(t);
	}

	public void addPerturbationDepart(DisturbanceTrain disturbanceTrain) {
		
		disturbanceDepartureTrains.add(disturbanceTrain);
	}

	public void addPerturbationArrive(DisturbanceTrain disturbanceTrain) {
		disturbanceArrivalTrains.add(disturbanceTrain);
	}
}
