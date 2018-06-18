package com.fnr.model;
//package br.com.fnr_tap.fachada;
//
//import java.time.LocalDateTime;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.UniqueConstraint;
//
//@Entity
//@Table(name = "customers", uniqueConstraints = { @UniqueConstraint(columnNames = "customer_id", name = "uk_customer_id") })
//public class Customer {
//	
//	@Column(name = "date_time_creation", nullable = false)
//	private LocalDateTime dateTimeCreation;
//
//	@Column(name = "date_time_creation_user_id", nullable = false)
//	private Integer dateTimeCreationUserId;
//
//	@Column(name = "date_time_update", nullable = true)
//	private LocalDateTime dateTimeUpdate;
//
//	@Column(name = "date_time_update_user_id", nullable = true)
//	private Integer dateTimeUpdateUserId;
//
//	@Id
//	@Column(name = "customer_id", nullable = false)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer customerId;
//
//	@Column(name = "name", length = 100, nullable = false)
//	private String name;
//
//	@Column(name = "email", length = 80, nullable = false)
//	private String email;
//
//	@Column(name = "phone", length = 12, nullable = false)
//	private String phone;
//
//	@Column(name = "residencial_phone", length = 12, nullable = false)
//	private String residencial_phone;
//
//	public Customer() {}
//	public Customer(String name, String email, String phone, String residencial_phone) {
//		this.name = name;
//		this.email = email;
//		this.phone = phone;
//		this.residencial_phone = residencial_phone;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public LocalDateTime getDateTimeCreation() {
//		return dateTimeCreation;
//	}
//
//	public void setDateTimeCreation(LocalDateTime dateTimeCreation) {
//		this.dateTimeCreation = dateTimeCreation;
//	}
//
//	public Integer getDateTimeCreationUserId() {
//		return dateTimeCreationUserId;
//	}
//
//	public void setDateTimeCreationUserId(Integer dateTimeCreationUserId) {
//		this.dateTimeCreationUserId = dateTimeCreationUserId;
//	}
//
//	public LocalDateTime getDateTimeUpdate() {
//		return dateTimeUpdate;
//	}
//
//	public void setDateTimeUpdate(LocalDateTime dateTimeUpdate) {
//		this.dateTimeUpdate = dateTimeUpdate;
//	}
//
//	public Integer getDateTimeUpdateUserId() {
//		return dateTimeUpdateUserId;
//	}
//
//	public void setDateTimeUpdateUserId(Integer dateTimeUpdateUserId) {
//		this.dateTimeUpdateUserId = dateTimeUpdateUserId;
//	}
//
//	public Integer getcustomerId() {
//		return customerId;
//	}
//
//	public void setCustomerId(Integer customerId) {
//		this.customerId = customerId;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public String getResidencial_Phone() {
//		return residencial_phone;
//	}
//
//	public void setResidencial_Phone(String residencial_phone) {
//		this.residencial_phone = residencial_phone;
//	}
//}