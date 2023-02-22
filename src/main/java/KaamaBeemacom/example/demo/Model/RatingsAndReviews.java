package KaamaBeemacom.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "ratingandreview")
@Entity(name = "ratingandreview")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RatingsAndReviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "visitorId")
    private Integer visitorId;

    @Column(name="vendorId")
    private Integer vendorId;

    private Integer rating;

    private String review;

//    @ManyToOne(targetEntity = RatingsAndReviews.class, fetch = FetchType.LAZY)
//    private Visitor visitor;

//    @ManyToOne(targetEntity = Vendor.class, fetch = FetchType.LAZY)
//    private Vendor vendor;
}
