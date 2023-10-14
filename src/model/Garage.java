package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name="garage")
public class Garage {
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name="CAR_ID")
	private CarDealership car;
	
	private String userId; 
	
	public Garage() {
		super();
	}

	public Garage(CarDealership car, String userId) {
		this.car = car;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CarDealership getCar() {
		return car;
	}

	public void setCar(CarDealership car) {
		this.car = car;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}