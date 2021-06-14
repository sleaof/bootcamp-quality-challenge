package com.digitalhouse.demo.integration;

import com.digitalhouse.entities.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerIntegrationTests {

    static Property property;
    static List<Room> rooms = new ArrayList<>();

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    public static void setUp() {
        rooms.add(new Room("Sala", 20.0, 23.0));
        rooms.add(new Room("Quarto", 15.0, 12.0));
        rooms.add(new Room("Banheiro", 8.0, 12.0));
        rooms.add(new Room("Cozinha", 25.0, 10.0));
    }

    @Test
    public void givenGreetURIWithPost_whenMockMVC_thenVerifyResponseIsOk() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .post("/calculate")
                .content(new ObjectMapper().writeValueAsString((new Property("Casa", "Centro", rooms))))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.squareMeters").value("986.0"))
                .andExpect(jsonPath("$.price").value("147801.4"))
                .andExpect(jsonPath("$.biggest.room_name").value("Sala"))
                .andExpect(jsonPath("$.biggest.room_width").value("20.0"))
                .andExpect(jsonPath("$.biggest.room_length").value("23.0"));
    }

    @Test
    public void givenGreetURIWithPost_whenMockMVC_thenVerifyResponseIsBadRequest() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .post("/calculate")
                .content(new ObjectMapper().writeValueAsString((new Property("casa", "Centro", rooms))))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }


}
