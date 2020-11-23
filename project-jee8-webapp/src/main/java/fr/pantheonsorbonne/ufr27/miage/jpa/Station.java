package fr.pantheonsorbonne.ufr27.miage.jpa;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Station {
		@Id
		@GeneratedValue
		private int id;
		private String name;
		@Embedded
		private Location location;
		public int getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		public Location getLocation() {
			return location;
		}
		
}
