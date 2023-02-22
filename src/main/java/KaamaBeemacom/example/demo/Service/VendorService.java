package KaamaBeemacom.example.demo.Service;

import KaamaBeemacom.example.demo.Model.Vendor;
import KaamaBeemacom.example.demo.Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    public List<Vendor> getVendors(){
        return vendorRepository.findAll();
    }

    public Vendor getVendorById(Integer id){
        return vendorRepository.findById(id).orElse(null);
    }

    public Vendor addVendor(Vendor vendor){
        return vendorRepository.save(vendor);
    }

    public List<Vendor> getVendorsByDistrict(String district){
        return vendorRepository.findByDistrict(district);
    }

    public Vendor updateVendor(Vendor newVendor, Integer existingVendorId){
        Vendor existingVendor=vendorRepository.findById(existingVendorId).orElse(null);

        if (existingVendor!=null){
            existingVendor.setName(newVendor.getName());
            existingVendor.setAddress(newVendor.getAddress());
            existingVendor.setEmailAddress(newVendor.getEmailAddress());
            existingVendor.setDistrict(newVendor.getDistrict());
            existingVendor.setContactNumber(newVendor.getContactNumber());
            return existingVendor;
        }
        else return null;
    }

    public void deleteVendor(Integer id){
        vendorRepository.deleteById(id);
    }
}
