package com.techstore.app.services;

import org.springframework.stereotype.Service;

import com.techstore.app.model.Cpu;

@Service
public class CpuServices {
    private final CpuServices _CpuServices;

    public CpuServices(CpuServices cpuServices) {
        this._CpuServices = cpuServices;
    }

    public Cpu DeactivateCpuStatus(int id) {
        return _CpuServices.DeactivateCpuStatus(id);
    }

    public Cpu ActivateCpuStatus(int id) {
        return _CpuServices.ActivateCpuStatus(id);
    }
}