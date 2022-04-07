package br.com.letscode.dataproject.product.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.letscode.dataproject.product.model.Product;
import lombok.Builder;

@Builder
public class ProductResponse implements Serializable {
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
