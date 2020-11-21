package fr.pantheonsorbonne.ufr27.miage.model.jaxb;
import java.util.Calendar;
import java.util.GregorianCalendar;



public class TrainNoReservationDto extends TrainAbstractImplDto{


	
	//protected boolean reservation;
   
	public TrainNoReservationDto() {

		super.reservation = false;
		TrainNoReservationDto t = new TrainNoReservationDto("TGV1", "TER", new DepartureDto(Long.valueOf(0),"Paris", new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new ArrivalDto(Long.valueOf(0),"Bordeaux", new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()));
		this.newinstance(t);

    }
    
    private void newinstance (TrainNoReservationDto t)
    {
    	this.id = t.getId();
        this.departureDto = t.getDeparture();
        this.arrivalDto = t.getArrival();
    }
    

    public TrainNoReservationDto(String id, String trainTypeNoReservationDto, DepartureDto departureDto, ArrivalDto arrivalDto) {

        this.id = id;
        super.reservation = false;
        this.trainType = trainTypeNoReservationDto;
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\t\t\tid : "+this.id+"\n");
		sb.append("\t\t\treservation : "+this.reservation+"\n");
		sb.append("\t\t\ttype : "+this.trainType+"\n");
		sb.append("\t\t\t"+this.departureDto.toString());
		sb.append("\t\t\ttype"+this.arrivalDto.toString());
		return sb.toString();
	}
    

}
