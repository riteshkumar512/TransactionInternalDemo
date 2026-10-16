package in.kumar.TransactionInternalDemo.service;

import in.kumar.TransactionInternalDemo.model.Order;
import in.kumar.TransactionInternalDemo.model.PaymentAudit;
import in.kumar.TransactionInternalDemo.repository.PaymentAuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentAuditService {

    private PaymentAuditRepository paymentAuditRepository;

    public PaymentAuditService(PaymentAuditRepository paymentAuditRepository) {
        this.paymentAuditRepository = paymentAuditRepository;
    }

    @Transactional(
            propagation = Propagation.MANDATORY
    )
    public void audit(Order order) {
        PaymentAudit paymentAudit = new PaymentAudit(order.getAmount(),
                order.getId(),true);
        paymentAuditRepository.save(paymentAudit);

        throw new RuntimeException("Some Error occured");
    }
}
