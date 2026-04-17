package com.techstore.app.repository;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Repository;

import com.techstore.app.model.Cpu;

@Repository
public class CpuRepository {
    private Set<Cpu> _cpu = new TreeSet<>();

    public void SaveCpu(Cpu cpu) {
        _cpu.add(cpu);
    }

    public Cpu getCpuBiId(int id) {
        return _cpu.stream().filter(i -> i.getCpuId() == id).findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("No Cpu found with id %d", id), null));
    }

    public Cpu deactivateCpuStatus(int id) {
        var cpu = getCpuBiId(id);

        if (!cpu.isActive()) {
            throw new IllegalStateException("CPU is already inactive");
        }

        cpu.setActive(false);
        cpu.setUpdatedAt(LocalDateTime.now());

        return cpu;
    }

    public Cpu activateCpuStatus(int id) {
        var cpu = getCpuBiId(id);

        if (cpu.isActive()) {
            throw new IllegalStateException("CPU is already active");
        }

        cpu.setActive((true));
        cpu.setUpdatedAt(LocalDateTime.now());
        return cpu;
    }
}
