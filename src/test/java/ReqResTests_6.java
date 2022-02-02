import com.sun.javafx.binding.StringFormatter;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;


import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ReqResTests_6 {

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
    public void getAllUsersTest() {
      String response = given()
              .when()
              .get("users?page=2")
              .then()
              .extract()
              .body()
              .asString();
      int page = from(response).get("page");
      int totalPages = from(response).get("total_pages");
      int idFirstUser = from(response).get("data[0].id");

      System.out.println(String.format("La pagina es la número %s", page));
      System.out.println(String.format("Total Pages %s", totalPages));
      System.out.println(String.format("ID first user %s", idFirstUser));

      //usuarios con id mayores a 10
        List<Map> userWithIdGreaterThan10 = from(response).get("data.findAll {user -> user.id > 10}");
        String email = userWithIdGreaterThan10.get(0).get("email").toString();
        List<Map> user = from(response).get("data.findAll { user -> user.id > 10 && user.last_name == 'Howell'}");
        int id = Integer.valueOf(user.get(0).get("id").toString());

        //installed RoboPojoGenerated

    }

}
