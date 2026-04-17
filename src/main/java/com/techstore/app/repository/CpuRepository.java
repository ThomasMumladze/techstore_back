package com.techstore.app.repository;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.techstore.app.model.Cpu;

@Repository
public class CpuRepository {
    private Set<Cpu> _cpu = new TreeSet<>();

    public void SaveCpu(Cpu cpu) {
        _cpu.add(cpu);
    }

    // returns all cpu (active and inactive)
    public Set<Cpu> getAllCpu() {
        return new HashSet<>(_cpu);
    }

    // returns only active cpu
    public Set<Cpu> GetActiveCpu() {
        return _cpu.stream()
                .filter(Cpu::isActive)
                .collect(Collectors.toSet());
    }

    // returns inactive cpu list if its exist
    public Set<Cpu> GetInactiveCpu() {
        Set<Cpu> result = _cpu.stream()
                .filter(cpu -> !cpu.isActive())
                .collect(Collectors.toSet());

        if (result.isEmpty()) {
            return new HashSet<>();
        }

        return result;
    }

    // selects current cpu with the id
    public Cpu getCpuBiId(int id) {
        return _cpu.stream()
                .filter(i -> i.getCpuId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("No Cpu found with id %d", id)));
    }

    // deactivates cpu status to false
    public Cpu deactivateCpuStatus(int id) {
        var cpu = getCpuBiId(id);

        if (!cpu.isActive()) {
            throw new IllegalStateException("CPU is already inactive");
        }

        cpu.setActive(false);
        cpu.setUpdatedAt(LocalDateTime.now());

        return cpu;
    }

    // activates cpu status to true
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
