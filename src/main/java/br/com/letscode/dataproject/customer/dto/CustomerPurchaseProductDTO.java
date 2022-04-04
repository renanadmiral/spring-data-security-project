package br.com.letscode.dataproject.customer.dto;

import br.com.letscode.dataproject.product.model.Product;
import br.com.letscode.dataproject.purchaseproduct.model.PurchaseProduct;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CustomerPurchaseProductDTO {
    private CustomerProductDTO product;

    public static CustomerPurchaseProductDTO convert(PurchaseProduct purchaseProduct) {
        CustomerPurchaseProductDTO dto = new CustomerPurchaseProductDTO();
        dto.setProduct(CustomerProductDTO.convert(purchaseProduct.getProduct()));
        dto.getProduct().setAmmountSold(purchaseProduct.getAmmountSold());
        return dto;
    }
}
