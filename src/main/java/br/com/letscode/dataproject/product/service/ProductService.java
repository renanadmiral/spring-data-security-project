package br.com.letscode.dataproject.product.service;

import java.util.List;
import org.springframework.stereotype.Service;

import br.com.letscode.dataproject.product.dto.ProductDTO;
import br.com.letscode.dataproject.product.model.Product;
import br.com.letscode.dataproject.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream().map(ProductDTO::convert).toList();
    }

    public ProductDTO createProduct(ProductDTO product) {
        productRepository.save(new Product(
                product.getCodeNumber(),
                product.getPrice(), 
                product.getQuantity()
            )
        );
        return product;
    }
}
