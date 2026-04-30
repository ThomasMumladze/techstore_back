package com.techstore.app.dto;

import java.time.LocalDateTime;

import com.techstore.app.model.ProductPrice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GpuDto {
    private int gpuId;
    private String brand;
    private String manufacturer;
    private String capacity;
    private String model;
    private String interfaceType;
    private String ramType;
    private String img;
    private String bodyImage;
    private boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ProductPrice productPrice = new ProductPrice();
}
