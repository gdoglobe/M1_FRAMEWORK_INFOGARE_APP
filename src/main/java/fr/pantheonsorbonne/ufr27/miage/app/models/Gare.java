package fr.pantheonsorbonne.ufr27.miage.app.models;

import java.util.HashMap;
import java.util.Map.Entry;

public class Gare {
	private String id;
	//     idTrain/	   	  dest/prov  TrainInfo
	HashMap<String,  HashMap<String, TrainInfo>> trainsDepart;
	HashMap<String,  HashMap<String, TrainInfo>> trainsArrive;
	HashMap<String,  HashMap<String, PerturbationTrain>> perturbationTrainDepart;
	HashMap<String,  HashMap<String, PerturbationTrain>> perturbationTrainArrive;
	public Gare() {
		this.trainsDepart = new HashMap<String, HashMap<String,TrainInfo>>();
		this.trainsArrive = new HashMap<String, HashMap<String,TrainInfo>>();
		this.perturbationTrainDepart = new HashMap<String, HashMap<String,PerturbationTrain>>();
		this.perturbationTrainArrive =new HashMap<String, HashMap<String,PerturbationTrain>>();
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public String getDepartureToString() {
		
		StringBuilder sb = new StringBuilder();
		for(Entry <String, HashMap<String,TrainInfo>> train : trainsDepart.entrySet())
		{
			sb.append("\t\tTrainId : "+train.getKey()+"{");
			HashMap<String, TrainInfo> trainInfos = train.getValue();
			for(Entry <String, TrainInfo> arrival : trainInfos.entrySet())
			{
				TrainInfo ti = arrival.getValue();
				sb.append("\n\t\t\t arrival : "+arrival.getKey()+ti.toString()+"\n\t\t},\n");
			}
		}
		return sb.toString();
	}
	
	public void addTrainDeparture(String idTrain,String arrival, TrainInfo trainInfo) {
		HashMap<String, TrainInfo> arrivalTrain =  new HashMap<String, TrainInfo>();
		arrivalTrain.put(arrival, trainInfo);
		trainsDepart.put(idTrain, arrivalTrain);
	}
	public void addTrainArrive(String idTrain,String provenance, TrainInfo trainInfo) {
		HashMap<String, TrainInfo> provenanceTrain =  new HashMap<String, TrainInfo>();
		provenanceTrain.put(provenance, trainInfo);
		trainsDepart.put(idTrain, provenanceTrain);
	}
	public void addPerturbationDepart(String idTrain,String destination, PerturbationTrain perturbationInfo) {
		HashMap<String, PerturbationTrain> destinationTrain =  new HashMap<String, PerturbationTrain>();
		destinationTrain.put(destination, perturbationInfo);
		perturbationTrainDepart.put(idTrain, destinationTrain);
	}
	public void addPerturbationArrive(String idTrain,String destination, PerturbationTrain perturbationInfo) {
		HashMap<String, PerturbationTrain> destinationTrain =  new HashMap<String, PerturbationTrain>();
		destinationTrain.put(destination, perturbationInfo);
		perturbationTrainArrive.put(idTrain, destinationTrain);
	}
}
