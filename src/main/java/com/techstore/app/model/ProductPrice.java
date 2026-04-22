package com.techstore.app.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProductPrice {
    private int priceId;

    private BigDecimal originalPrice;
    private BigDecimal finalPrice;

    private boolean sale;
    private int discountPercent;
    private String currency;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
