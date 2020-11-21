package fr.pantheonsorbonne.ufr27.miage.model.jaxb;


import java.util.List;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(TrainAbstractImplDto.TrainXmlAdapter.class)
public interface ITrainDto {
	public String getId();

  
    public void setId(String id); 
	public DepartureDto getDeparture(); 
	public ArrivalDto getArrival();

	//public List<ArrivalStopPointDto> getStopPoints();

    //public void addStopPoint(ArrivalStopPointDto stopPoint);
	//public String getLocationCoordinatesToString();
    

}
