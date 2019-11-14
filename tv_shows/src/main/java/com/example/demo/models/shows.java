package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shows")
public class shows {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String network;
	private double average_rate;
	@ManyToOne(fetch = FetchType.LAZY)
	private rattings rate;

	public shows() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public double getAverage_rate() {
		return average_rate;
	}

	public void setAverage_rate(double average_rate) {
		this.average_rate = average_rate;
	}

	public rattings getRate() {
		return rate;
	}

	public void setRate(rattings rate) {
		this.rate = rate;
	}

	public shows(String name, String network, double average_rate, rattings rate) {
		super();
		this.name = name;
		this.network = network;
		this.average_rate = average_rate;
		this.rate = rate;
	}

}
