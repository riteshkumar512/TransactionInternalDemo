package in.kumar.TransactionInternalDemo.repository;

import in.kumar.TransactionInternalDemo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
