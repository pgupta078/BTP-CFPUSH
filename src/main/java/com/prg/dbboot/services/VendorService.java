package com.prg.dbboot.services;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import com.prg.dbboot.Entities.Vendor;

@Component
public class VendorService {
@Autowired 
//persistance interface instance to provide all the db operation methods
//this is created for our DB table 
IVendorPersistance vendorDB;
//return all vendors    
public List<Vendor> getVendors()
{
//this will file select * on background  
  return  vendorDB.findAll();
}
//return single vendor by its id0
public Optional<Vendor> readVendorById(String vendorId)
{
//select single *  
  return vendorDB.findById(vendorId) ; 
}
//add new vendor
public Vendor addVendor(Vendor newVendor)
{
//update/insert from wa to dbtable  
  return vendorDB.save(newVendor);
}
//update
public Vendor updateVendor(String vendorId, Vendor vendorData)
{
  
  Optional<Vendor> vendorFound = vendorDB.findById(vendorId);
  //vendorFound.setCompanyName(vendorData.getCompanyName());
 //modify dbtable by wa 
  return vendorDB.save(vendorData);

}

public String deleteVendor(String vendorId)
{
 vendorDB.deleteById(vendorId);
return "Object was deleted";
}
public List<Vendor> getVendorbyComName(String comName)
{
  return vendorDB.findByCompanyName(comName);
}
public List<Vendor> findByEmail(String email)
{
return vendorDB.lookUpVendorbyEmailID(email);
}
}
