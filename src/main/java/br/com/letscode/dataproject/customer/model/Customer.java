package br.com.letscode.dataproject.customer.model;

import br.com.letscode.dataproject.purchase.model.Purchase;
import lombok.*;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Getter @Setter
@Entity(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    @NonNull
    private String name;

    @Column(
            nullable = false,
            unique = true
    )
    @NonNull
    private String registrationNumber;

    @Column(nullable = false, columnDefinition = "date")
    @NonNull
    private Calendar birthDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Purchase> purchases;
}
