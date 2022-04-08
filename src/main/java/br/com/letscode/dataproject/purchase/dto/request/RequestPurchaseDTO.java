package br.com.letscode.dataproject.purchase.dto.request;

import lombok.Getter;

import java.util.List;

@Getter
public class RequestPurchaseDTO {
    private String customerRegistration;
    private List<RequestProductPurchaseDTO> products;
}
