package com.techstore.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techstore.app.model.Gpu;
import com.techstore.app.services.GpuServices;

import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/gpu")
@CrossOrigin("http://localhost:5173")
public class GpuController {
    private final GpuServices _GpuServices;

    public GpuController(GpuServices gpuServices) {
        this._GpuServices = gpuServices;
    }

    @GetMapping("")
    public Set<Gpu> getAllGpu() {
        return _GpuServices.getAllGpu();
    }

}
