package KaamaBeemacom.example.demo.Service;

import KaamaBeemacom.example.demo.Model.Complaint;
import KaamaBeemacom.example.demo.Repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;


    public Complaint getComplaintById(Integer id){
        return complaintRepository.findById(id).orElse(null);
    }

    public List<Complaint> getAllComplaints(){
        return complaintRepository.findAll();
    }

    public List<Complaint> getComplaintsByVisitorId(Integer visitorId){
        return complaintRepository.findByVisitorId(visitorId);
    }

    public List<Complaint> getComplaintsByVendorId(Integer vendorId){
        return complaintRepository.findByVendorId(vendorId);
    }

    public List<Complaint> getComplaintsByVisitorIdAndVendorId(Integer visitorId, Integer vendorId){
        return complaintRepository.findByVisitorIdAndVendorId(visitorId,vendorId);
    }

    public Complaint addComplaint(Complaint complaint){
        return complaintRepository.save(complaint);
    }

    public void deleteComplaint(Integer complaintIdToDelete){
        complaintRepository.deleteById(complaintIdToDelete);
    }

    public Complaint updateComplaint(Complaint complaintToUpdate, Integer complaintIdToUpdate){

        Complaint existingComplaint=complaintRepository.findById(complaintIdToUpdate).orElse(null);

        if (existingComplaint!=null){
            existingComplaint.setComplaintStatus(complaintToUpdate.getComplaintStatus());
            existingComplaint.setType(complaintToUpdate.getType());
            existingComplaint.setDescription(complaintToUpdate.getDescription());
            existingComplaint.setRecurrence(complaintToUpdate.getRecurrence());
            existingComplaint.setIssueLevel(complaintToUpdate.getIssueLevel());

            complaintRepository.save(existingComplaint);
            return existingComplaint;
        }
        else return null;
    }
}
