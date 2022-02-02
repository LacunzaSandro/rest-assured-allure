import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;

public class ReqResTests_2 {
    @Test
    public void loginTestAndUseMatcher() {
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(200)
                .body("token", notNullValue());
    }
}
