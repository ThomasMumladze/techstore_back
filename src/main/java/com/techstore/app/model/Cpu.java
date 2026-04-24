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
@Table(name = "cpu", schema = "techstore_schema")
public class Cpu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cpuId;

    @Column(name = "manufacturer", nullable = false, length = 30)
    private String manufacturer;

    @Column(name = "type", nullable = false, length = 50)
    private String type;

    @Column(name = "generation", nullable = false, length = 10)
    private String generation;

    @Column(name = "model", nullable = false, length = 25)
    private String model;

    @Column(name = "socket", nullable = false, length = 15)
    private String socket;

    @Column(name = "cores", nullable = false)
    private int cores;

    @Column(name = "threads", nullable = false)
    private int threads;

    @Column(name = "img", nullable = false, length = 255)
    private String img;

    @Column(name = "body_image", nullable = false, columnDefinition = "NVARCHAR(MAX)")
    private String bodyImage;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public Cpu() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Cpu(String manufacturer, String type, String generation,
            String model, String socket, int cores, int threads, String bodyImage,
            String img) {
        this();
        this.manufacturer = manufacturer;
        this.type = type;
        this.generation = generation;
        this.model = model;
        this.socket = socket;
        this.cores = cores;
        this.threads = threads;
        this.bodyImage = bodyImage;
        this.img = img;
    }
}
