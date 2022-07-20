package data.factory;

import com.github.javafaker.Faker;
import model.CreateUserRequest;
import org.apache.commons.lang3.StringUtils;

import static data.builder.CreateUserRequestBuilder.aUser;

public class CreateUserDataFactory {
    private static final Faker faker = new Faker();
    private static final String DEFAULT_USERNAME = "eve.holt@reqres.in";
    private static final String DEFAULT_PASSWORD = "pistol";

    public static CreateUserRequest missinAllInformation() {
        return aUser()
                .password(StringUtils.EMPTY)
                .email(StringUtils.EMPTY)
                .build();
    }
    public static CreateUserRequest nullInformation() {
        return aUser()
                .password(null)
                .email(null)
                .build();
    }
    public static CreateUserRequest invalidUser() {
        return aUser()
                .password(faker.internet().password())
                .email(faker.internet().emailAddress())
                .build();
    }
    public static CreateUserRequest validUser() {
        return aUser()
                .password(DEFAULT_PASSWORD)
                .email(DEFAULT_USERNAME)
                .build();
    }
}
