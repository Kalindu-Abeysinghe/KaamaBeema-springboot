package KaamaBeemacom.example.demo.Service;


import KaamaBeemacom.example.demo.Model.Visitor;
import KaamaBeemacom.example.demo.Repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorService {

    @Autowired
    private VisitorRepository visitorRepository;

    public Visitor addVisitor(Visitor visitor){
        return visitorRepository.save(visitor);
    }

    public Visitor getVisitorById(Integer visitorId){
        return visitorRepository.findById(visitorId).orElse(null);
    }

    public List<Visitor> getVisitors(){
        return visitorRepository.findAll();
    }

    public Visitor getVisitorByEmail(String email){
        return visitorRepository.findByEmailAddress(email);
    }

    public void deleteVisitorById(Integer visitorId){
        visitorRepository.deleteById(visitorId);
    }

    public Visitor updateVisitor(Visitor newVisitor, Visitor existingVisitor){

        existingVisitor.setFirstName(newVisitor.getFirstName());
        existingVisitor.setLastName(newVisitor.getLastName());
        existingVisitor.setEmailAddress(newVisitor.getEmailAddress());
        existingVisitor.setGeoLocation(newVisitor.getGeoLocation());
        existingVisitor.setCountryOfOrigin(newVisitor.getCountryOfOrigin());
        existingVisitor.setPassword(newVisitor.getPassword());

        return visitorRepository.save(existingVisitor);
    }

}
