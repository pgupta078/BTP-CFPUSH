package com.prg.dbboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prg.dbboot.Entities.Address;
import com.prg.dbboot.services.AddressService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AddressController {
  @Autowired
  private AddressService  myAdrServ;
  //read all
  @GetMapping("/addresses")
  public  List<Address> getAll() {
      return myAdrServ.getAddresses(); 
  }
  //read one
  @RequestMapping("/Address/{id}")
  public Optional<Address> getVendorById(@PathVariable("id") String id) {
      return myAdrServ.getAddress(id);
  }

  @PostMapping("/Address")
  public Address CreateAddress(@RequestBody Address address) {
      
      return myAdrServ.createAddresses(address);
  
  }
  

}
