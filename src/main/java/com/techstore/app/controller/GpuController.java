package com.techstore.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techstore.app.model.Gpu;
import com.techstore.app.services.GpuServices;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/gpu")
@CrossOrigin("http://localhost:5173")
public class GpuController {
    private final GpuServices _GpuServices;

    public GpuController(GpuServices gpuServices) {
        this._GpuServices = gpuServices;
    }

    @GetMapping("")
    public ResponseEntity<Set<Gpu>> getAllGpu() {
        Set<Gpu> gpus = _GpuServices.getAllGpu();
        if (gpus.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204
        }
        return ResponseEntity.ok(gpus); // 200
    }

    @GetMapping("/active-gpu")
    public ResponseEntity<Set<Gpu>> getActiveGpu() {
        Set<Gpu> gpus = _GpuServices.getActiveGpu();
        if (gpus.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204
        }
        return ResponseEntity.ok(gpus); // 200
    }

    @GetMapping("/inactive-gpu")
    public ResponseEntity<Set<Gpu>> getInActiveGpu() {
        Set<Gpu> gpus = _GpuServices.getInActiveGpu();
        if (gpus.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204
        }
        return ResponseEntity.ok(gpus); // 200
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gpu> getGpuById(@PathVariable int id) {
        return ResponseEntity.ok(_GpuServices.getGpuById(id));
    }
}
