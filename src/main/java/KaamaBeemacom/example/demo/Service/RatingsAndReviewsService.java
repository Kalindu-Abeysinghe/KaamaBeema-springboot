package KaamaBeemacom.example.demo.Service;


import KaamaBeemacom.example.demo.Model.RatingsAndReviews;
import KaamaBeemacom.example.demo.Repository.RatingAndReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingsAndReviewsService {

    @Autowired
    private RatingAndReviewRepository ratingAndReviewRepository;

    public RatingsAndReviews getRatingAndReview(Integer id){
        return ratingAndReviewRepository.findById(id).orElse(null);
    }

    public List<RatingsAndReviews> getAllRatingsAndReviews(){
        return ratingAndReviewRepository.findAll();
    }

    public List<RatingsAndReviews> getRatingsByVendor(Integer vendorId){
        return ratingAndReviewRepository.findByVendorId(vendorId);
    }

    public List<RatingsAndReviews> getRatingsByVisitor(Integer visitorId){
        return ratingAndReviewRepository.findByVisitorId(visitorId);
    }

    public RatingsAndReviews addRatingAndReview(RatingsAndReviews ratingsAndReviews){
        return ratingAndReviewRepository.save(ratingsAndReviews);
    }

}
