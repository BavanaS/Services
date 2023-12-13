package com.quinbay.InventoryService.data;

import lombok.Data;

@Data
public class Orders {

    private Long customerId;

   public Long getCustomerId() {
       return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    private Long productId;
    private String productQuantity;

}
