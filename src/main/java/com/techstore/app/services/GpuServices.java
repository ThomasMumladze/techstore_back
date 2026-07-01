package com.techstore.app.services;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.techstore.app.model.Gpu;
import com.techstore.app.repository.GpuRepository;

@Service
public class GpuServices {

    private static final Logger log = LoggerFactory.getLogger(GpuServices.class);

    private final GpuRepository _gpuRepository;

    public GpuServices(GpuRepository gpuRepository) {
        this._gpuRepository = gpuRepository;
    }

    @Cacheable("activeGpus")
    public Set<Gpu> GetActiveGpu() {
        log.info("DB-დან აქტიური GPU-ები");
        return _gpuRepository.getActiveGpu();
    }

    @Cacheable("inactiveGpus")
    public Set<Gpu> GetInActiveGpu() {
        log.info("DB-დან არააქტიური GPU-ები");
        return _gpuRepository.getInactiveGpus();
    }

    @Cacheable("allGpus")
    public List<Gpu> GetAllGpu() {
        log.info("DB-დან ყველა GPU");
        return _gpuRepository.findAll();
    }

    @CacheEvict(value = { "activeGpus", "inactiveGpus", "allGpus" }, allEntries = true)
    public void evictAllGpuCaches() {
    }
}