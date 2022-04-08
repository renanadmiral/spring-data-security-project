package br.com.letscode.dataproject.purchase.dto;

import br.com.letscode.dataproject.purchase.model.Purchase;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
public class PurchaseDTO {
    private Calendar purchaseDate;
    private BigDecimal value;
    private List<PurchaseProductDTO> productsSold;

    public static PurchaseDTO convert (Purchase purchase) {
        PurchaseDTO dto = new PurchaseDTO();
        dto.setPurchaseDate(purchase.getPurchaseDate());
        dto.setValue(purchase.getValue());
        dto.setProductsSold(purchase.getPurchaseProductList()
                .stream()
                .map(PurchaseProductDTO::convert)
                .collect(Collectors.toList())
        );
        return dto;
    }
}
