package KaamaBeemacom.example.demo.Controller;

import KaamaBeemacom.example.demo.Enum.TableNames;
import KaamaBeemacom.example.demo.Model.RatingsAndReviews;
import KaamaBeemacom.example.demo.Model.Vendor;
import KaamaBeemacom.example.demo.Model.Visitor;
import KaamaBeemacom.example.demo.Service.RatingsAndReviewsService;
import KaamaBeemacom.example.demo.Service.VendorService;
import KaamaBeemacom.example.demo.Service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/ratingsAndReviews")
public class RatingsAndReviewsController extends BaseController{

    @Autowired
    private RatingsAndReviewsService ratingsAndReviewsService;
    @Autowired
    private VisitorService visitorService;
    @Autowired
    private VendorService vendorService;


    @GetMapping
    public ResponseEntity getRatingsAndReviews(){
        return ResponseEntity.status(HttpStatus.OK.value()).body(ratingsAndReviewsService.getAllRatingsAndReviews());
    }

    @PostMapping
    public ResponseEntity addNewRatingAndReview(@RequestBody RatingsAndReviews ratingsAndReviews){

        Visitor existingVisitor=visitorService.getVisitorById(ratingsAndReviews.getVisitorId());
        if (existingVisitor==null){
            return getNotFoundErrorResponse(TableNames.VISITOR.getName(), "id",String.valueOf(ratingsAndReviews.getVisitorId()));
        }
        else {
            Vendor existingVendor=vendorService.getVendorById(ratingsAndReviews.getVendorId());
            if (existingVendor==null){
                return getNotFoundErrorResponse(TableNames.VENDOR.getName(),"id",String.valueOf(ratingsAndReviews.getVendorId()));
            }
            else {
                return ResponseEntity.status(HttpStatus.OK.value()).body(ratingsAndReviewsService.addRatingAndReview(ratingsAndReviews));
            }
        }
    }

}
