package com.techstore.app.controller;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techstore.app.model.Cpu;

import com.techstore.app.services.CpuServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/cpu")
@CrossOrigin("http://localhost:5173")
public class CpuController {
    private final CpuServices _CpuServices;

    public CpuController(CpuServices cpuServices) {
        this._CpuServices = cpuServices;
    }

    @GetMapping("")
    public ResponseEntity<Set<Cpu>> getAllCpu() {
        Set<Cpu> cpus = _CpuServices.GetAllCpu();
        if (cpus.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cpus);
    }

    @GetMapping("/active-cpu")
    public ResponseEntity<Set<Cpu>> getActiveCpu() {
        Set<Cpu> cpus = _CpuServices.GetActiveCpu();
        if (cpus.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204
        }
        return ResponseEntity.ok(cpus); // 200
    }

    @GetMapping("/inactive-cpu")
    public ResponseEntity<Set<Cpu>> getInActiveCpu() {
        Set<Cpu> cpus = _CpuServices.GetInActiveCpu();
        if (cpus.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204
        }
        return ResponseEntity.ok(cpus); // 200
    }

    @PutMapping("/deactivate-cpu/{cpuId}")
    public Cpu deactivateCpu(@PathVariable int cpuId) {
        return _CpuServices.DeactivateCpuStatus(cpuId);
    }

    @PutMapping("/activate-cpu/{cpuId}")
    public Cpu activateCpu(@PathVariable int cpuId) {
        return _CpuServices.ActivateCpuStatus(cpuId);
    }
}
