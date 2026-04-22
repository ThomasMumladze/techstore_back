package com.techstore.app.model;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Gpu {
    private int gpuId;
    private String brand;
    private String manufacturer;
    private String capacity;
    private String model;
    private String interfaceType;
    private String ramType;
    private String img;
    private boolean isActive;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Gpu() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Gpu(int gpuId, String brand, String manufacturer, String capacity,
            String model, String interfaceType, String ramType,
            String img, boolean isActive) {
        this();
        this.gpuId = gpuId;
        this.brand = brand;
        this.manufacturer = manufacturer;
        this.capacity = capacity;
        this.model = model;
        this.interfaceType = interfaceType;
        this.ramType = ramType;
        this.img = img;
        this.isActive = isActive;
    }
}
