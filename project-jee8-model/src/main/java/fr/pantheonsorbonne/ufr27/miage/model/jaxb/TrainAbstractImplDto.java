package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.XmlAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class TrainAbstractImplDto implements ITrainDto{
	@XmlElement
	protected String id;


	@XmlElement
	protected LocationDto locationDto;
	//====================
	@XmlElement
	protected double speedKM;
	@XmlElement
	protected boolean reservation = false;
	//@XmlElement

	@XmlElement
	protected String trainType;
	//====================
	@XmlElement
	protected DepartureDto departureDto;
	@XmlElement
	protected ArrivalTerminusDto arrivalTerminusDto;
	@XmlElement
	protected List<ArrivalStopPointDto> stopPoints; //maybe LinkedList for rank insersion // or tree set to have sorted stop point


	public TrainAbstractImplDto() {
		this.id = "";
		this.departureDto = new DepartureDto();
		this.arrivalTerminusDto = new ArrivalTerminusDto();
		this.locationDto = new LocationDto("", "");
		this.stopPoints = new ArrayList<ArrivalStopPointDto>();
	}
	public TrainAbstractImplDto(String id, ITrainTypeDto trainTypeDto, DepartureDto departureDto, ArrivalTerminusDto arrivalTerminusDto,LocationDto locationDto, List<ArrivalStopPointDto> stopPoints) {
		this.id = id;

		this.trainType = trainTypeDto.toString();
		this.departureDto = departureDto;
		this.arrivalTerminusDto = arrivalTerminusDto;
		this.locationDto = locationDto;
		this.stopPoints = stopPoints;

	}

	static class TrainXmlAdapter  extends XmlAdapter<TrainAbstractImplDto,ITrainDto>{

		@Override
		public ITrainDto unmarshal(TrainAbstractImplDto v) throws Exception {
			return v;
		}

		@Override
		public TrainAbstractImplDto marshal(ITrainDto v) throws Exception {
			return (TrainAbstractImplDto)v;
		}

	}

	public LocationDto getLocation() {
		return locationDto;
	}
	public void setLocation(LocationDto locationDto) {
		this.locationDto = locationDto;
	}
	public String getTrainType() {
		return trainType;
	}
	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}
	public String getId() {
		return id;
	}
	public double getSpeedKM() {
		return speedKM;
	}
	public boolean isReservation() {
		return reservation;
	}
	public DepartureDto getDeparture() {
		return departureDto;
	}
	public ArrivalTerminusDto getArrival() {
		return arrivalTerminusDto;
	}
	public List<ArrivalStopPointDto> getStopPoints() {
		return stopPoints;
	}
	
	//
	 public void addStopPoint(ArrivalStopPointDto stopPoint)
	    {
	    	this.stopPoints.add(stopPoint);
	    }

}
