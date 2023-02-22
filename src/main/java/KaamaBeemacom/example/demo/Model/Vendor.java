package KaamaBeemacom.example.demo.Model;


import KaamaBeemacom.example.demo.Enum.TableNames;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "vendor")
@Table(name = "vendor")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String emailAddress;
    private String district;
    private String address;
    private Integer contactNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendorId", referencedColumnName = "id")
    private List<RatingsAndReviews> ratingsAndReviews;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendorId", referencedColumnName = "id")
    private List<Complaint> complaintsReceived;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendorId", referencedColumnName = "id")
    private List<FoodProduct> foodProducts;

}
