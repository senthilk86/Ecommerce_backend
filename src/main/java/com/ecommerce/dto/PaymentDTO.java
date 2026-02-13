package com.ecommerce.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class PaymentDTO {
    private Long id;
    private BigDecimal amount;
    private String paymentMethod;
    private String status;
    private String transactionId;
}
