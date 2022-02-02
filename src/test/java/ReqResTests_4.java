import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ReqResTests_4 {

    @Before
    public  void setup() {
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "/api";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }
    @Test
    public void deleteUserTest() {
                given()
                .log().all()
                .delete("users/2")
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }
    @Test
    public void patchUserTest() {
        String nameUpdated =
        given()
                .when()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .patch("users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath().getString("name");

        assertThat(nameUpdated, equalTo("morpheus"));
    }

    @Test
    public void putUserTest() {
        String nameUpdated =
                given()
                        .when()
                        .body("{\n" +
                                "    \"name\": \"morpheus\",\n" +
                                "    \"job\": \"zion resident\"\n" +
                                "}")
                        .put("users/2")
                        .then()
                        .statusCode(HttpStatus.SC_OK)
                        .extract()
                        .jsonPath().getString("job");

        assertThat(nameUpdated, equalTo("zion resident"));
    }


}
