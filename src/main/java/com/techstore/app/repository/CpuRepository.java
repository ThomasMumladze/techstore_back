package com.techstore.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.techstore.app.model.Cpu;
import java.util.Set;

public interface CpuRepository extends JpaRepository<Cpu, Integer> {

    @Query("SELECT c FROM Cpu c WHERE c.active = true")
    Set<Cpu> getActiveCpu();

    @Query("SELECT c FROM Cpu c WHERE c.active = false")
    Set<Cpu> getInactiveCpu();
}