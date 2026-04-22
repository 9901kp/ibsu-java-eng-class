package ge.ibsu.demo.repositories;

import ge.ibsu.demo.entities.Order;
import ge.ibsu.demo.entities.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomerNameContainingIgnoreCaseAndStatusOrderByCreatedAtDesc(String customerName, OrderStatus status);
}