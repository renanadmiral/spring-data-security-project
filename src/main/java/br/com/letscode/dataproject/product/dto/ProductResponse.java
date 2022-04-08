package br.com.letscode.dataproject.product.dto;

import java.math.BigDecimal;

import br.com.letscode.dataproject.product.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private String codeNumber;
    private BigDecimal price;
    private Integer quantity;

    public static ProductResponse convert(Product product) {
        return new ProductResponse(
            product.getCodeNumber(), 
            product.getPrice(),
            product.getQuantity()
        );
    }
}
