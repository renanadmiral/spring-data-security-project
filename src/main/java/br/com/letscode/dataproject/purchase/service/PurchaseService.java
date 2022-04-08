package br.com.letscode.dataproject.purchase.service;

import br.com.letscode.dataproject.customer.model.Customer;
import br.com.letscode.dataproject.customer.repository.CustomerRepository;
import br.com.letscode.dataproject.customer.service.CustomerService;
import br.com.letscode.dataproject.purchase.dto.PurchaseDTO;
import br.com.letscode.dataproject.purchase.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private CustomerService customerService;

    public List<PurchaseDTO> getAllPurchases() {

        return purchaseRepository.findAll()
                .stream().map(PurchaseDTO::convert)
                .collect(Collectors.toList());
    }

    public List<PurchaseDTO> getAllPurchasesByRegistration(String registrationNumber) {

        Customer customer = customerService.getCustomerByRegistration(registrationNumber);

        return purchaseRepository.findByCustomer(customer)
                .stream().map(PurchaseDTO::convert)
                .collect(Collectors.toList())
        ;
    }
}
