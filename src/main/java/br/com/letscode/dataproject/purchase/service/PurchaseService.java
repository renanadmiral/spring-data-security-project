package br.com.letscode.dataproject.purchase.service;

import br.com.letscode.dataproject.customer.model.Customer;
import br.com.letscode.dataproject.customer.repository.CustomerRepository;
import br.com.letscode.dataproject.customer.service.CustomerService;
import br.com.letscode.dataproject.product.model.Product;
import br.com.letscode.dataproject.product.service.ProductService;
import br.com.letscode.dataproject.purchase.dto.PurchaseDTO;
import br.com.letscode.dataproject.purchase.dto.PurchaseProductDTO;
import br.com.letscode.dataproject.purchase.dto.request.RequestPurchaseDTO;
import br.com.letscode.dataproject.purchase.model.Purchase;
import br.com.letscode.dataproject.purchase.repository.PurchaseRepository;
import br.com.letscode.dataproject.purchaseproduct.model.PurchaseProduct;
import br.com.letscode.dataproject.purchaseproduct.model.PurchaseProductKey;
import br.com.letscode.dataproject.purchaseproduct.repository.PurchaseProductRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    private final CustomerService customerService;

    private final ProductService productService;

    private final PurchaseProductRepository purchaseProductRepository;

    public Page<PurchaseDTO> getAllPurchases(Pageable pageable) {
        return purchaseRepository.findAll(pageable).map(PurchaseDTO::convert);
    }

    public Page<PurchaseDTO> getAllPurchasesByRegistration(String cpf, Pageable pageable) {

        Customer customer = customerService.getCustomerByRegistration(cpf);

        return purchaseRepository.findByCustomer(customer, pageable).map(PurchaseDTO::convert);
    }

    public PurchaseDTO createPurchase(RequestPurchaseDTO request) {

        Customer customer = customerService.getCustomerByRegistration(request.getCustomerRegistration());

        Purchase newPurchase = purchaseRepository.save(new Purchase(
                Calendar.getInstance(),
                0.01f,
                customer
        ));

        List<PurchaseProduct> purchaseProductList = request.getProducts().stream()
                .map(p -> {
                    Product nP = productService.findByCodeNumber(p.getCodeNumber());
                    newPurchase.setValue(newPurchase.getValue() + (nP.getPrice() * p.getAmmount()));

                    return purchaseProductRepository.save(new PurchaseProduct(
                            new PurchaseProductKey(newPurchase.getId(), nP.getId()),
                            p.getAmmount(),
                            newPurchase, nP
                    ));
                })
                .collect(Collectors.toList())
        ;

        newPurchase.setPurchaseProductList(purchaseProductList);

        purchaseRepository.save(newPurchase);

        return PurchaseDTO.convert(newPurchase);
    }

    private static BigDecimal calculateValueOfPurchaseRequest(List<PurchaseProductDTO> products) {
        Double sum = 0D;
        for(PurchaseProductDTO product : products) {
            sum += product.getProduct().getPrice().doubleValue();
        }
        return BigDecimal.valueOf(sum);
    }

    private static BigDecimal calculateValueOfPurchase(List<Product> products) {
        Double sum = 0D;
        for(Product product : products) {
            sum += product.getPrice().doubleValue();
        }
        return BigDecimal.valueOf(sum);
    }
}
