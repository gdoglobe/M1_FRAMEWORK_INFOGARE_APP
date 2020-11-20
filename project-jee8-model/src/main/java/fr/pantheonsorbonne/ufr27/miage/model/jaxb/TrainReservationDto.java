package fr.pantheonsorbonne.ufr27.miage.model.jaxb;


import java.util.Calendar;
import java.util.GregorianCalendar;



public class TrainReservationDto extends TrainAbstractImplDto{

	protected boolean reservation;

	public TrainReservationDto() {
		super.reservation = true;
		
		TrainReservationDto t = new TrainReservationDto("TGV1", TrainTypeReservationDto.TVG, new DepartureDto(Long.valueOf(0),"Paris", new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()), new ArrivalDto(Long.valueOf(1),"Bordeaux", new GregorianCalendar(1980, Calendar.JANUARY, 15, 18, 30).getTime()));
		this.newinstance(t);
	}

	private void newinstance (TrainReservationDto t)
	{
		this.id = t.getId();
		this.departureDto = t.getDeparture();
		this.arrivalDto = t.getArrival();
	}

	public TrainReservationDto(String id, TrainTypeReservationDto trainreservationtype, DepartureDto departureDto, ArrivalDto arrivalDto) {
		this.id = id;
		super.reservation = true;
		this.trainType = trainreservationtype.toString();
		this.departureDto = departureDto;
		this.arrivalDto = arrivalDto;
	}

	
	@Override
	public void setId(String id) {
		 this.id = id;
		
	}

	 public String getId() {
	        return id;
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


	 /*public TrainReservationDto(TrainReservation trainReservationJpa) {
			this.id = trainReservationJpa.getId();
			this.trainType = trainReservationJpa.getTrainType();
			this.departureDto = new DepartureDto(trainReservationJpa.getDeparture());
			this.arrivalDto = new ArrivalDto(trainReservationJpa.getArrival());
			super.reservation = trainReservationJpa.isReservation();
		}*/
	
	
}
