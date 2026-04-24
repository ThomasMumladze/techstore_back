package com.techstore.app.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.techstore.app.model.Cpu;
import com.techstore.app.services.CpuServices;

@WebMvcTest(CpuController.class)
public class CpuControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CpuServices cpuServices;

    @Test
    public void getAllCpu_returnsCpuList() throws Exception {
        Cpu cpu = new Cpu("Intel", "Core i7", "13th Gen", "i7-13700K", "LGA1700", 16, 24, "img", "body");
        when(cpuServices.GetAllCpu()).thenReturn(List.of(cpu));

        mockMvc.perform(get("/api/cpu"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].manufacturer").value("Intel"));
    }

    @Test
    public void getAllCpu_returnsNoContent() throws Exception {
        when(cpuServices.GetAllCpu()).thenReturn(List.of());

        mockMvc.perform(get("/api/cpu"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void getActiveCpu_returnsActiveCpus() throws Exception {
        Cpu cpu = new Cpu("Intel", "Core i7", "13th Gen", "i7-13700K", "LGA1700", 16, 24, "img", "body");
        cpu.setActive(true);
        when(cpuServices.GetActiveCpu()).thenReturn(Set.of(cpu));

        mockMvc.perform(get("/api/cpu/active-cpu"))
                .andExpect(status().isOk());
    }

    @Test
    public void getActiveCpu_returnsNoContent() throws Exception {
        when(cpuServices.GetActiveCpu()).thenReturn(Set.of());

        mockMvc.perform(get("/api/cpu/active-cpu"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void getInActiveCpu_returnsInactiveCpus() throws Exception {
        Cpu cpu = new Cpu("Intel", "Core i7", "13th Gen", "i7-13700K", "LGA1700", 16, 24, "img", "body");
        cpu.setActive(false);
        when(cpuServices.GetInActiveCpu()).thenReturn(Set.of(cpu));

        mockMvc.perform(get("/api/cpu/inactive-cpu"))
                .andExpect(status().isOk());
    }

    @Test
    public void deactivateCpu_returnsOk() throws Exception {
        Cpu cpu = new Cpu("Intel", "Core i7", "13th Gen", "i7-13700K", "LGA1700", 16, 24, "img", "body");
        cpu.setActive(false);
        when(cpuServices.DeactivateCpuStatus(1)).thenReturn(cpu);

        mockMvc.perform(put("/api/cpu/deactivate-cpu/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.active").value(false));
    }

    @Test
    public void activateCpu_returnsOk() throws Exception {
        Cpu cpu = new Cpu("Intel", "Core i7", "13th Gen", "i7-13700K", "LGA1700", 16, 24, "img", "body");
        cpu.setActive(true);
        when(cpuServices.ActivateCpuStatus(1)).thenReturn(cpu);

        mockMvc.perform(put("/api/cpu/activate-cpu/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.active").value(true));
    }

    @Test
    public void addNewCpu_returnsOk() throws Exception {
        Cpu cpu = new Cpu("Intel", "Core i7", "13th Gen", "i7-13700K", "LGA1700", 16, 24, "img", "body");
        when(cpuServices.AddNewCpu()).thenReturn(cpu);

        mockMvc.perform(post("/api/cpu/add-cpu"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.model").value("i7-13700K"));
    }
}