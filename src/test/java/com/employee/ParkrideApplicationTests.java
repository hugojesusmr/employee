package com.employee;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ParkrideApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getsAllRides() throws Exception {
        mockMvc
        .perform(MockMvcRequestBuilders
        .get("/api/employee")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn();
    }

    @Test
    public void getsSingleRide() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void returnsNotFoundForInvalidSingleRide() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    public void addsNewRide() throws Exception {
        String newEmployee = "{\"firstName\":\"Hugo\",\"lastName\":\"Melo.\",\"email\":\"hugo@mail.com\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newEmployee)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
    }
}
