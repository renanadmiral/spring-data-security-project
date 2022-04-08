package br.com.letscode.dataproject.purchase.controller;

import br.com.letscode.dataproject.purchase.dto.PurchaseDTO;
import br.com.letscode.dataproject.purchase.service.PurchaseService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
public class PurchaseController {
   
   private final PurchaseService purchaseService;

    @GetMapping
    public Page<PurchaseDTO> getPurchases(@RequestParam(name = "cpf", required = false) String cpf, Pageable pageable) {
       return (cpf == null) ? purchaseService.getAllPurchases(pageable) : purchaseService.getAllPurchasesByRegistration(cpf, pageable);
    }

    @PostMapping
    public PurchaseDTO createPurchase(@RequestBody PurchaseDTO purchase) {
        return purchaseService.createPurchase(purchase);
    }
}
