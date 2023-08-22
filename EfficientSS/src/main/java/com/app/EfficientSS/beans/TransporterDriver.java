package com.app.EfficientSS.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransporterDriver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String licenseNumber;
    private int phoneNumber;
    
    
	@JsonIgnore
    @ManyToOne
	private Transporter transporter;

    
    // Other fields, getters, setters, constructors...
	public TransporterDriver() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public Transporter getTransporter() {
		return transporter;
	}



	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}



	public TransporterDriver(Long id, String name, String licenseNumber, int phoneNumber, Transporter transporter) {
		super();
		this.id = id;
		this.name = name;
		this.licenseNumber = licenseNumber;
		this.phoneNumber = phoneNumber;
		this.transporter = transporter;
	}





	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "TransporterDriver [id=" + id + ", name=" + name + ", licenseNumber=" + licenseNumber + ", phoneNumber="
				+ phoneNumber + "]";
	}
    
    
    
}
