package KaamaBeemacom.example.demo.Repository;


import KaamaBeemacom.example.demo.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query("FROM orders WHERE visitorId=:visitorId")
    List<Order> findAllByVisitorId(@Param("visitorId") Integer visitorId);
}
