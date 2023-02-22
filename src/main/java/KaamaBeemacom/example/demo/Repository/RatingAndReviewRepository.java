package KaamaBeemacom.example.demo.Repository;

import KaamaBeemacom.example.demo.Model.RatingsAndReviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RatingAndReviewRepository extends JpaRepository<RatingsAndReviews,Integer> {

    @Query("FROM ratingandreview WHERE vendorId=:vendorId")
    List<RatingsAndReviews> findByVendorId(@Param("vendorId")Integer vendorId);

    @Query("FROM ratingandreview WHERE visitorId=:visitorId")
    List<RatingsAndReviews> findByVisitorId(@Param("visitorId") Integer visitorId);
}
