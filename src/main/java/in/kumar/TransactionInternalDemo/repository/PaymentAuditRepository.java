package in.kumar.TransactionInternalDemo.repository;

import in.kumar.TransactionInternalDemo.model.PaymentAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentAuditRepository extends JpaRepository<PaymentAudit , Long> {

}
