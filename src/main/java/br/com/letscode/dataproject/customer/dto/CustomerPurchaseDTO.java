package br.com.letscode.dataproject.customer.dto;

import br.com.letscode.dataproject.purchase.model.Purchase;
import br.com.letscode.dataproject.purchaseproduct.model.PurchaseProduct;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
public class CustomerPurchaseDTO {
    private Calendar purchaseDate;
    private BigDecimal value;
    private List<CustomerPurchaseProductDTO> productsSold;

    public static CustomerPurchaseDTO convert (Purchase purchase) {
        CustomerPurchaseDTO dto = new CustomerPurchaseDTO();
        dto.setPurchaseDate(purchase.getPurchaseDate());
        dto.setValue(purchase.getValue());
        dto.setProductsSold(purchase.getPurchaseProductList()
                .stream()
                .map(CustomerPurchaseProductDTO::convert)
                .collect(Collectors.toList())
        );
        return dto;
    }
}
