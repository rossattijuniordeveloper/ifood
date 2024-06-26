package com.tecnopar.ifood.cadastro;

import static io.restassured.RestAssured.given;

import org.approvaltests.Approvals;
import org.junit.Test;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@QuarkusTestResource(CadastroTestLifecycleManager.class)
public class RestaurantResourceTest {
    
    @Test
    public void testListRestaurant() {
        String result = given()
        .when().get("/restaurantes")
        .then()
        .statusCode(200)
        .extract().asString();
        Approvals.verifyJson(result);
    }
}
