package com.prg.dbboot.services;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.prg.dbboot.Entities.Vendor;

public interface IVendorPersistance extends JpaRepository<Vendor,String>{

 List<Vendor> findByCompanyName(String CompanyName);

 @Query(nativeQuery=true,
        value = "select * from public.vendor where EMAIL like %?1%")
List<Vendor> lookUpVendorbyEmailID(String emailId);


}
