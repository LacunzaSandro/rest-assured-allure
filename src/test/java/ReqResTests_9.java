import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReqResTests_9 extends  BaseTest {

    @Before
    public void info() {
        System.out.println("****************************************************");
    }
    @Test
    public void getSingleUserTest() {
        given()
                .get("users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id", equalTo(2));
    }

}
