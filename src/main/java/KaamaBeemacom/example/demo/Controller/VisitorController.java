package KaamaBeemacom.example.demo.Controller;

import KaamaBeemacom.example.demo.Model.Visitor;
import KaamaBeemacom.example.demo.Service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/visitors")
public class VisitorController extends BaseController{

    @Autowired
    private VisitorService visitorService;


    @GetMapping
    public ResponseEntity getVisitorsByIdOrEmail(
            @RequestParam(name = "id", required = false) Integer id,
            @RequestParam(name = "email", required = false) String email
    ){
        if(id!=null && email!=null)
            return null;
        else if(id!=null)
            return getVisitorById(id);
        else if (email!=null)
            return getVisitorByEmail(email);
        else
            return ResponseEntity.status(HttpStatus.OK.value()).body(visitorService.getVisitors());

    }

    private ResponseEntity getVisitorById(Integer id) {

        Visitor visitor = visitorService.getVisitorById(id);
        if (visitor != null)
            return ResponseEntity.status(HttpStatus.OK.value()).body(visitor);
        else
            return getNotFoundErrorResponse("Visitor", "id", String.valueOf(id));
    }
    private ResponseEntity getVisitorByEmail(String email){

        Visitor visitor= visitorService.getVisitorByEmail(email);
        if (visitor!=null)
            return ResponseEntity.status(HttpStatus.OK.value()).body(visitor);
        else
            return getNotFoundErrorResponse("Visitor","email",email);
    }

    @PostMapping()
    public ResponseEntity addVisitor(
            @RequestBody Visitor newVisitor
    ){

        Visitor existingVisitor=visitorService.getVisitorByEmail(newVisitor.getEmailAddress());
        if(existingVisitor==null){
            Visitor visitor= visitorService.addVisitor(newVisitor);
            return ResponseEntity.status(HttpStatus.OK.value()).body(visitor);
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body("User with email already exists");
        }

    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity deleteVisitor(
            @PathVariable Integer id
    ){
        Visitor visitorToDelete=visitorService.getVisitorById(id);
        if (visitorToDelete!=null){
            visitorService.deleteVisitorById(id);
            return ResponseEntity.status(HttpStatus.OK.value()).body(visitorToDelete);
        }
        else
            return getNotFoundErrorResponse("Visitor", "id",String.valueOf(id));
    }

    @PutMapping(path = "{id}")
    public ResponseEntity updateVisitor(
            @RequestBody Visitor newVisitor,
            @PathVariable Integer id
    ){
        Visitor existingVisitor=visitorService.getVisitorById(id);
        if (existingVisitor!=null){
            visitorService.updateVisitor(newVisitor,existingVisitor);
            return ResponseEntity.status(HttpStatus.OK.value()).body(visitorService.getVisitorById(id));
        }
        else
            return getNotFoundErrorResponse("Visitor", "id",String.valueOf(id));
    }

}
