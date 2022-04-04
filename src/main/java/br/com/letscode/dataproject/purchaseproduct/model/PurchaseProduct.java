package br.com.letscode.dataproject.purchaseproduct.model;

import br.com.letscode.dataproject.product.model.Product;
import br.com.letscode.dataproject.purchase.model.Purchase;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity(name = "purchase_product")
public class PurchaseProduct {

    @EmbeddedId
    private PurchaseProductKey purchaseProductKey;

    @Column(nullable = false)
    private Integer ammountSold;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idPurchase")
    @JoinColumn(name = "id_purchase")
    private Purchase purchase;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idProduct")
    @JoinColumn(name = "id_product")
    private Product product;
}
