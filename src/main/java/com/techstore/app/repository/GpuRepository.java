package com.techstore.app.repository;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.techstore.app.model.Gpu;

@Repository
public class GpuRepository {
    private Set<Gpu> _gpu = new TreeSet<>();

    public void SaveGpu(Gpu gpu) {
        _gpu.add(gpu);
    }

    public Set<Gpu> GetAllGpu() {
        return new HashSet<>(_gpu);
    }

    // returns active gpu list
    public Set<Gpu> GetActiveGpu() {
        return _gpu.stream().filter(Gpu::isActive).collect(Collectors.toSet());
    }

    // returns inactive gpu list
    public Set<Gpu> GetInActiveGpu() {
        Set<Gpu> gpus = _gpu.stream().filter(gpu -> !gpu.isActive()).collect(Collectors.toSet());

        // if inactive gpu doesn't exist return empty array to avoid data mapping err
        if (gpus.isEmpty())
            return new HashSet<>();

        return gpus;
    }

    // selects current gpu with the id
    public Gpu GetGpuById(int id) {
        return _gpu.stream().filter(i -> i.getGpuId() == id).findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("No Gpu Found with id %d", id)));
    }

}
