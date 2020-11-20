package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(ArrivalAbstractImplDto.ArrivalXmlAdapter.class)
public interface IArrivalDto {
	public void setRank(Integer rank) ;	
	public String getTrainStationName() ;
	public Integer getRank() ;
	public LocationDto getLocation() ;
	public Date getDateTime() ;
}
