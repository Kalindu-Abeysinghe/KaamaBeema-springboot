package KaamaBeemacom.example.demo.Controller;


import KaamaBeemacom.example.demo.Enum.TableNames;
import KaamaBeemacom.example.demo.Model.Complaint;
import KaamaBeemacom.example.demo.Service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/complaints")
public class ComplaintController extends BaseController{


    @Autowired
    private ComplaintService complaintService;


    @GetMapping(path = "/{id}")
    public ResponseEntity getComplaintsById(@PathVariable("id") Integer id){
        Complaint complaint=complaintService.getComplaintById(id);
        if (complaint!=null){
            return ResponseEntity.status(HttpStatus.OK.value()).body(complaint);
        }
        else {
            return getNotFoundErrorResponse(TableNames.COMPLAINT.getName(), "id", String.valueOf(id));
        }
    }

    @GetMapping
    public ResponseEntity getComplaintsByVisitorId(
            @RequestParam(name = "visitorId", required = false) Integer visitorId,
            @RequestParam(name = "vendorId", required = false)Integer vendorId
    ){
        if (vendorId!=null && visitorId!=null)
            return getComplaintsByVendorIdAndVisitorId(vendorId,visitorId);
        else if (vendorId!=null)
            return getComplaintByVendorId(vendorId);
        else if (visitorId!=null)
            return getComplaintsByVisitorId(visitorId);
        else
            return ResponseEntity.status(HttpStatus.OK.value()).body(complaintService.getAllComplaints());
    }

    @PostMapping
    public ResponseEntity addComplaint(
            @RequestBody Complaint complaint
    ){
        return ResponseEntity.status(HttpStatus.OK.value()).body(complaintService.addComplaint(complaint));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateComplaint(
            @RequestBody Complaint complaintToUpdate,
            @PathVariable("id") Integer id
    ){
        Complaint existingComplaint=complaintService.getComplaintById(id);
        if (existingComplaint!=null){
            return ResponseEntity.status(HttpStatus.OK.value()).body(complaintService.updateComplaint(complaintToUpdate,id));
        }
        else {
            return getNotFoundErrorResponse(TableNames.COMPLAINT.getName(), "id", String.valueOf(id));
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteComplaint(
            @PathVariable("id") Integer id
    ){
        Complaint complaint=complaintService.getComplaintById(id);
        if (complaint!=null){
            complaintService.deleteComplaint(id);
            return ResponseEntity.status(HttpStatus.OK.value()).body(complaint);
        }
        else
            return getNotFoundErrorResponse(TableNames.COMPLAINT.getName(), "id",String.valueOf(id));
    }

    private ResponseEntity getComplaintsByVisitorId(Integer visitorId){
        List<Complaint> complaints=complaintService.getComplaintsByVisitorId(visitorId);
        if (!complaints.isEmpty())
            return ResponseEntity.status(HttpStatus.OK.value()).body(complaints);
        else
            return getNotFoundErrorResponse(TableNames.COMPLAINT.getName(), "vendorId", String.valueOf(visitorId));

    }

    private ResponseEntity getComplaintByVendorId(Integer vendorId){
        List<Complaint> complaints=complaintService.getComplaintsByVendorId(vendorId);
        if (!complaints.isEmpty())
            return ResponseEntity.status(HttpStatus.OK.value()).body(complaints);
        else
            return getNotFoundErrorResponse(TableNames.COMPLAINT.getName(), "vendorId", String.valueOf(vendorId));
    }

    private ResponseEntity getComplaintsByVendorIdAndVisitorId(Integer vendorId, Integer visitorId){
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(complaintService.getComplaintsByVisitorIdAndVendorId(visitorId,vendorId));
    }

}
