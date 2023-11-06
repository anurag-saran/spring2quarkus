package com.acmebank.quarkus;

import com.acmebank.quarkus.exceptions.BankAccountNotFoundException;
import com.acmebank.quarkus.model.AcmeBank;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AcmeBankRestControllerTest {

    private AcmeBank createModel(boolean isUpdate){
        AcmeBank acmeBank = new AcmeBank();
        if(isUpdate){
            acmeBank.setId(1l);
        }
        acmeBank.setName("Don joe");
        acmeBank.setAccountNo("12345");
        return acmeBank;
    }

    @Test
    @Order(1)
    public void testCreateEndpoint() {
        given()
                .contentType(ContentType.JSON)
                .body(createModel(false))
                .when().post("/acmebank/create")
                .then()
                .statusCode(200)
                .body(is("Account created successfully"));
    }

    @Test
    @Order(2)
    public void testUpdateEndpoint() {
        given()
                .contentType(ContentType.JSON)
                .body(createModel(true))
                .when().put("/acmebank/update")
                .then()
                .statusCode(200)
                .body(is("Account Updated successfully"));
    }

    @Test
    @Order(3)
    public void testGetAllAccountEndpoint() {
        given()
          .when().get("/acmebank/get")
          .then()
             .statusCode(200);
    }

    @Test
    @Order(4)
    public void testGetParticularAccountEndpoint() {
        try {
            given()
                    .pathParam("id", 1)
                    .when().get("/acmebank/get/{id}");
        }catch (BankAccountNotFoundException e){

        }
    }

    @Test
    @Order(5)
    public void testDeleteEndpoint() {
        given()
                .pathParam("id", 1)
                .when().delete("/acmebank/delete/{id}")
                .then()
                .statusCode(200)
                .body(is("Account Deleted successfully"));
    }

}