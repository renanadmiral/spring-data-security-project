package br.com.letscode.dataproject.purchaseproduct.repository;

import br.com.letscode.dataproject.purchaseproduct.model.PurchaseProduct;
import br.com.letscode.dataproject.purchaseproduct.model.PurchaseProductKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseProductRepository extends JpaRepository<PurchaseProduct, PurchaseProductKey> {
}
