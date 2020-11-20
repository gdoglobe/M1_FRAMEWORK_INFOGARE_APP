package fr.pantheonsorbonne.ufr27.miage.model.jaxb;


import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(TrainAbstractImplDto.TrainXmlAdapter.class)
public interface ITrainDto {
	public String getId();
  
    public void setId(String pId); 
    public String getLocationCoordinatesToString();
	public DepartureDto getDeparture(); 
	public ArrivalTerminusDto getArrival();

	public List<ArrivalStopPointDto> getStopPoints();

    public void addStopPoint(ArrivalStopPointDto stopPoint);
    
}
