package com.techstore.app.services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.techstore.app.model.Gpu;
import com.techstore.app.repository.GpuRepository;

@Service
public class GpuServices {
    private final GpuRepository _gpuRepository;

    public GpuServices(GpuRepository gpuRepository) {
        this._gpuRepository = gpuRepository;
    }

    // return sets of active Gpu
    public Set<Gpu> GetActiveGpu() {
        return _gpuRepository.getActiveGpu();
    }

    // return sets of inactive Gpu
    public Set<Gpu> GetInActiveGpu() {
        return _gpuRepository.getInactiveGpus();
    }

    // return all status Gpu
    public List<Gpu> GetAllGpu() {
        return _gpuRepository.findAll();
    }

}
