package br.com.letscode.dataproject.purchase.dto;

import br.com.letscode.dataproject.customer.dto.CustomerPurchaseDTO;
import br.com.letscode.dataproject.purchase.model.Purchase;
import lombok.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Getter 
@Setter
@AllArgsConstructor
public class PurchaseDTO {
    private Calendar purchaseDate;
    private BigDecimal value;
    private CustomerPurchaseDTO customerPurchase;
    private List<PurchaseProductDTO> productsSold;

    public static PurchaseDTO convert (Purchase purchase) {
        return new PurchaseDTO(
            purchase.getPurchaseDate(),
            purchase.getValue(),
            CustomerPurchaseDTO.convert(purchase.getCustomer()),
            purchase.getPurchaseProductList()
                .stream()
                .map(PurchaseProductDTO::convert)
                .collect(Collectors.toList())
        );
    }
}
