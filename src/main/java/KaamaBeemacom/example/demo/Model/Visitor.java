package KaamaBeemacom.example.demo.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "visitor")
@Table(name = "visitor")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String emailAddress;
    private String password;
    private String geoLocation;
    private String countryOfOrigin;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "visitorId", referencedColumnName = "id")
    private List<RatingsAndReviews> ratingsAndReviews;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "visitorId", referencedColumnName = "id")
    private List<Complaint> complaintsMade;

}
