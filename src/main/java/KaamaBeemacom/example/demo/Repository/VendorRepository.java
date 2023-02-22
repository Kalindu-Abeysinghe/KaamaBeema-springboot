package KaamaBeemacom.example.demo.Repository;

import KaamaBeemacom.example.demo.Model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VendorRepository extends JpaRepository<Vendor,  Integer> {

    @Query("FROM vendor WHERE district=?1")
    List<Vendor> findByDistrict(String district);

}
