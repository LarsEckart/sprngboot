package com.larseckart.spring;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringApplicationTests {

  @Autowired
  private Environment env;

  @Test
  void contextLoads() {
  }

  @Test
  void exposes_health_endpoint_due_to_micronaut_management_dependency() {
    int port = Integer.parseInt(env.getProperty("local.server.port"));

    given()
        .port(port)
    .when()
        .get("/actuator/health")
    .then()
        .statusCode(200);
  }
}
