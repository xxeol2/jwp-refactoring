package kitchenpos.repository;

import java.util.List;
import kitchenpos.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o LEFT JOIN FETCH o.orderLineItems")
    List<Order> findAllWithFetch();

    default Order findByIdOrThrow(Long id) {
        return findById(id)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 주문입니다."));
    }
}