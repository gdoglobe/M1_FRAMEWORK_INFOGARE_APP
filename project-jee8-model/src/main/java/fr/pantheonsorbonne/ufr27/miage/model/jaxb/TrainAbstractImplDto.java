package fr.pantheonsorbonne.ufr27.miage.model.jaxb;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class TrainAbstractImplDto implements ITrainDto{
	@XmlElement
	protected String id;

	@XmlElement
	protected boolean reservation = false;

	@XmlElement
	protected String trainType;

	@XmlElement
	protected DepartureDto departureDto;
	
	@XmlElement
	protected ArrivalDto arrivalDto;

	public TrainAbstractImplDto() {
		this.id = "";
		this.departureDto = new DepartureDto();
		this.arrivalDto = new ArrivalDto();
	}

	public TrainAbstractImplDto(String id, String trainTypeDto, DepartureDto departureDto, ArrivalDto arrivalDto) {

		this.id = id;
		this.trainType = trainTypeDto.toString();
		this.departureDto = departureDto;
		this.arrivalDto = arrivalDto;

	}
	
	/*public TrainAbstractImplDto(TrainAbstract trainAbstractJpa) {
		this.id = trainAbstractJpa.getId();
		this.trainType = trainAbstractJpa.getTrainType();
		this.departureDto = new DepartureDto(trainAbstractJpa.getDeparture());
		this.arrivalDto = new ArrivalDto(trainAbstractJpa.getArrival());
	}*/

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

	public String getTrainType() {
		return trainType;
	}
	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}
	public String getId() {
		return id;
	}
	
	public boolean isReservation() {
		return reservation;
	}
	public DepartureDto getDeparture() {
		return departureDto;
	}
	public ArrivalDto getArrival() {
		return arrivalDto;
	}
	
}
