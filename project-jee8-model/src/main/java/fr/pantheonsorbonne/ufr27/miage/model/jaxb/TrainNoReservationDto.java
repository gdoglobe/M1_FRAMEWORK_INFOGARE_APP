package fr.pantheonsorbonne.ufr27.miage.model.jaxb;
import java.util.Calendar;
import java.util.GregorianCalendar;


import fr.pantheonsorbonne.ufr27.miage.jpa.*;

public class TrainNoReservationDto extends TrainAbstractImplDto{


	
	protected boolean reservation;
   
	public TrainNoReservationDto() {
			super.reservation = false;
    		TrainNoReservationDto t = new TrainNoReservationDto("TGV1", TrainTypeNoReservationDto.TER, new DepartureDto(Long.valueOf(0),"Paris", new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new ArrivalDto(Long.valueOf(0),"Bordeaux", new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()));
    		this.newinstance(t);
    }
    
    private void newinstance (TrainNoReservationDto t)
    {
    	this.id = t.getId();
        this.departureDto = t.getDeparture();
        this.arrivalDto = t.getArrival();
    }
    
    public TrainNoReservationDto(TrainNoReservation trainNoReservationJpa) {
		this.id = trainNoReservationJpa.getId();
		this.trainType = trainNoReservationJpa.getTrainType();
		this.departureDto = new DepartureDto(trainNoReservationJpa.getDeparture());
		this.arrivalDto = new ArrivalDto(trainNoReservationJpa.getArrival());
		super.reservation = trainNoReservationJpa.isReservation();
	}
    public TrainNoReservationDto(String id, TrainTypeNoReservationDto trainTypeNoReservationDto, DepartureDto departureDto, ArrivalDto arrivalDto) {
        this.id = id;
        super.reservation = false;
        this.trainType = trainTypeNoReservationDto.toString();
        this.departureDto = departureDto;
        this.arrivalDto = arrivalDto;
    }

    public String getId() {
        return id;
    }
    
    public void setId(String pId) {
        this.id = pId;
    }

	public DepartureDto getDeparture() {
		return departureDto;
	}

	public String getTrainType() {
		return trainType;
	}
	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}
	
	public boolean isReservation() {
		return super.reservation;
	}

}
