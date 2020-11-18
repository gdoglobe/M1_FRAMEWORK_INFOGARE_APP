package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

public class Passenger {
	
	private Long id;
	private String name;
	private String firstName;
	private String email;
	private TrainTicket trainTicket;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getEmail() {
		return email;
	}
	public TrainTicket getTrainTicket() {
		return trainTicket;
	}
	public Passenger(Long id, String name, String firstName, String email, TrainTicket trainTicket) {
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.email = email;
		this.trainTicket = trainTicket;
	}
	
}
