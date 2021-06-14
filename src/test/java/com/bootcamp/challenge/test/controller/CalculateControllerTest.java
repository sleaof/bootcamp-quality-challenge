package com.bootcamp.challenge.test.controller;

import com.bootcamp.challenge.test.service.impl.CalculateServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CalculateController.class)
class CalculateControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    CalculateServiceImpl service;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void calculateHomeDoesNotAcceptNullFields() throws Exception {
        Object randomObj = new Object() {
            public final String propName = null;
        };
        String json = objectMapper.writeValueAsString(randomObj);

        MvcResult result = mvc.perform(post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .characterEncoding("UTF-8"))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

}