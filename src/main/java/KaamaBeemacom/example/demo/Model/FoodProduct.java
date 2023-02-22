package KaamaBeemacom.example.demo.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "foodproduct")
@Entity(name = "foodproduct")
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String productName;

    private String ingredients;

    private String dietType;

    private Double price;

    private String allergyTriggers;

    private Integer vendorId;
}
