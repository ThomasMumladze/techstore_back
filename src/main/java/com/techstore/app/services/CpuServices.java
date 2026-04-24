package com.techstore.app.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.techstore.app.model.Cpu;
import com.techstore.app.repository.CpuRepository;

@Service
public class CpuServices {
    private final CpuRepository _cpuRepository;

    public CpuServices(CpuRepository cpuRepository) {
        this._cpuRepository = cpuRepository;
    }

    // returns sets of the active cpu
    public Set<Cpu> GetActiveCpu() {
        return _cpuRepository.getActiveCpu();
    }

    // returns set of the inactive cpu
    public Set<Cpu> GetInActiveCpu() {
        return _cpuRepository.getActiveCpu();
    }

    // returns all status cpu
    public List<Cpu> GetAllCpu() {
        return _cpuRepository.findAll();
    }

    // deactivates cpu if needed
    public Cpu DeactivateCpuStatus(int id) {
        Cpu cpu = _cpuRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No Cpu found with id " + id));

        if (!cpu.isActive())
            throw new IllegalStateException("CPU is already inactive");

        cpu.setActive(false);
        cpu.setUpdatedAt(LocalDateTime.now());
        return _cpuRepository.save(cpu);
    }

    // activate cpu if needed
    public Cpu ActivateCpuStatus(int id) {
        Cpu cpu = _cpuRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No Cpu found with id " + id));

        if (cpu.isActive())
            throw new IllegalStateException("CPU is already active");

        cpu.setActive(true);
        cpu.setUpdatedAt(LocalDateTime.now());
        return _cpuRepository.save(cpu);
    }

    // adding new cpu based on constructor
    public Cpu AddNewCpu() {
        Cpu cpu = new Cpu(
                "Intel",
                "Core i7",
                "13th Gen",
                "i7-13700K",
                "LGA1700",
                16,
                24,
                "https://athome.ge/wp-content/uploads/2025/09/Intel-Core-i7-13700K.png , https://www.techspot.com/articles-info/2554/images/2022-10-21-image-12.jpg , https://i.pcmag.com/imagery/reviews/00K9GpRPJgD6fW3IsnUMD21-5..v1681999901.jpg",
                "https://m.media-amazon.com/images/I/515lU6LNpsL.jpg");

        if (cpu.getManufacturer() == null || cpu.getManufacturer().isBlank())
            throw new IllegalArgumentException("Manufacturer cannot be empty");

        if (cpu.getType() == null || cpu.getType().isBlank())
            throw new IllegalArgumentException("Type cannot be empty");

        if (cpu.getGeneration() == null || cpu.getGeneration().isBlank())
            throw new IllegalArgumentException("Generation cannot be empty");

        if (cpu.getModel() == null || cpu.getModel().isBlank())
            throw new IllegalArgumentException("Model cannot be empty");

        if (cpu.getSocket() == null || cpu.getSocket().isBlank())
            throw new IllegalArgumentException("Socket cannot be empty");

        if (cpu.getCores() <= 0)
            throw new IllegalArgumentException("Cores must be greater than 0");

        if (cpu.getThreads() <= 0)
            throw new IllegalArgumentException("Threads must be greater than 0");

        if (cpu.getImg() == null || cpu.getImg().isBlank())
            throw new IllegalArgumentException("Image cannot be empty");

        try {
            Cpu saved = _cpuRepository.save(cpu);
            if (saved.getCpuId() <= 0)
                throw new RuntimeException("CPU was not saved successfully");

            cpu.setCreatedAt(LocalDateTime.now());
            cpu.setUpdatedAt(LocalDateTime.now());
            cpu.setActive(true);

            return _cpuRepository.save(saved);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save CPU: " + e.getMessage());
        }
    }
}