package com.techstore.app.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.techstore.app.model.Cpu;
import com.techstore.app.repository.CpuRepository;

@Service
public class CpuServices {
    private final CpuRepository _CpuRepository;

    public CpuServices(CpuRepository cpuRepository) {
        this._CpuRepository = cpuRepository;
    }

    public Set<Cpu> GetActiveCpu() {
        return _CpuRepository.GetActiveCpu();
    }

    public Set<Cpu> GetInActiveCpu() {
        return _CpuRepository.GetInactiveCpu();
    }

    public Set<Cpu> GetAllCpu() {
        return _CpuRepository.getAllCpu();
    }

    public Cpu DeactivateCpuStatus(int id) {
        return _CpuRepository.deactivateCpuStatus(id);
    }

    public Cpu ActivateCpuStatus(int id) {
        return _CpuRepository.activateCpuStatus(id);
    }
}