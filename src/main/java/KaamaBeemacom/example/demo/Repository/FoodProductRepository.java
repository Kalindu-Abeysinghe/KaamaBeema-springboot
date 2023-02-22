package KaamaBeemacom.example.demo.Repository;

import KaamaBeemacom.example.demo.Model.FoodProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodProductRepository extends JpaRepository<FoodProduct,Integer>{


    @Query("FROM foodproduct WHERE productName=:name")
    FoodProduct getFoodProductByName(@Param("name")String name);

    @Query("FROM foodproduct WHERE vendorId=:id")
    List<FoodProduct> getFoodProductByVendorId(@Param("id")Integer vendorId);
}