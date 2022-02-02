import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class ReqResTests_1 {
    @Test
    public void loginTest() {
        String response =
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
                .post("https://reqres.in/api/login")
                .then()
                .log().all()
                .extract()
                .asString();
        System.out.println(response);
    }
}
