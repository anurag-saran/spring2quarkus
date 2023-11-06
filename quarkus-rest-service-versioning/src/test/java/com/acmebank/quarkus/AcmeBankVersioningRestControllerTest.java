package com.acmebank.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class AcmeBankVersioningRestControllerTest {

    @Test
    public void testGreetingV1Endpoint() {
        given()
                .when().get("acmebank/v1/greeting")
                .then()
                .statusCode(200);
    }

    @Test
    public void testProducesV1Endpoint() {
        given()
                .accept("application/vnd.company.app-v1+json")
                .when().get("acmebank/greeting/produces")
                .then()
                .statusCode(200);
    }

    @Test
    public void testProducesV2Endpoint() {
        given()
                .accept("application/vnd.company.app-v2+json")
                .when().get("acmebank/greeting/produces")
                .then()
                .statusCode(200);
    }

}
