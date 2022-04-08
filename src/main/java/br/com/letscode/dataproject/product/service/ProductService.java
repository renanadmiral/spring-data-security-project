package br.com.letscode.dataproject.product.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.letscode.dataproject.product.dto.ProductResponse;
import br.com.letscode.dataproject.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream().map(ProductResponse::convert).collect(Collectors.toList());
    }
}
