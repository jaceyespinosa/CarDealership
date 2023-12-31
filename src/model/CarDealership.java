package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="cars")
public class CarDealership {
	@Id
	@GeneratedValue
	private int id;
	private String model;
	private String description;
	private double price;
	private String status;
	
	public CarDealership() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CarDealership(String model, String description, double price, String status) {
		super();
		this.model = model;
		this.description = description;
		this.price = price;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CarDealership [id=" + id + ", model=" + model + ", description=" + description + ", price=" + price
				+ "]";
	}
}
	