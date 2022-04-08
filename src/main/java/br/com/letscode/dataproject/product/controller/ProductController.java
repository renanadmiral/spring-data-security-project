package br.com.letscode.dataproject.product.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.letscode.dataproject.product.dto.ProductDTO;
import br.com.letscode.dataproject.product.model.Product;
import br.com.letscode.dataproject.product.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> getProducts() {
        return productService.findAll();
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO product) {
        return productService.createProduct(product);
    }
}
