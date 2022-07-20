package data.builder;

import model.CreateUserRequest;

public class CreateUserRequestBuilder {

    private CreateUserRequest createUserRequest;

    private CreateUserRequestBuilder() {
        createUserRequest = new CreateUserRequest();
    }

    public static CreateUserRequestBuilder aUser() {
        return new CreateUserRequestBuilder();
    }
    public  CreateUserRequestBuilder password(String password) {
        this.createUserRequest.setPassword(password);
        return this;
    }
    public  CreateUserRequestBuilder email(String email) {
        this.createUserRequest.setEmail(email);
        return this;
    }
    public CreateUserRequest build() {
        return createUserRequest;
    }

}
