package fr.pantheonsorbonne.ufr27.miage.model.jaxb;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TrainInfoDto {

	public TrainInfoDto() {

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getVariationTimeEstimate() {
		return variationTimeEstimate;
	}

	public void setVariationTimeEstimate(String variationTimeEstimate) {
		this.variationTimeEstimate = variationTimeEstimate;
	}

	@XmlElement
	private String departure;
	private String arrival;
	private String location;
	private String departureTime;
	private String arrivalTime;
	private String variationTimeEstimate;

	public TrainInfoDto(String location, String departureTime, String arrivalTime, String variationTimeEstimate) {
		// TODO Auto-generated constructor stub
//		this.arrival =arrival; String departure, String arrival, 
//		this.departure = departure;
		this.location = location;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.variationTimeEstimate = variationTimeEstimate;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\t\t\t\t{");
//		sb.append("\n\t\t arrival : "+arrival);
//		sb.append("\n\t\t departure : "+departure);
		sb.append("\n\t\t\t\t\t location : " + location);
		sb.append("\n\t\t\t\t\t departureTime : " + departureTime);
		sb.append("\n\t\t\t\t\t arrivalTime : " + arrivalTime);
		sb.append("\n\t\t\t\t\t variationTimeEstimate : " + variationTimeEstimate);
		sb.append("\n\t\t\t\t},\n");
		return sb.toString();
	}

}
