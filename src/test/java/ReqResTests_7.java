import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;


import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;

public class ReqResTests_7 {

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
    public void createUserTest() {
        //installed RoboPojoGenerated
        String response = given()
                .when()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .post("users")
                .then().extract().body().asString();
        User user = from(response).getObject("", User.class);
        System.out.println("****************************************");
        System.out.println(user);
    }

}
