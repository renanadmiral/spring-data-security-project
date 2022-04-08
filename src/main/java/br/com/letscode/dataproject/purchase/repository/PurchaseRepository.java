package br.com.letscode.dataproject.purchase.repository;

import br.com.letscode.dataproject.customer.model.Customer;
import br.com.letscode.dataproject.purchase.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    public List<Purchase> findByCustomer(Customer customer);
}
