package br.com.letscode.dataproject.product.model;

import br.com.letscode.dataproject.purchaseproduct.model.PurchaseProduct;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String codeNumber;
    
    @NonNull
    private BigDecimal price;
    
    @NonNull
    private Integer quantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PurchaseProduct> purchaseProductList = new ArrayList<>();


}
