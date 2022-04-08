package br.com.letscode.dataproject.customer.dto;

import java.util.Calendar;

import br.com.letscode.dataproject.customer.model.Customer;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class CustomerPurchaseDTO {
    private String name;
    private String registrationNumber;
    private Calendar birthDate;

    public static CustomerPurchaseDTO convert(Customer customer) {
        return new CustomerPurchaseDTO(
            customer.getName(),
            customer.getRegistrationNumber(),
            customer.getBirthDate()
        );
    }
}
