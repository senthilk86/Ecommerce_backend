package com.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CheckoutRequest {
    
    @NotBlank(message = "Shipping address is required")
    private String shippingAddress;
    
    @NotBlank(message = "City is required")
    private String shippingCity;
    
    @NotBlank(message = "State is required")
    private String shippingState;
    
    @NotBlank(message = "Zip code is required")
    private String shippingZipCode;
    
    @NotBlank(message = "Country is required")
    private String shippingCountry;
    
    @NotNull(message = "Payment method is required")
    private String paymentMethod;
}
