package com.prg.dbboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.prg.dbboot.Entities.Address;

@Component
public class AddressService {
@Autowired 
//persistance interface instance to provide all the db operation methods
//this is created for our DB table 
public IAddressPersistance addressDB;

public List<Address> getAddresses()
{
  return addressDB.findAll();
}
public Optional<Address> getAddress(String id)
{
  return addressDB.findById(id);
}
public Address createAddresses(Address address)
{
 if (address.getCountry() == "China" )
 {
   throw  new Error("China country is not allowed");
 }
 
  return addressDB.save(address);

}


}
