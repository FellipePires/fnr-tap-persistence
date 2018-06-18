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
@Table(name = "users", uniqueConstraints = { @UniqueConstraint( columnNames = "email", name = "uk_email_users" ) })
public class User {
    @Column(name = "date_time_creation", nullable = false)
    private LocalDateTime dateTimeCreation;
    
    @Column(name = "date_time_creation_user_id", nullable = false)
    private Integer dateTimeCreationUserId;

    @Column(name = "date_time_update", nullable = true)
    private LocalDateTime dateTimeUpdate;

    @Column(name = "date_time_update_user_id", nullable = true)
    private Integer dateTimeUpdateUserId;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    
    @Column(name = "name", length = 80, nullable = false)
    private String name;
    
    @Column(name = "email", length = 40, nullable = false)
    private String email;
    
    @Column(name = "password", length = 12, nullable = false)
    private String password;
    
    @Column(name = "isAdmin", nullable = false)
    private Boolean isAdmin;
    
    public User() {}
    public User(String name, String email, String password, Boolean isAdmin) {
    	this.name = name;
    	this.email = email;
    	this.password = password;
    	this.isAdmin = isAdmin;
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
    
}
