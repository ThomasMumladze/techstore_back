package com.techstore.app.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "gpu", schema = "techstore_schema")
public class Gpu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gpu_id")
    private int gpuId;

    @Column(name = "brand", nullable = false, length = 50)
    private String brand;

    @Column(name = "manufacturer", nullable = false, length = 50)
    private String manufacturer;

    @Column(name = "capacity", nullable = false, length = 20)
    private String capacity;

    @Column(name = "model", nullable = false, length = 50)
    private String model;

    @Column(name = "interface_type", nullable = false, length = 20)
    private String interfaceType;

    @Column(name = "ram_type", nullable = false, length = 20)
    private String ramType;

    @Column(name = "img", length = 255)
    private String img;

    @Column(name = "body_image", nullable = false, columnDefinition = "NVARCHAR(MAX)")
    private String bodyImage;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public Gpu() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Gpu(int gpuId, String brand, String manufacturer, String capacity,
            String model, String interfaceType, String ramType,
            String img, String bodyImage, boolean isActive) {
        this();
        this.gpuId = gpuId;
        this.brand = brand;
        this.manufacturer = manufacturer;
        this.capacity = capacity;
        this.model = model;
        this.interfaceType = interfaceType;
        this.ramType = ramType;
        this.img = img;
        this.bodyImage = bodyImage;
        this.isActive = isActive;
    }
}
