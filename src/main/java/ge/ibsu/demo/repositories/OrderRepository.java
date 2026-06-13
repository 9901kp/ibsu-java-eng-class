package ge.ibsu.demo.repositories;

import ge.ibsu.demo.entities.Order;
import ge.ibsu.demo.dto.OrderStatusCount;
import ge.ibsu.demo.dto.TopSpenderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable; // УБЕДИСЬ, ЧТО ИМПОРТ ИМЕННО ТАКОЙ!
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT new ge.ibsu.demo.dto.OrderStatusCount(o.status, COUNT(o)) " +
            "FROM Order o GROUP BY o.status")
    List<OrderStatusCount> countOrdersByStatus();

    @Query("SELECT new ge.ibsu.demo.dto.TopSpenderDto(o.userId, SUM(o.totalAmount)) " +
            "FROM Order o " +
            "GROUP BY o.userId " +
            "ORDER BY SUM(o.totalAmount) DESC")
    List<TopSpenderDto> findTopSpenders(Pageable pageable);
}