package main.app.controller;

import main.app.entity.Customer;
import main.app.entity.Orders;
import main.app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/getOrderDetailsByCustomerId/{id}")
    public List<Orders> getOrderDetailsByCustomerId(@PathVariable("id") Long id){
        List<Orders> orders= orderRepository.findByCustomerId(id);
        // List<Order> order = orderRepository.getById(customerID);
        return orders;
    }

    @GetMapping("/getOrderByID/{id}")
    public Orders getOrderByID(@PathVariable("id") Long id) {
        Orders order = orderRepository.findById(id).get();
        return order;
    }

    @PostMapping("/createOrder")
    public Orders createOrder(@RequestBody Orders order) {
        Orders newOrder = orderRepository.save(order);
        return newOrder;
    }

    @PutMapping("/updateOrderDetails")
    public Orders updateOrderDetails(@RequestBody Orders order){
        return  orderRepository.save(order);
    }

    @DeleteMapping("/deleteOrderById/{id}")
    public String deleteOrderById(@PathVariable("id") Long orderId){
        try {
            orderRepository.deleteById(orderId);
            return "OrderID:"+"\t"+orderId+"\nDeleted Successfully from DB.";
        }catch(Exception ex){
            return "Order with ID:"+orderId+" already Deleted.";
        }
    }
}
