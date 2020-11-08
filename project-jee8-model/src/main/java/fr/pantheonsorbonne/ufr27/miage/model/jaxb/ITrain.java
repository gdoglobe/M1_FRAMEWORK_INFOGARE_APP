package fr.pantheonsorbonne.ufr27.miage.model.jaxb;


import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(TrainAbstractImpl.TrainXmlAdapter.class)
public interface ITrain {
	public String getId();
  
    public void setId(String pId); 
    public String getLocationCoordinatesToString();
	public Departure getDeparture(); 
	public Arrival getArrival();

	public List<Arrival> getStopPoints();

    public void addStopPoint(Arrival stopPoint);
    
}
