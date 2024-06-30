package com.tecnopar.ifood.cadastro;

//import static io.restassured.RestAssured.given;

//import java.util.Optional;

//import org.approvaltests.Approvals;
import org.junit.Assert;
import org.junit.Test;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;
import com.tecnopar.ifood.cadastro.models.Restaurant;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
//import jakarta.ws.rs.core.Response.Status;

@DBRider
@DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE )
@QuarkusTest
@QuarkusTestResource(CadastroTestLifecycleManager.class)
public class RestaurantResourceTest {
    
    @Test    
    public void testRestaurantList() {
        String result = given()
        .when().get("/restaurantes")
        .then()
        .statusCode(200)
        .extract().asString();
//        Approvals.verifyJson(result);
    }
    private RequestSpecification given() {
        return RestAssured.given().contentType(ContentType.JSON);
    }
    // Ejemplo de uno test de POST
    @Test
    @DataSet("restaurants-scenario-1.yml")
    public void testRestaurantInsert(){
        Restaurant dto = new Restaurant();
        dto.name = "Tatinho";
        Long parameterValue = 2L;
        given()
            .with().pathParam("id", parameterValue)
            .body(dto)
            .when().post("/restaurantes/{id}")
            .then()
             .extract().asString();
//        Restaurant findById = Restaurant.findById(parameterValue);
        //Assert.assertEquals(dto.name,findById.name);
    }


    // Ejemplo de uno test de PUT
    /**
     * 
     */
    @Test
    @DataSet("restaurants-scenario-1.yml")
    public void testRestaurantUpdate(){
        Long parameterValue = 1L;
        Restaurant dto = new Restaurant();
        dto.name = "chimarrao churrascaria 4";
        dto.id = parameterValue;
        
        given()
            .with().pathParam("id", parameterValue)
            .body(dto)
            .when().put("/restaurantes/{id}")
            .then()
             .extract().asString();
             // verificar porque os codigos abaixo não funcionam, em especial o find
//        Restaurant restaurant = Restaurant.findById(parameterValue);
//        Assert.assertEquals(dto.name,restaurant.name);
        Assert.assertEquals(dto.id, parameterValue);
    }
}
