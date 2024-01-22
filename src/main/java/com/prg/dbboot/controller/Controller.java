package com.prg.dbboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prg.dbboot.Entities.Vendor;
import com.prg.dbboot.services.VendorService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Controller {
  @Autowired
  private VendorService  myVendorServ;
  //read all
  @GetMapping("/vendors")
  public  List<Vendor> getAll() {
      return myVendorServ.getVendors(); 
  }
  //read one
  @RequestMapping("/vendor/{vendorCode}")
  public Optional<Vendor> getVendorById(@PathVariable("vendorCode") String code) {
      return myVendorServ.readVendorById(code);
  }
  //insert
  @PostMapping("/vendors")
  //@RequestBody - to read the body of request
  public  Vendor CreateVendor(@RequestBody Vendor newVendor) {
      return myVendorServ.addVendor(newVendor); 
  }
//update
  @RequestMapping(method=RequestMethod.PUT,value = "/vendor/{vendorId}")
  public Vendor updateVendor(@PathVariable("vendorId") String code,
                             @RequestBody Vendor updatedVendor){
     return myVendorServ.updateVendor(code, updatedVendor);

  }
//delete
@RequestMapping(method=RequestMethod.DELETE,
                value="/vendor/{vendorId}")
//above will make a call like - if afs is vendorId
//http://localhost:8080/vendor/afs                
  public String deleteVendor(@PathVariable("vendorId") String code)
  {
   return myVendorServ.deleteVendor(code);
    
  }              
//serach by Company Name
@RequestMapping("/vendor/search")
public List<Vendor> getByCompName(@RequestParam String comName)
{
  return myVendorServ.getVendorbyComName(comName);
}
//lookup by email pattern
@RequestMapping("/vendor/lookup/{email}")
public List<Vendor> lookupByEmail(@PathVariable("email") String email)
{
  return myVendorServ.findByEmail(email);
} 

  
} 