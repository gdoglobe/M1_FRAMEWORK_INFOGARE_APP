package fr.pantheonsorbonne.ufr27.miage.jpa;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ArrivalDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.DepartureDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.InfoCentreDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainAbstractImplDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainEntityDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainNoReservationDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainReservationDto;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainsDto;



@Entity
public class InfoCentre {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<TrainAbstract> trains = new ArrayList<TrainAbstract>();
	
	public InfoCentre() {	
		
	}
	
	
	public void addTrain(TrainAbstract t) {
		trains.add(t);
	}
	
	public List<TrainAbstract> getTrains() {
		return trains;
	}
		
	public List<TrainAbstractImplDto> getTrainsByArrivalStationName(String stationName) {
		
		List<TrainAbstractImplDto> trainsByArrivalStationName = new ArrayList<TrainAbstractImplDto>();
		TrainAbstractImplDto trainAbstractImplDtoArrival = null;
		DepartureDto departureDto = null;
		ArrivalDto arrivalDto = null;
		for(TrainAbstract t : this.trains)
		{
			if(t.getArrival().getStation().getName().equalsIgnoreCase(stationName))
			{
				departureDto = new DepartureDto(t.departure.getId(), t.getDeparture().getStation().getName(), t.getDeparture().getDateTime());
				arrivalDto = new ArrivalDto(t.getArrival().getId(), t.getArrival().getStation().getName(), t.getArrival().getDateTime()); 
				if(t instanceof TrainNoReservation)
					trainAbstractImplDtoArrival = new TrainNoReservationDto(t.getId(), t.getTrainType(), departureDto, arrivalDto);
				if(t instanceof TrainReservation)
					trainAbstractImplDtoArrival = new TrainReservationDto(t.getId(), t.getTrainType(), departureDto, arrivalDto);
				trainsByArrivalStationName.add(trainAbstractImplDtoArrival);
			}
			if(t.getArrivalStopPointByStationName(stationName)!= null)
			{
				ArrivalStopPoint stopPoint = t.getArrivalStopPointByStationName(stationName);
				departureDto = new DepartureDto(t.departure.getId(), t.getDeparture().getStation().getName(), t.getDeparture().getDateTime());
				arrivalDto = new ArrivalDto(stopPoint.getId(), stopPoint.getStation().getName(), stopPoint.getDateTime());
				if(t instanceof TrainNoReservation)
					trainAbstractImplDtoArrival = new TrainNoReservationDto(t.getId(), t.getTrainType(), departureDto, arrivalDto);
				if(t instanceof TrainReservation)
					trainAbstractImplDtoArrival = new TrainReservationDto(t.getId(), t.getTrainType(), departureDto, arrivalDto);
				trainsByArrivalStationName.add(trainAbstractImplDtoArrival);
			}
		}
		return trainsByArrivalStationName;
	}
	
	public TrainsDto getTrainsDtoByArrivalStationName(String stationName) {
		//
		InfoCentreDto infoCentreDto = new InfoCentreDto();

		TrainAbstractImplDto trainAbstractImplDtoArrival = null;
		DepartureDto departureDto = null;
		ArrivalDto arrivalDto = null;
		for(TrainAbstract t : this.trains)
		{
			if(t.getArrival().getStation().getName().equalsIgnoreCase(stationName))
			{
				departureDto = new DepartureDto(t.departure.getId(), t.getDeparture().getStation().getName(), t.getDeparture().getDateTime());
				arrivalDto = new ArrivalDto(t.getArrival().getId(), t.getArrival().getStation().getName(), t.getArrival().getDateTime()); 
				if(t instanceof TrainNoReservation)
					trainAbstractImplDtoArrival = new TrainNoReservationDto(t.getId(), t.getTrainType(), departureDto, arrivalDto);
				if(t instanceof TrainReservation)
					trainAbstractImplDtoArrival = new TrainReservationDto(t.getId(), t.getTrainType(), departureDto, arrivalDto);
				infoCentreDto.getTrainsDto().addTrain(trainAbstractImplDtoArrival);
			}
			if(t.getArrivalStopPointByStationName(stationName)!= null)
			{
				ArrivalStopPoint stopPoint = t.getArrivalStopPointByStationName(stationName);
				departureDto = new DepartureDto(t.departure.getId(), t.getDeparture().getStation().getName(), t.getDeparture().getDateTime());
				arrivalDto = new ArrivalDto(stopPoint.getId(), stopPoint.getStation().getName(), stopPoint.getDateTime());
				if(t instanceof TrainNoReservation)
					trainAbstractImplDtoArrival = new TrainNoReservationDto(t.getId(), t.getTrainType(), departureDto, arrivalDto);
				if(t instanceof TrainReservation)
					trainAbstractImplDtoArrival = new TrainReservationDto(t.getId(), t.getTrainType(), departureDto, arrivalDto);
				infoCentreDto.getTrainsDto().addTrain(trainAbstractImplDtoArrival);
			}
		}
		return infoCentreDto.getTrainsDto();
	}
	
	
	
