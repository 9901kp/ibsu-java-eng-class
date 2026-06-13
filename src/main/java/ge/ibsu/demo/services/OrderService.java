package ge.ibsu.demo.services;

import ge.ibsu.demo.dto.OrderStatusCount;
import ge.ibsu.demo.dto.TopSpenderDto;
import ge.ibsu.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderStatusCount> getOrderStatusCounts() {
        return orderRepository.countOrdersByStatus();
    }

    public List<TopSpenderDto> getTop5Spenders() {
        Pageable pageable = PageRequest.of(0, 5);
        return orderRepository.findTopSpenders(pageable);
    }
}