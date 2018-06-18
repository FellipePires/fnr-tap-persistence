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
@Table(name = "bicycles")
public class Bicycle {
    @Column(name = "date_time_creation", nullable = false)
    private LocalDateTime dateTimeCreation;
    
    @Column(name = "date_time_creation_user_id", nullable = false)
    private Integer dateTimeCreationUserId;

    @Column(name = "date_time_update", nullable = true)
    private LocalDateTime dateTimeUpdate;

    @Column(name = "date_time_update_user_id", nullable = true)
    private Integer dateTimeUpdateUserId;

    @Id
    @Column(name = "bicycle_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bicycleId;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "bicycle_status_id", foreignKey=@ForeignKey(name="fk_bicycle_status_id_bicycles"))
    private BicycleStatus bicycleStatus;
    	
	@Column(name = "brand", length = 40, nullable = false)
    private String brand;
    
    @Column(name = "model", length = 30, nullable = false)
    private String model;
    
    @Column(name = "color", length = 30, nullable = false)
    private String color;

    public Bicycle() {}
    public Bicycle(BicycleStatus bicycleStatus, String brand, String model, String color) {
        this.bicycleStatus = bicycleStatus;
    	this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public String getColor() {
		return color;
	}
    public void setColor(String color) {
		this.color = color;
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
    public Integer getBicycleId() {
		return bicycleId;
	}
	public void setBicycleId(Integer bicycleId) {
		this.bicycleId = bicycleId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public BicycleStatus getBicycleStatus() {
		return bicycleStatus;
	}
	public void setBicycleStatus(BicycleStatus bicycleStatus) {
		this.bicycleStatus = bicycleStatus;
	}
}