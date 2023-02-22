package KaamaBeemacom.example.demo.Repository;

import KaamaBeemacom.example.demo.Model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {

    @Query("FROM complaint WHERE visitorId=:visitorId")
    List<Complaint> findByVisitorId(@Param("visitorId") Integer visitorId);

    @Query("FROM complaint WHERE vendorId=:vendorId")
    List<Complaint> findByVendorId(@Param("vendorId") Integer vendorId);

    @Query("FROM complaint WHERE visitorId=:visitorId AND vendorId=:vendorId")
    List<Complaint> findByVisitorIdAndVendorId(
            @Param("visitorId") Integer visitorId,
            @Param("vendorId") Integer vendorId);
}
