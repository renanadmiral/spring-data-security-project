package br.com.letscode.dataproject.customer.repository;

import br.com.letscode.dataproject.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Customer findByRegistrationNumber(String registrationNumber);
}
