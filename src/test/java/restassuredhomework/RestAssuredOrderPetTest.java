package restassuredhomework;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;


import java.io.File;


public class RestAssuredOrderPetTest {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    @Test
    public void orderPet(){
        String petId = RestAssured.given()
                .baseUri(BASE_URL)
                .header(new Header("Content-Type","application/json"))
                .body(new File("src/test/resources/testdata.petstore/barsik.json"))
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getString("id");
        System.out.println(petId);

       String petName = RestAssured.given()
                .baseUri(BASE_URL)
                .header(new Header("Content-Type","application/json"))
                .when()
                .get("/pet/" + petId)
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getString("name");

       assertThat(petName).isEqualTo("Barsik");
    }
}
