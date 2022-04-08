package br.com.letscode.dataproject.customer.dto;

import br.com.letscode.dataproject.product.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CustomerProductDTO {
    private String codeNumber;
    private Float price;
    private Integer ammountSold;

    public static CustomerProductDTO convert(Product product) {
        CustomerProductDTO dto = new CustomerProductDTO();
        dto.setCodeNumber(product.getCodeNumber());
        dto.setPrice(product.getPrice());
        return dto;
    }
}


