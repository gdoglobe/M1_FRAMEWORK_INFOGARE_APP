package fr.pantheonsorbonne.ufr27.miage.jpa;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainEntityDto;

public class TrainFactory {
	
	public TrainAbstract getInstance(TrainEntityDto trainEntityDto) {
		TrainAbstract trainAbstract = null;
		if(trainEntityDto.isReservation())
			trainAbstract = new TrainReservation(trainEntityDto);
		else
			trainAbstract = new TrainNoReservation(trainEntityDto);
		return trainAbstract;
	

	}
}
