package br.com.letscode.dataproject.product.model;

import br.com.letscode.dataproject.purchaseproduct.model.PurchaseProduct;
import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(
            nullable = false,
            unique = true,
            columnDefinition = "char(10) check(length(code_number) = 10)"
    )
    private String codeNumber;

    @Column(
            nullable = false,
            columnDefinition = "float check(price > 0)"
    )
    private BigDecimal price;

    @Column(nullable = false,
            columnDefinition = "int8 check(quantity >= 0)"
    )
    private Long quantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PurchaseProduct> purchaseProductList;
}
