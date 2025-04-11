import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;


/**
 * @author prabhakar, @Date 10-04-2025
 */

public class PatientIntegrationTest {

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "http://localhost:4004";
    }


    @Test
    public void shouldReturnPatientsWithValidToken(){
        String loginPayLoad = """
                {
                "email": "testuser@test.com",
                "password": "password123"
                }
                """;

        Response response = given()
                .contentType("application/json")
                .body(loginPayLoad)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(200)
                .body("token", notNullValue())
                .extract()
                .response();

        String token = response.jsonPath().getString("token");

        response = given()
                .header("Authorization", "Bearer "+token)
                .when()
                .get("/api/patients/getPatients")
                .then()
                .statusCode(200)
                .body("patients",notNullValue())
                .extract().response();

        System.out.println(Optional.ofNullable(response.jsonPath().get()));
    }
}
