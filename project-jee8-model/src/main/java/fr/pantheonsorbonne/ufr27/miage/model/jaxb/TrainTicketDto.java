package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import java.util.ArrayList;
import java.util.List;

public class TrainTicketDto {
	private Long id;
	private List<TripDto> trainRouting;
	public Long getId() {
		return id;
	}
	public List<TripDto> getTrainRouting() {
		return trainRouting;
	}
	public TrainTicketDto(Long id, List<TripDto> trainRouting) {
		this.id = id;
		this.trainRouting = trainRouting;
	}
	public void addTrip(TripDto tripDto) {
		this.trainRouting.add(tripDto);
	}
	public TrainTicketDto() {
		this.id = Long.valueOf(0);
		this.trainRouting = new ArrayList<TripDto>();
	}
}
