package fr.pantheonsorbonne.ufr27.miage.jpa;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Station {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@Embedded
	private Location location;
	public Station(Long id, String name, Location location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}
	public Station() {
		
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
