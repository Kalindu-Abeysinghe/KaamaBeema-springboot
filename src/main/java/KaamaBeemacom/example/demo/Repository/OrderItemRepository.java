package KaamaBeemacom.example.demo.Repository;

import KaamaBeemacom.example.demo.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    @Query("FROM orderitem WHERE orderId=:orderId")
    List<OrderItem> findAllByOrderId(@Param("orderId") Integer orderId);
}
