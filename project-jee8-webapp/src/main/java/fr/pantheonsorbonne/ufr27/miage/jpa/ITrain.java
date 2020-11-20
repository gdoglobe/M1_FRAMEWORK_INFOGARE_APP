package fr.pantheonsorbonne.ufr27.miage.jpa;


import java.util.List;



public interface ITrain {
	public String getId();
    public void setId(String pId); 
    public String getLocationCoordinatesToString();
	public Departure getDeparture(); 
	public ArrivalTerminus getArrival();
	public void addStopPoint(ArrivalStopPoint stopPoint);
	public List<ArrivalStopPoint> getStopPoints();
   
    
}
