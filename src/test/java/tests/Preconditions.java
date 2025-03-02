package tests;

import entity.User;

public class Preconditions extends BaseTest {

    protected final User userWithEmptyUserName = User.newBuilder()
            .setUsername("")
            .setPassword(PASSWORD)
            .build();

    protected final User userSuccess = User.newBuilder()
            .setUsername(USERNAME)
            .setPassword(PASSWORD)
            .build();

    protected final User userWithEmptyPassword = User.newBuilder()
            .setUsername(USERNAME)
            .setPassword("")
            .build();

    protected final User userEmptyFields = User.newBuilder()
            .setUsername("")
            .setPassword("")
            .build();

    protected final User userIncorrectFields = User.newBuilder()
            .setUsername("refjebfle")
            .setPassword("efewfefw")
            .build();
}