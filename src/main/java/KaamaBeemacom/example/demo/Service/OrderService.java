package KaamaBeemacom.example.demo.Service;


import KaamaBeemacom.example.demo.Model.Order;
import KaamaBeemacom.example.demo.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(Integer orderId){
        return orderRepository.findById(orderId).orElse(null);
    }

    public List<Order> getOrdersByVisitorId(Integer visitorId){
        return orderRepository.findAllByVisitorId(visitorId);
    }

    public Order addNewOrder(Order order){
        return orderRepository.save(order);
    }

}
