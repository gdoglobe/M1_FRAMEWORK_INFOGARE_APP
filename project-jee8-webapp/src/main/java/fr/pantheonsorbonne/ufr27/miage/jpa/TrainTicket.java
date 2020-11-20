package fr.pantheonsorbonne.ufr27.miage.jpa;

import java.util.ArrayList;
import java.util.List;

public class TrainTicket {
	private Long id;
	private List<Trip> trainRouting;
	public Long getId() {
		return id;
	}
	public List<Trip> getTrainRouting() {
		return trainRouting;
	}
	public TrainTicket(Long id, List<Trip> trainRouting) {
		this.id = id;
		this.trainRouting = trainRouting;
	}
	public void addTrip(Trip trip) {
		this.trainRouting.add(trip);
	}
	public TrainTicket() {
		this.id = Long.valueOf(0);
		this.trainRouting = new ArrayList<Trip>();
	}
}
