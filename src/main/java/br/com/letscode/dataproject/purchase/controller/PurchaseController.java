package br.com.letscode.dataproject.purchase.controller;

import br.com.letscode.dataproject.purchase.dto.PurchaseDTO;
import br.com.letscode.dataproject.purchase.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//@RequestMapping("/purchase")
//public class PurchaseController {
//    @Autowired
//    private PurchaseService purchaseService;
//
//    @GetMapping
//    public List<PurchaseDTO> getPurchases(@RequestParam(name = "cpf", required = false) String param) {
//        return purchaseService.getAllPurchasesByRegistration(param);
//    }
//}
