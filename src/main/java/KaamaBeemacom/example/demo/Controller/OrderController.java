package KaamaBeemacom.example.demo.Controller;

import KaamaBeemacom.example.demo.Enum.TableNames;
import KaamaBeemacom.example.demo.Model.Order;
import KaamaBeemacom.example.demo.Model.OrderItem;
import KaamaBeemacom.example.demo.Service.FoodProductService;
import KaamaBeemacom.example.demo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/orders")
public class OrderController extends BaseController{

    @Autowired
    private OrderService orderService;
    @Autowired
    private FoodProductService foodProductService;

    @GetMapping
    public ResponseEntity getAllOrders(){
        return getSuccessResponse(addFoodProductToOrderItems(orderService.getAllOrders()));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getOrderById(@PathVariable("id") Integer orderId){
        Order order=orderService.getOrderById(orderId);
        if (order!=null)
            return getSuccessResponse(addFoodProductToOrderItems(order));
        else
            return getNotFoundErrorResponse(TableNames.ORDER.getName(), "id",String.valueOf(orderId));
    }

    @GetMapping(path = "/visitorId/{visitorId}")
    public ResponseEntity getOrdersByVisitorId(@PathVariable("visitorId") Integer visitorId){
        List<Order> orderList=orderService.getOrdersByVisitorId(visitorId);
        if (!orderList.isEmpty())
            return getSuccessResponse(addFoodProductToOrderItems(orderList));
        else
            return getNotFoundErrorResponse(TableNames.ORDER.getName(), "visitorId", String.valueOf(visitorId));
    }

    @PostMapping
    public ResponseEntity addNewOrder(@RequestBody Order newOrder){

        List<OrderItem> orderItems=newOrder.getOrderItems();

        Order addedOrder=orderService.addNewOrder(newOrder);
        Integer addedOrderId=addedOrder.getId();

        for (OrderItem orderItem: orderItems){
            orderItem.setOrderId(addedOrderId);
        }

        return getSuccessResponse(orderService.getOrderById(addedOrderId));
    }

    private Order addFoodProductToOrderItems(Order order){
        List<OrderItem> orderItems=order.getOrderItems();
        for (OrderItem orderItem : orderItems){
            orderItem.setFoodProduct(foodProductService.getFoodProductById(orderItem.getFoodProductId()));
        }
        order.setOrderItems(orderItems);
        return order;
    }

    private List<Order> addFoodProductToOrderItems(List<Order> orders){
        for (Order order : orders){
            addFoodProductToOrderItems(order);
        }
        return orders;
    }
}
