package com.techstore.app.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.techstore.app.model.Gpu;

public interface GpuRepository extends JpaRepository<Gpu, Integer> {

    @Query("SELECT g FROM Gpu g WHERE g.active = true")
    Set<Gpu> getActiveGpu();

    @Query("SELECT g FROM Gpu g WHERE g.active = false")
    Set<Gpu> getInactiveGpus();
}