	public TrainEntityDto getTrainEntityDtoById(String trainId) {
		//
		TrainEntityDto trainEntityDto = null;
		for(TrainAbstract t : this.trains)
		{
			if(t.getId().equalsIgnoreCase(trainId))
			{
				trainEntityDto = t.getDto();
				trainEntityDto.getArrivalTerminus().setRank(trainEntityDto.getStopPoints().size()+1);
				return trainEntityDto;
			}
				
			}
			
		return trainEntityDto;
	}
	
	public List<TrainAbstractImplDto> getTrainsByDepartureStationName(String stationName) {
		List<TrainAbstractImplDto> trainsByDepartureStationName = new ArrayList<TrainAbstractImplDto>();
		TrainAbstractImplDto trainAbstractImplDtoDeparture = null;
		DepartureDto departureDto = null;
		ArrivalDto arrivalDto = null;
		for(TrainAbstract t : this.trains)
		{
			if(t.getDeparture().getStation().getName().equalsIgnoreCase(stationName))
			{
				departureDto = new DepartureDto(t.departure.getId(), t.getDeparture().getStation().getName(), t.getDeparture().getDateTime());
				arrivalDto = new ArrivalDto(t.getArrival().getId(), t.getArrival().getStation().getName(), t.getArrival().getDateTime()); 
				if(t instanceof TrainNoReservation)
					trainAbstractImplDtoDeparture = new TrainNoReservationDto(t.getId(), t.getTrainType(), departureDto, arrivalDto);
				if(t instanceof TrainReservation)
					trainAbstractImplDtoDeparture = new TrainReservationDto(t.getId(), t.getTrainType(), departureDto, arrivalDto);
				trainsByDepartureStationName.add(trainAbstractImplDtoDeparture);
			}
			if(t.getArrivalStopPointByStationName(stationName)!= null)
			{
				ArrivalStopPoint stopPoint = t.getArrivalStopPointByStationName(stationName);
				departureDto = new DepartureDto(stopPoint.getId(), stopPoint.getStation().getName(), stopPoint.getDateTime());
				arrivalDto = new ArrivalDto(t.getArrival().getId(), t.getArrival().getStation().getName(), t.getArrival().getDateTime());
				 
				if(t instanceof TrainNoReservation)
					trainAbstractImplDtoDeparture = new TrainNoReservationDto(t.getId(), t.getTrainType(), departureDto, arrivalDto);
				if(t instanceof TrainReservation)
					trainAbstractImplDtoDeparture = new TrainReservationDto(t.getId(), t.getTrainType(), departureDto, arrivalDto);
				trainsByDepartureStationName.add(trainAbstractImplDtoDeparture);
			}
		}
		return trainsByDepartureStationName;
	}

	
	public TrainsDto getTrainsDtoByDepartureStationName(String stationName) {
		//
		InfoCentreDto infoCentreDto = new InfoCentreDto();
		TrainAbstractImplDto trainAbstractImplDtoDeparture = null;
		DepartureDto departureDto = null;
		ArrivalDto arrivalDto = null;
		for(TrainAbstract t : this.trains)
		{
			if(t.getDeparture().getStation().getName().equalsIgnoreCase(stationName))
			{
				departureDto = new DepartureDto(t.departure.getId(), t.getDeparture().getStation().getName(), t.getDeparture().getDateTime());
				arrivalDto = new ArrivalDto(t.getArrival().getId(), t.getArrival().getStation().getName(), t.getArrival().getDateTime()); 
				if(t instanceof TrainNoReservation)
					trainAbstractImplDtoDeparture = new TrainNoReservationDto(t.getId(), t.getTrainType(), departureDto, arrivalDto);
				if(t instanceof TrainReservation)
					trainAbstractImplDtoDeparture = new TrainReservationDto(t.getId(), t.getTrainType(), departureDto, arrivalDto);
				infoCentreDto.getTrainsDto().addTrain(trainAbstractImplDtoDeparture);
			}
			if(t.getArrivalStopPointByStationName(stationName)!= null)
			{
				ArrivalStopPoint stopPoint = t.getArrivalStopPointByStationName(stationName);
				departureDto = new DepartureDto(stopPoint.getId(), stopPoint.getStation().getName(), stopPoint.getDateTime());
				arrivalDto = new ArrivalDto(t.getArrival().getId(), t.getArrival().getStation().getName(), t.getArrival().getDateTime());
				 
				if(t instanceof TrainNoReservation)
					trainAbstractImplDtoDeparture = new TrainNoReservationDto(t.getId(), t.getTrainType(), departureDto, arrivalDto);
				if(t instanceof TrainReservation)
					trainAbstractImplDtoDeparture = new TrainReservationDto(t.getId(), t.getTrainType(), departureDto, arrivalDto);
				infoCentreDto.getTrainsDto().addTrain(trainAbstractImplDtoDeparture);
			}
		}
		return infoCentreDto.getTrainsDto();
	}

	public double calculerTrainVariationDepart(TrainAbstract t)
	{
		return 0;	
	}
	public double calculerTrainVariationArrive(TrainAbstract t)
	{
		return 0;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	 

}
