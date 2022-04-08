package br.com.letscode.dataproject.purchase.service;

import br.com.letscode.dataproject.customer.model.Customer;
import br.com.letscode.dataproject.customer.repository.CustomerRepository;
import br.com.letscode.dataproject.customer.service.CustomerService;
import br.com.letscode.dataproject.product.model.Product;
import br.com.letscode.dataproject.product.service.ProductService;
import br.com.letscode.dataproject.purchase.dto.PurchaseDTO;
import br.com.letscode.dataproject.purchase.model.Purchase;
import br.com.letscode.dataproject.purchase.repository.PurchaseRepository;
import br.com.letscode.dataproject.purchaseproduct.model.PurchaseProduct;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    private final CustomerService customerService;

    private final ProductService productService;

    public Page<PurchaseDTO> getAllPurchases(Pageable pageable) {
        return purchaseRepository.findAll(pageable).map(PurchaseDTO::convert);
    }

    public Page<PurchaseDTO> getAllPurchasesByRegistration(String cpf, Pageable pageable) {

        Customer customer = customerService.getCustomerByRegistration(cpf);

        return purchaseRepository.findByCustomer(customer, pageable).map(PurchaseDTO::convert);
    }

    public PurchaseDTO createPurchase(PurchaseDTO purchase) {
        Customer customer = customerService.getCustomerByRegistration(purchase.getCustomerPurchase().getRegistrationNumber());
        Purchase p = new Purchase(
            purchase.getPurchaseDate(),
            purchase.getValue(),
            customer
        );

        p = purchaseRepository.save(p);

        // erro desconhecido 
        // List<Product> productsSold = purchase.getProductsSold().stream().map(p -> {
        //     return productService.findByCodeNumber(p.getProduct().getCodeNumber());
        // }).collect(Collectors.toList());

        // p.getPurchaseProductList().addAll(productsSold);
        

        // TODO precisa-se saber o momento de criar o purchase_product para poder iterar por cada produto, pegar seu id e código especifico e salvar na tupla

        // p.getPurchaseProductList().stream().map(p -> {
        //     p.setQuantity(p.getQuantity() - );
        // }).collect(Collectors.toList());

        return null;
    }
}
