package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class ArrivalAbstractImplDto implements IArrivalDto,Comparable<ArrivalAbstractImplDto>{
	@XmlElement
	protected String trainStationName;
	@XmlElement
	protected Integer rank;
	@XmlElement
	protected LocationDto locationDto;
	@XmlElement
	@XmlJavaTypeAdapter(DateAdapterDto.class)
	protected Date dateTime;
	
	
	public int compareTo(ArrivalAbstractImplDto arrivalAbstractImplDto) {		
		return this.rank.compareTo(arrivalAbstractImplDto.getRank());
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
	
	static class ArrivalXmlAdapter  extends XmlAdapter<ArrivalAbstractImplDto,IArrivalDto>{

		@Override
		public IArrivalDto unmarshal(ArrivalAbstractImplDto v) throws Exception {
			// TODO Auto-generated method stub
			return v;
		}

		@Override
		public ArrivalAbstractImplDto marshal(IArrivalDto v) throws Exception {
			// TODO Auto-generated method stub
			return (ArrivalAbstractImplDto)v;
		}

	}
}
