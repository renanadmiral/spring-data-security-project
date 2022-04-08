package br.com.letscode.dataproject.product.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.letscode.dataproject.product.dto.ProductResponse;
import br.com.letscode.dataproject.product.model.Product;
import br.com.letscode.dataproject.product.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductResponse> getProducts() {
        return productService.findAll();
    }
}
