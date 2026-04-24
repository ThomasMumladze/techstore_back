package com.techstore.app;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.techstore.app.controller.CpuController;
import com.techstore.app.model.Cpu;
import com.techstore.app.services.CpuServices;

@WebMvcTest(CpuController.class)
class TechstoreApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private CpuServices _cpuServices;

	@Test
	public void getAllCpu_returnsCpuList() throws Exception {
		Cpu cpu = new Cpu("Intel", "Core i7", "13th Gen", "i7-13700K", "LGA1700", 16, 24, "img", "body");
		when(_cpuServices.GetAllCpu()).thenReturn(List.of(cpu));

		mockMvc.perform(get("/api/cpu"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].manufacturer").value("Intel"));
	}

	@Test
	public void getAllCpu_returnsNoContent() throws Exception {
		when(_cpuServices.GetAllCpu()).thenReturn(List.of());

		mockMvc.perform(get("/api/cpu"))
				.andExpect(status().isNoContent());
	}

}
