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
@Table(name = "addresses")
public class Addresses {
    @Column(name = "date_time_creation", nullable = false)
    private LocalDateTime dateTimeCreation;
    
    @Column(name = "date_time_creation_user_id", nullable = false)
    private Integer dateTimeCreationUserId;

    @Column(name = "date_time_update", nullable = true)
    private LocalDateTime dateTimeUpdate;

    @Column(name = "date_time_update_user_id", nullable = true)
    private Integer dateTimeUpdateUserId;

    @Id
    @Column(name = "addresses_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressesId; 
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id", foreignKey=@ForeignKey(name="fk_customer_id_addresses"))
    private Customer customer;
    	
	@Column(name = "street", length = 60, nullable = false)
    private String street;
    
    @Column(name = "number", length = 6, nullable = false)
    private String number;
    
    @Column(name = "complement", length = 20, nullable = false)
    private String complement;
    
    @Column(name = "city", length = 40, nullable = false)
    private String city;
    
    @Column(name = "state", length = 40, nullable = false)
    private String state;
    
    @Column(name = "zipcode", length = 8, nullable = false)
    private String zipcode;

    public Addresses() {}
    public Addresses(Customer customer, String street, String number, String complement, String city, String state, String zipcode) {
        this.customer = customer;
    	this.street = street;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public String getComplement() {
		return complement;
	}
    public void setComplement(String complement) {
		this.complement = complement;
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
    public Integer getAddressesId() {
		return addressesId;
	}
	public void setAddressesId(Integer addressesId) {
		this.addressesId = addressesId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}	
}