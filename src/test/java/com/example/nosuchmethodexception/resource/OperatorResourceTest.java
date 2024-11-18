package com.example.nosuchmethodexception.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;

import static io.restassured.RestAssured.given;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
@TestHTTPEndpoint(OperatorResource.class)
public class OperatorResourceTest {

  @Test
  void executePostOperator() {
    given()
        .when()
        .contentType(ContentType.JSON)
        .body(new Operator("operator"))
        .post()
        .then()
        .statusCode(200)
        .body(is("Hello operator"));
  }

  @Test
  void executeGetOperator() throws JsonProcessingException {
    final Operator operator = new Operator("Can you give me number nine?");
    given()
        .when()
        .contentType(ContentType.JSON)
        .get()
        .then()
        .statusCode(200)
        .body(is(new ObjectMapper().writeValueAsString(operator)));
  }
}
