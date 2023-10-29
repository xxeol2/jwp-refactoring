package kitchenpos.order.supports;

import java.time.LocalDateTime;
import java.util.List;
import kitchenpos.order.domain.model.Order;
import kitchenpos.order.domain.model.OrderLineItem;
import kitchenpos.order.domain.model.OrderStatus;

public class OrderFixture {

    private Long id = null;
    private Long orderTableId = 1L;
    private OrderStatus orderStatus = OrderStatus.COOKING;
    private LocalDateTime orderedTime = LocalDateTime.of(2023, 10, 2, 10, 0);
    private List<OrderLineItem> orderLineItems = List.of(
        OrderLineItemFixture.fixture().build(),
        OrderLineItemFixture.fixture().build()
    );

    private OrderFixture() {
    }

    public static OrderFixture fixture() {
        return new OrderFixture();
    }

    public OrderFixture id(Long id) {
        this.id = id;
        return this;
    }

    public OrderFixture orderTableId(Long orderTableId) {
        this.orderTableId = orderTableId;
        return this;
    }

    public OrderFixture orderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public OrderFixture orderedTime(LocalDateTime orderedTime) {
        this.orderedTime = orderedTime;
        return this;
    }

    public OrderFixture orderLineItems(List<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
        return this;
    }

    public Order build() {
        return new Order(id, orderTableId, orderStatus, orderLineItems);
    }
}