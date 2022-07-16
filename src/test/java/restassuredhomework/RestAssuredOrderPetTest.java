package restassuredhomework;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.PetDto;
import homeworkdto.OrderPetDto;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;



public class RestAssuredOrderPetTest {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private RequestSpecification requestSpecification;


    @BeforeClass
    public void setUp() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addHeader("Content-Type", "application/json")
                .build();
    }

    @Test
    @SneakyThrows
    public void createPet() {
        PetDto requestPet = PetDto
                .builder()
                .status("available")
                .name("Barsik")
                .build();

        //Request create pet
        String petId = RestAssured
                .given()
                .spec(requestSpecification)
                .body(new ObjectMapper().writeValueAsString(requestPet)) //from java to json
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getString("id");

        System.out.println(petId);

        //Request get pet
        JsonPath jsonResponsePet = RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get("/pet/" + petId)
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        //from json to java object
        PetDto responsePet = new ObjectMapper().readValue(jsonResponsePet.prettify(), PetDto.class);

        assertThat(requestPet).isEqualTo(responsePet);

    }

    @Test
    @SneakyThrows
    public void orderPet() {
        OrderPetDto orderPetDtoRequest = OrderPetDto
                .builder()
                .petId(37495923)
                .quantity(4)
                .status("placed")
                .complete(false)
                .build();


        String orderId = RestAssured
                .given()
                .spec(requestSpecification)
                .body(new ObjectMapper().writeValueAsString(orderPetDtoRequest))
                .when()
                .post("/store/order")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getString("id");
        System.out.println(orderId);

        //request get purchase order by id
        JsonPath getPetOrderByIdResponse = RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get("/store/order/" + orderId)
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        OrderPetDto responsePetOrder = new ObjectMapper().readValue(getPetOrderByIdResponse.prettify(), OrderPetDto.class);

        assertThat(orderPetDtoRequest).isEqualTo(responsePetOrder);


    }
}
