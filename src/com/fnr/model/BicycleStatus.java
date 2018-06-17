package com.fnr.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity 
@Table(name = "bicycle_status", uniqueConstraints = { @UniqueConstraint( columnNames = "bicycle_status", name = "uk_bicycle_status" ) })
public class BicycleStatus {

    @Column(name = "date_time_creation", nullable = false)
    private LocalDateTime dateTimeCreation;
    
    @Column(name = "date_time_creation_user_id", nullable = false)
    private Integer dateTimeCreationUserId;

    @Column(name = "date_time_update", nullable = true)
    private LocalDateTime dateTimeUpdate;

    @Column(name = "date_time_update_user_id", nullable = true)
    private Integer dateTimeUpdateUserId;

    @Id
    @Column(name = "bicycle_status_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bicycleStatusId; 
    
    @Column(name = "bicycle_status", length = 3, nullable = false)
    private String bicycleStatus;
    
    @Column(name = "description", length = 30, nullable = false)
    private String description;

    public BicycleStatus() {}
    public BicycleStatus(String bicycleStatus, String description) {
        this.bicycleStatus = bicycleStatus;
        this.description = description;
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
    public String getDescription() {
		return description;
	}
    public void setDescription(String description) {
		this.description = description;
    }
	public Integer getBicycleStatusId() {
		return bicycleStatusId;
	}
	public void setBicycleStatusId(Integer bicycleStatusId) {
		this.bicycleStatusId = bicycleStatusId;
	}
	public String getBicycleStatus() {
		return bicycleStatus;
	}
	public void setBicycleStatus(String bicycleStatus) {
		this.bicycleStatus = bicycleStatus;
	}

}

