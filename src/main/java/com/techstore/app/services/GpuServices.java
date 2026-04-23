package com.techstore.app.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.techstore.app.model.Gpu;
import com.techstore.app.repository.GpuRepository;

@Service
public class GpuServices {
    private final GpuRepository _GpuRepository;

    public GpuServices(GpuRepository gpuRepository) {
        this._GpuRepository = gpuRepository;
    }

    public Set<Gpu> getAllGpu() {
        return _GpuRepository.GetAllGpu();
    }

    public Set<Gpu> getActiveGpu() {
        return _GpuRepository.GetActiveGpu();
    }

    public Set<Gpu> getInActiveGpu() {
        return _GpuRepository.GetInActiveGpu();
    }

    public Gpu getGpuById(int id) {
        return _GpuRepository.GetGpuById(id);
    }
}
