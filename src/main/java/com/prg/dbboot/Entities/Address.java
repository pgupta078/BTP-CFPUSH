package com.prg.dbboot.Entities;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

@Component
@Scope("prototype")
@Entity
@Table(name = "ADDRESS")
public class Address {
  @Id
  @Column(nullable = false, name = "ID")
  @GeneratedValue (generator = "uuid2")
  @GenericGenerator(name="uuid2", strategy = "org.hibernate.id.UUIDGenerator" )
  private String addressId;
  @Column(nullable = false, name = "TYPE")
  private String addressType;
  @Column(nullable = false, name = "STREET")
  private String street;
  @Column(nullable = false, name = "CITY")
  private String city;
  @Column(nullable = false, name = "COUNTRY")
  private String country;
  @Column(nullable = false, name = "REGION")
  private String region;
  //setter and getters
  public String getAddressId() {
    return addressId;
  }
  public void setAddressId(String addressId) {
    this.addressId = addressId;
  }
  public String getAddressType() {
    return addressType;
  }
  public void setAddressType(String addressType) {
    this.addressType = addressType;
  }
  public String getStreet() {
    return street;
  }
  public void setStreet(String street) {
    this.street = street;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
    public String getCountry() {
    return country;
  }
  public void setCountry(String country) {
    this.country = country;
  }
  public String getRegion() {
    return region;
  }
  public void setRegion(String region) {
    this.region = region;
  }
//constructors
//empty constructor
  public Address() {
  }
 //constructor with parameters 
  public Address(String addressId, String addressType, String street, String city, String country, String region) {
    this.addressId = addressId;
    this.addressType = addressType;
    this.street = street;
    this.city = city;
    this.country = country;
    this.region = region;
  }

}


