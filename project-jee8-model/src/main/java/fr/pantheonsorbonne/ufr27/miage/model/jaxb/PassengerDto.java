package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

public class PassengerDto {
	
	private Long id;
	private String name;
	private String firstName;
	private String email;
	private TrainTicketDto trainTicketDto;
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
	public TrainTicketDto getTrainTicket() {
		return trainTicketDto;
	}
	public PassengerDto(Long id, String name, String firstName, String email, TrainTicketDto trainTicketDto) {
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.email = email;
		this.trainTicketDto = trainTicketDto;
	}
	
}
