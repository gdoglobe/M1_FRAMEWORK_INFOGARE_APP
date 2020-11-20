package fr.pantheonsorbonne.ufr27.miage.model.jaxb;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
//public class Train implements ITrain{

public class TrainReservationDto extends TrainAbstractImplDto{

	protected boolean reservation;

	public TrainReservationDto() {
		super.reservation = true;
		List<ArrivalStopPointDto> stopPoints = new ArrayList<ArrivalStopPointDto>();
		stopPoints.add(new ArrivalStopPointDto("Tours", 0, new LocationDto("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()));
		stopPoints.add(new ArrivalStopPointDto("Limoges", 1, new LocationDto("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()));
		TrainReservationDto t = new TrainReservationDto("TGV1", TrainTypeReservationDto.TVG, new DepartureDto("Paris", new LocationDto("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new ArrivalTerminusDto("Bordeaux", 0, new LocationDto("1111111", "11111111"), new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new LocationDto("1111111", "11111111"), stopPoints);
		this.newinstance(t);
	}

	private void newinstance (TrainReservationDto t)
	{
		this.id = t.getId();
		this.departureDto = t.getDeparture();
		this.arrivalTerminusDto = t.getArrival();
		this.locationDto = t.getLocation();
		this.stopPoints = t.getStopPoints();
	}

	public TrainReservationDto(String id, TrainTypeReservationDto trainreservationtype, DepartureDto departureDto, ArrivalTerminusDto arrivalTerminusDto,LocationDto locationDto, List<ArrivalStopPointDto> stopPoints) {
		this.id = id;
		super.reservation = true;
		this.trainType = trainreservationtype.toString();
		this.departureDto = departureDto;
		this.arrivalTerminusDto = arrivalTerminusDto;
		this.locationDto = locationDto;
		this.stopPoints = stopPoints;
	}

	public String getId() {
		return id;
	}
	public LocationDto getLocation() {
		return this.locationDto;
	}
	public void setId(String pId) {
		this.id = pId;
	}

	public DepartureDto getDeparture() {
		return departureDto;
	}

	public ArrivalTerminusDto getArrival() {
		this.arrivalTerminusDto.setRank(stopPoints.size());
		return arrivalTerminusDto;
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

	public double getSpeedKM() {
		return speedKM;
	}
	public boolean isReservation() {
		return super.reservation;
	}
	public List<ArrivalStopPointDto> getStopPoints() {
		Collections.sort(this.stopPoints);
		return  this.stopPoints;
	}



	public void addStopPoint(ArrivalStopPointDto stopPoint)
	{
		this.stopPoints.add(stopPoint);
	}

	@Override
	public String getLocationCoordinatesToString() {
		// TODO Auto-generated method stub
		return this.locationDto.getCoordinatesToString();
	}

}
