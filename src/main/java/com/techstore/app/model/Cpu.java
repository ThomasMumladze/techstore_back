package com.techstore.app.model;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Cpu {
    private int cpuId;
    private String manufacturer;
    private String type;
    private String generation;
    private String model;
    private String socket;
    private String cores;
    private String threads;
    private String img;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Cpu() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Cpu(int cpuId, String manufacturer, String type, String generation,
            String model, String socket, String cores, String threads,
            String img, boolean active) {
        this();
        this.cpuId = cpuId;
        this.manufacturer = manufacturer;
        this.type = type;
        this.generation = generation;
        this.model = model;
        this.socket = socket;
        this.cores = cores;
        this.threads = threads;
        this.img = img;
        this.active = active;
    }
}
