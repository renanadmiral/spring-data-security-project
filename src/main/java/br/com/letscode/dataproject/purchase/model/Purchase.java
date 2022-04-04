package br.com.letscode.dataproject.purchase.model;

import br.com.letscode.dataproject.customer.model.Customer;
import br.com.letscode.dataproject.purchaseproduct.model.PurchaseProduct;
import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@Getter
@Entity(name = "purchase")
public class Purchase {
    //dados: data da compra, cpf do cliente, o valor total da compra e a lista de produtos que fazem parte da compra.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Calendar purchaseDate;

    private BigDecimal value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PurchaseProduct> purchaseProductList;
}
