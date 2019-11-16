package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rattings")
public class rattings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ratter;
	private double rate_value;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "show_id")
	private shows show;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRatter() {
		return ratter;
	}

	public void setRatter(String ratter) {
		this.ratter = ratter;
	}

	public double getRate_value() {
		return rate_value;
	}

	public void setRate_value(double rate_value) {
		this.rate_value = rate_value;
	}

	public shows getShow() {
		return show;
	}

	public void setShow(shows show) {
		this.show = show;
	}

	public rattings(String ratter, double rate_value, shows show) {
		super();
		this.ratter = ratter;
		this.rate_value = rate_value;
		this.show = show;
	}

	public rattings() {
	}

}
