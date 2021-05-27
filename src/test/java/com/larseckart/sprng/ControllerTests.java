package com.larseckart.sprng;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class ControllerTests {

  @Autowired MockMvc mockMvc;

  @Test
  void name() throws Exception {
    this.mockMvc
            .perform(get("/"))
            .andExpect(status().isOk());
  }
}
