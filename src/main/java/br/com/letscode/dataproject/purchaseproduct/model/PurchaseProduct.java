package br.com.letscode.dataproject.purchaseproduct.model;

import br.com.letscode.dataproject.product.model.Product;
import br.com.letscode.dataproject.purchase.model.Purchase;
import lombok.*;

import javax.persistence.*;

@Getter @Setter
@Entity(name = "purchase_product")
@NoArgsConstructor
@RequiredArgsConstructor
public class PurchaseProduct {

    @EmbeddedId
    @NonNull
    private PurchaseProductKey purchaseProductKey;

    @Column(nullable = false)
    @NonNull
    private Integer ammountSold;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idPurchase")
    @JoinColumn(name = "id_purchase")
    @NonNull
    private Purchase purchase;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idProduct")
    @JoinColumn(name = "id_product")
    @NonNull
    private Product product;
}
