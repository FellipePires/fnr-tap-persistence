package com.fnr.model;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "attend")
public class Attend {
    @Column(name = "date_time_creation", nullable = false)
    private LocalDateTime dateTimeCreation;
    
    @Column(name = "date_time_creation_user_id", nullable = false)
    private Integer dateTimeCreationUserId;

    @Column(name = "date_time_update", nullable = true)
    private LocalDateTime dateTimeUpdate;

    @Column(name = "date_time_update_user_id", nullable = true)
    private Integer dateTimeUpdateUserId;

    @Id
    @Column(name = "attend_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer attendId; 
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "bicycle_id", foreignKey=@ForeignKey(name="fk_bicycle_id_attend"))
    private Bicycle bicycle;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "bicycle_status_id", foreignKey=@ForeignKey(name="fk_bicycle_status_id_attend"))
    private BicycleStatus bicycleStatus;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id", foreignKey=@ForeignKey(name="fk_customer_id_attend"))
    private Customer customer;
    	
	@Column(name = "value", length = 40, nullable = false)
    private double value;

    public Attend() {}
    public Attend(Bicycle bicycle, BicycleStatus bicycleStatus, Customer customer, Double value) {
    	this.bicycle = bicycle;
        this.bicycleStatus = bicycleStatus;
        this.customer = customer;
        this.value = value;
    }

    public Double getValue() {
		return value;
	}
    public void setValue(Double value) {
		this.value = value;
	}
    public LocalDateTime getDateTimeCreation() {
		return dateTimeCreation;
	}
    public void setDateTimeCreation(LocalDateTime dateTimeCreation) {
		this.dateTimeCreation = dateTimeCreation;
	}
	public Integer getDateTimeCreationUserId() {
		return dateTimeCreationUserId;
	}
	public void setDateTimeCreationUserId(Integer dateTimeCreationUserId) {
		this.dateTimeCreationUserId = dateTimeCreationUserId;
	}
	public LocalDateTime getDateTimeUpdate() {
		return dateTimeUpdate;
	}
	public void setDateTimeUpdate(LocalDateTime dateTimeUpdate) {
		this.dateTimeUpdate = dateTimeUpdate;
	}
	public Integer getDateTimeUpdateUserId() {
		return dateTimeUpdateUserId;
	}
	public void setDateTimeUpdateUserId(Integer dateTimeUpdateUserId) {
		this.dateTimeUpdateUserId = dateTimeUpdateUserId;
	}
    public Integer getAttendId() {
		return attendId;
	}
	public void setAttendId(Integer attendId) {
		this.attendId = attendId;
	}
	public Bicycle getBicycle() {
		return bicycle;
	}
	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}
	public BicycleStatus getBicycleStatus() {
		return bicycleStatus;
	}
	public void setBicycleStatus(BicycleStatus bicycleStatus) {
		this.bicycleStatus = bicycleStatus;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}