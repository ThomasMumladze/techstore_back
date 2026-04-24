package com.techstore.app.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/cpu")
@CrossOrigin("http://localhost:5173")
public class CpuController {
    private final CpuServices cpuServices;

    public CpuController(CpuServices cpuServices) {
        this.cpuServices = cpuServices;
    }

    @GetMapping("")
    public ResponseEntity<List<Cpu>> getAllCpu() {
        List<Cpu> cpus = cpuServices.GetAllCpu();
        if (cpus.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cpus);
    }

    @GetMapping("/active-cpu")
    public ResponseEntity<Set<Cpu>> getActiveCpu() {
        Set<Cpu> cpus = cpuServices.GetActiveCpu();
        if (cpus.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cpus);
    }

    @GetMapping("/inactive-cpu")
    public ResponseEntity<Set<Cpu>> getInActiveCpu() {
        Set<Cpu> cpus = cpuServices.GetInActiveCpu();
        if (cpus.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cpus);
    }

    @PutMapping("/deactivate-cpu/{cpuId}")
    public ResponseEntity<Cpu> deactivateCpu(@PathVariable int cpuId) {
        return ResponseEntity.ok(cpuServices.DeactivateCpuStatus(cpuId));
    }

    @PutMapping("/activate-cpu/{cpuId}")
    public ResponseEntity<Cpu> activateCpu(@PathVariable int cpuId) {
        return ResponseEntity.ok(cpuServices.ActivateCpuStatus(cpuId));
    }

    @PostMapping("/add-cpu")
    public ResponseEntity<Cpu> addNewCpu() {
        return ResponseEntity.ok(cpuServices.AddNewCpu());
    }
}