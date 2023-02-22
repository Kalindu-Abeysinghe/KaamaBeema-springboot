package KaamaBeemacom.example.demo.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "complaint")
@Table(name = "complaint")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private Integer issueLevel;

    @Column(nullable = false)
    private Integer visitorId;

    @Column(nullable = false)
    private Integer vendorId;
    private String complaintStatus;
    private String description;
    private String recurrence;

//    @ManyToOne
//    private Vendor vendor;
//
//    @ManyToOne
//    private Visitor visitor;
}
