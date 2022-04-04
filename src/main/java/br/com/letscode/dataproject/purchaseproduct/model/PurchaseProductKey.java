package br.com.letscode.dataproject.purchaseproduct.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter @Setter
public class PurchaseProductKey implements Serializable {

    @Column(name = "id_purchase")
    private Integer idPurchase;

    @Column(name = "id_product")
    private Integer idProduct;
}
