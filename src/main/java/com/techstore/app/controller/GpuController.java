package com.techstore.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techstore.app.model.Gpu;
import com.techstore.app.services.GpuServices;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/gpu")
@CrossOrigin("http://localhost:5173")
public class GpuController {
    private final GpuServices _gpuServices;

    public GpuController(GpuServices gpuServices) {
        this._gpuServices = gpuServices;
    }

    @GetMapping("")
    public ResponseEntity<List<Gpu>> getAllGpu() {
        List<Gpu> gpus = _gpuServices.GetAllGpu();
        if (gpus.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(gpus);
    }

    @GetMapping("/active-gpu")
    public ResponseEntity<Set<Gpu>> getActiveGpu() {
        Set<Gpu> gpus = _gpuServices.GetActiveGpu();
        if (gpus.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(gpus);
    }

    @GetMapping("/inactive-gpu")
    public ResponseEntity<Set<Gpu>> getInActiveGpu() {
        Set<Gpu> gpus = _gpuServices.GetInActiveGpu();
        if (gpus.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(gpus);
    }
}
