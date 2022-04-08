package br.com.letscode.dataproject.purchase.dto;

import br.com.letscode.dataproject.customer.dto.CustomerProductDTO;
import br.com.letscode.dataproject.purchaseproduct.model.PurchaseProduct;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PurchaseProductDTO {
    private CustomerProductDTO product;

    public static PurchaseProductDTO convert(PurchaseProduct purchaseProduct) {
        PurchaseProductDTO dto = new PurchaseProductDTO();
        dto.setProduct(CustomerProductDTO.convert(purchaseProduct.getProduct()));
        dto.getProduct().setAmmountSold(purchaseProduct.getAmmountSold());
        return dto;
    }
}
