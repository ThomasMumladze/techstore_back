package com.techstore.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class CpuDto {
    private int cpuId;
    private String manufacturer;
    private String type;
    private String generation;
    private String model;
    private String socket;
    private int cores;
    private int threads;
    private String img;
    private String bodyImage;
}