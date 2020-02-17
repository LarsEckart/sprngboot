package ee.lars.sprng;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
class SprngApplicationTests
{

    @Test
    void contextLoads()
    {
    }

    @Test
    void exposes_health_endpoint_unsecured() {
        given()
            .port(8080)
            .header( "SM_USER","lars" )
        .when()
            .get("/hello")
        .then()
            .body(equalTo("hello"));
    }

}
