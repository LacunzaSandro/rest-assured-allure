import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import model.CreateUserRequest;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ReqResTests_8 {
    private static final Logger logger = LogManager.getLogger(ReqResTests_8.class);
    @Before
    public  void setup() {
        logger.info("Iniciando la configuracion");
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "/api";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
        logger.info("finalizando la configuración");
    }
    @Test
    public void registerUserTest() {
        //installed RoboPojoGenerated
        CreateUserRequest user = new CreateUserRequest();
        user.setEmail("eve.holt@reqres.in");
        user.setPassword("pistol");

        CreateUserResponse userResponse = given()
                .when()
                .body(user)
                .post("register")
                .then()
                //primero verificar
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json; charset=utf-8"))
                .extract()
                .body()
                .as(CreateUserResponse.class);
        System.out.println("******************* ASSERT *********************");
        assertThat(userResponse.getId(), equalTo(4));
        assertThat(userResponse.getToken(), equalTo("QpwL5tke4Pnpja7X4"));
    }

}
