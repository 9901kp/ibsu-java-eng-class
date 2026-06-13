package ge.ibsu.demo.controllers;

import ge.ibsu.demo.dto.OrderStatusCount;
import ge.ibsu.demo.dto.TopSpenderDto;
import ge.ibsu.demo.services.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/status-counts")
    public List<OrderStatusCount> getStatusCounts() {
        return orderService.getOrderStatusCounts();
    }

    @GetMapping("/top-spenders")
    public List<TopSpenderDto> getTopSpenders() {
        return orderService.getTop5Spenders();
    }
}