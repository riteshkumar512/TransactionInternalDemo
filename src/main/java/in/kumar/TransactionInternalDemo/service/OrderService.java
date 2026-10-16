package in.kumar.TransactionInternalDemo.service;


import in.kumar.TransactionInternalDemo.model.Order;
import in.kumar.TransactionInternalDemo.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private PaymentAuditService paymentAuditService;

    public OrderService(OrderRepository orderRepository,
                        PaymentAuditService paymentAuditService) {
        this.orderRepository = orderRepository;
        this.paymentAuditService = paymentAuditService;
    }
    @Transactional
    public void placeOrder(Order order) {
        orderRepository.save(order);

        try {
            paymentAuditService.audit(order);
        }catch (RuntimeException e){

        }

//        throw new RuntimeException("Some Error occured");


    }
}
