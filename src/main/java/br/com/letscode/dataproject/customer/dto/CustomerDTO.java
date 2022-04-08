package br.com.letscode.dataproject.customer.dto;

import br.com.letscode.dataproject.customer.model.Customer;
import br.com.letscode.dataproject.purchase.dto.PurchaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
public class CustomerDTO {
    private String name;
    private String registrationNumber;
    private Calendar birthDate;
    private List<PurchaseDTO> purchases;

    public static CustomerDTO convert(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setName(customer.getName());
        dto.setRegistrationNumber(customer.getRegistrationNumber());
        dto.setBirthDate(customer.getBirthDate());
        dto.setPurchases(customer.getPurchases()
                .stream()
                .map(PurchaseDTO::convert)
                .collect(Collectors.toList())
        );
        return dto;
    }
}
