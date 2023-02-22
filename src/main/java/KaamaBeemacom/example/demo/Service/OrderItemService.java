package KaamaBeemacom.example.demo.Service;


import KaamaBeemacom.example.demo.Model.OrderItem;
import KaamaBeemacom.example.demo.Repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {


    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getOrderItemsByOrderId(Integer orderId){
        return orderItemRepository.findAllByOrderId(orderId);
    }
}
