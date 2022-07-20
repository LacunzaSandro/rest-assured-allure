package data.builder;

import data.factory.CreateUserDataFactory;
import model.CreateUserRequest;

public class CreateUserDataBuilder {
    private CreateUserRequest createUserRequest;

    private CreateUserDataBuilder() {
        createDefaultUser();
    }
    public static CreateUserDataBuilder anUser() {
        return new CreateUserDataBuilder();
    }
    private void createDefaultUser() {
        createUserRequest = new CreateUserRequest();
        this.createUserRequest = CreateUserDataFactory.validUser();
    }
    public CreateUserDataBuilder password(String password) {
        this.createUserRequest.setPassword(password);
        return this;
    }
    public CreateUserDataBuilder email(String email) {
        this.createUserRequest.setEmail(email);
        return this;
    }
    public CreateUserRequest build() {
        return this.createUserRequest;
    }

}
