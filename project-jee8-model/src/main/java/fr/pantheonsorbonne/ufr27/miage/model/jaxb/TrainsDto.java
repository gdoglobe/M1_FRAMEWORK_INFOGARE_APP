package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TrainsDto {

	@XmlElement
	protected List<ITrainDto> trains;
	
	public TrainsDto() {
		this.trains = new ArrayList<ITrainDto>();
	}
	public List<ITrainDto> getTrains() {
		return trains;
	}
	public void setTrains(List<ITrainDto> trains) {
		this.trains = trains;
	}
	public void addTrain(ITrainDto t) {
		trains.add(t);
	}

}