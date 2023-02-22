package KaamaBeemacom.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "foodinformation")
@Table(name = "foodinformation")
public class FoodInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String foodName;

    private String ingredients;

    private String dietType;

    private String allergyTriggers;

    @Transient
    private String notSuitableFor;

    @Transient
    private String mayContain;

    @Lob
    private Blob foodImage;
}
