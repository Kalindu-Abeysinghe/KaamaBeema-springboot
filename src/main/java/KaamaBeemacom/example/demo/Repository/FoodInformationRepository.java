package KaamaBeemacom.example.demo.Repository;

import KaamaBeemacom.example.demo.Model.FoodInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodInformationRepository extends JpaRepository<FoodInformation,Integer> {

    @Query("FROM foodinformation WHERE foodName=:name")
    FoodInformation findByName(@Param(value = "name") String name);
}
