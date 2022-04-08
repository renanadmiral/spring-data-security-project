package br.com.letscode.dataproject.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.letscode.dataproject.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
