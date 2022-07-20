import model.CreateUserRequest;
import data.builder.CreateUserRequestBuilder;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ReqResTests_10 extends  BaseTest {

    @Before
    public void info() {
        System.out.println("****************************************************");
    }
    @Test
    public void registerUserWithPatterBuilder() {
        //installed RoboPojoGenerated
        /**
         CreateUserRequest user = new CreateUserRequest();
         user.setEmail("eve.holt@reqres.in");
         user.setPassword("pistol");
         */
        CreateUserRequest user = CreateUserRequestBuilder
                .aUser()
                .email("eve.holt@reqres.in")
                .password("pistol")
                .build();

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
