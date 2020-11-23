package fr.pantheonsorbonne.ufr27.miage.jpa;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.StationEntityDto;

@Entity
public class Station implements Serializable{
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@Embedded
	private Location location;
	public Station(Long id, String name, Location location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}
	
	public Station(StationEntityDto stationEntityDto) {
		this.id = stationEntityDto.getId();
		this.name = stationEntityDto.getName();
		this.location = new Location(stationEntityDto.getLocation()); 
	}
	
	public Station() {
		
	}
	
	public Station( String name, Location location) {
		this.name = name;
		this.location = location;
	}

	public StationEntityDto getDto()
	{
		return new StationEntityDto(this.getId(), this.getName(), this.getLocation().getDto());
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Location getLocation() {
		return location;
	}

}
