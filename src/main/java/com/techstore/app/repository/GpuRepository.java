package com.techstore.app.repository;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Repository;

import com.techstore.app.model.Gpu;

@Repository
public class GpuRepository {
    private Set<Gpu> _gpu = new TreeSet<>();

    public void SaveGpu(Gpu gpu) {
        _gpu.add(gpu);
    }

    public Set<Gpu> ReturnAllGpu() {
        return new HashSet<>(_gpu);
    }

}
