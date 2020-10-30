package fr.pantheonsorbonne.ufr27.miage.app.models;

public class Train {
	
	private String id;

    private String departure;

    private String arrival;

    private String location; 
    private String departureTime;
    private String avrrivalTime;
    public Train() {
    }

    public String getLocation() {
		return location;
	}

	public String getAvrrivalTime() {
		return avrrivalTime;
	}

	public Train(String id, String departure, String arrival,String location, String departureTime,String avrrivalTime) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
        this.location = location;
        this.departureTime = departureTime;
        this.avrrivalTime = avrrivalTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String pId) {
        this.id = pId;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
