package com.techstore.app.controller;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techstore.app.model.Cpu;
import com.techstore.app.services.CpuServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/api/cpu")
@CrossOrigin("http://localhost:5173")
public class CpuController {
    private final CpuServices _CpuServices;

    public CpuController(CpuServices cpuServices) {
        this._CpuServices = cpuServices;
    }

    @GetMapping("")
    public Set<Cpu> getAllCpu() {
        return _CpuServices.GetAllCpu();
    }

    @GetMapping("/active-cpu")
    public Set<Cpu> getActiveCpu() {
        return _CpuServices.GetActiveCpu();
    }

    @GetMapping("/inactive-cpu")
    public Set<Cpu> getInActiveCpu() {
        return _CpuServices.GetInActiveCpu();
    }

    @GetMapping("/deactivate-cpu/{cpuId}")
    public Cpu deactivateCpu(@PathVariable int cpuId) {
        return _CpuServices.DeactivateCpuStatus(cpuId);
    }

    @GetMapping("/activate-cpu/{cpuId}")
    public Cpu activateCpu(@PathVariable int cpuId) {
        return _CpuServices.ActivateCpuStatus(cpuId);
    }
}
