package KaamaBeemacom.example.demo.Controller;


import KaamaBeemacom.example.demo.Enum.TableNames;
import KaamaBeemacom.example.demo.Model.Vendor;
import KaamaBeemacom.example.demo.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/vendors")
public class VendorController extends BaseController{

    @Autowired
    private VendorService vendorService;

    @GetMapping
    public ResponseEntity getVendors(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "district", required = false) String district
    ){
        if (id!=null && district!=null)
            return null;
        else if (id!=null)
            return getVendorById(id);
        else if (district != null)
            return getVendorsByDistrict(district);
        else
            return ResponseEntity.status(HttpStatus.OK.value()).body(vendorService.getVendors());
    }


    @PostMapping
    public ResponseEntity addVendor(@RequestBody Vendor newVendor){
        return ResponseEntity.status(HttpStatus.OK.value()).body(vendorService.addVendor(newVendor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVendor(@PathVariable("id") Integer vendorIdToDelete){
        Vendor vendorToDelete=vendorService.getVendorById(vendorIdToDelete);
        if (vendorToDelete!=null){
            vendorService.deleteVendor(vendorIdToDelete);
            return ResponseEntity.status(HttpStatus.OK.value()).body(vendorToDelete);
        }
        else {
            return getNotFoundErrorResponse(TableNames.VENDOR.getName(), "id",String.valueOf(vendorIdToDelete));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateVendor(
            @RequestBody Vendor newVendor,
            @PathVariable("id") Integer existingVendorId
            ){
        Vendor existingVendor=vendorService.getVendorById(existingVendorId);
        if (existingVendor!=null){
            return ResponseEntity.status(HttpStatus.OK.value()).body(vendorService.updateVendor(newVendor,existingVendorId));
        }
        else {
            return getNotFoundErrorResponse(TableNames.VENDOR.getName(),"id",String.valueOf(existingVendorId));
        }

    }

    private ResponseEntity getVendorById(Integer id){
        Vendor vendor=vendorService.getVendorById(id);
        if (vendor!=null){
            return ResponseEntity.status(HttpStatus.OK.value()).body(vendor);
        }
        else {
            return getNotFoundErrorResponse(TableNames.VENDOR.getName(), "id",String.valueOf(id));
        }
    }

    private ResponseEntity getVendorsByDistrict(String district){
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(vendorService.getVendorsByDistrict(district));
    }


}
