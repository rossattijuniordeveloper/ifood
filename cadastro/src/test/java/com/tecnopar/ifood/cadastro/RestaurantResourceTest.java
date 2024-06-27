package com.tecnopar.ifood.cadastro;

import static io.restassured.RestAssured.given;

import org.approvaltests.Approvals;
import org.junit.Test;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;

@DBRider
@DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE )
@QuarkusTest
@QuarkusTestResource(CadastroTestLifecycleManager.class)
public class RestaurantResourceTest {
    
    @Test
    @DataSet("restaurants-scenario-1.yml")
    public void testRestaurantList() {
        String result = given()
        .when().get("/restaurantes")
        .then()
        .statusCode(200)
        .extract().asString();
//        Approvals.verifyJson(result);
    }
}
