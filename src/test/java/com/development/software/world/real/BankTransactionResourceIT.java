package com.development.software.world.real;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class BankTransactionResourceIT {

    @Test
    void shouldGetAllBankTransactions() {
        given()
                .queryParam("fileName", "test")
                .queryParam("fileExtension", "csv")
                .when()
                .get("/api/v1/bank")
                .then()
                .statusCode(200)
                .body("$.size()", is(2))
                .body("amount", hasItems(-100.0f, 1751.0f))
                .body("date", hasItems("2017-04-30", "2017-01-30"))
                .body("description", hasItems("test1", "test2"))
                .body("[0].amount", is(-100.0f));
    }
}