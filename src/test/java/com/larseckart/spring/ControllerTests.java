package com.larseckart.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@WebMvcTest
public class ControllerTests {

  @Autowired MockMvc mockMvc;

  @Test
  void home() throws Exception {
    MvcResult result =
        this.mockMvc
            .perform(get("/"))
            //            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();

    String content = result.getResponse().getContentAsString();
    assertThat(content).isEqualTo("Hello World! Lars");
  }
}
