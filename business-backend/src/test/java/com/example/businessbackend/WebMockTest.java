package com.example.businessbackend;

import com.example.businessbackend.controllers.BusinessController;
import com.example.businessbackend.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BusinessController.class)
public class WebMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BusinessService service;

//    @Test
//    public void shouldReturnMessageFromService() throws Exception {
//        when(service.getAllBusinesses()).thenReturn("Hello, Mock");
//        this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("Hello, Mock")));
//    }
}