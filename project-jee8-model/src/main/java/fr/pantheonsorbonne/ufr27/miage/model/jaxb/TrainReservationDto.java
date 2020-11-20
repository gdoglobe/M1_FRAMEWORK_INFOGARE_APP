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
		TrainNoReservationDto t = new TrainNoReservationDto("TGV1", "TER", new DepartureDto(Long.valueOf(0),"Paris", new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new ArrivalDto(Long.valueOf(0),"Bordeaux", new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()));
		this.newinstance(t);
    }
    
    private void newinstance (TrainNoReservationDto t)
    {
    	this.id = t.getId();
        this.departureDto = t.getDeparture();
        this.arrivalDto = t.getArrival();
    }
    
    public TrainReservationDto(String id, String trainTypeReservationDto, DepartureDto departureDto, ArrivalDto arrivalDto) {
        this.id = id;
        super.reservation = true;
        this.trainType = trainTypeReservationDto;
        this.departureDto = departureDto;
        this.arrivalDto = arrivalDto;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

	public DepartureDto getDeparture() {
		return departureDto;
	}
	
	public ArrivalDto getArrival() {
		return arrivalDto;
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
