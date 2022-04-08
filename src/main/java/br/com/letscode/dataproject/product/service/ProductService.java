package br.com.letscode.dataproject.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.letscode.dataproject.product.dto.ProductDTO;
import br.com.letscode.dataproject.product.model.Product;
import br.com.letscode.dataproject.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Page<ProductDTO> findByCodeNumber(String codeNumber, Pageable pageable) {
        return productRepository.findByCodeNumber(codeNumber, pageable).map(ProductDTO::convert);
    }

    public Product findByCodeNumber(String codeNumber) {
        return productRepository.findByCodeNumber(codeNumber);
    }

    public Page<ProductDTO> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable).map(ProductDTO::convert);
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
