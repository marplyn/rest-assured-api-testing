package api.steps;

import api.models.RegisterUserPayload;
import api.models.UpdateUserPayload;
import api.models.UpdateUserResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class ReqresSteps {

    private Response response;

    public ReqresSteps postRegisterUser(RegisterUserPayload registerUserPayload) {
        response = given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(registerUserPayload)
                .post("register")
                .then()
                .extract()
                .response();

        return this;
    }

    public ReqresSteps putUpdateUser(UpdateUserPayload updateUserPayload, int id) {
        response = given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(updateUserPayload)
                .put(String.format("users/%d", id))
                .then()
                .extract().response();

        return this;
    }

    public ReqresSteps deleteUserById(int id) {
        response = given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .delete(String.format("users/%d", id));

        return this;
    }

    public ReqresSteps getSingleUserById(int id) {
        response = given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .get(String.format("users/%d", id))
                .then()
                .and().extract().response();

        return this;
    }

    public ReqresSteps responseStatusShouldBeEqualsTo(int httpStatus) {
        Assertions.assertEquals(httpStatus, response.getStatusCode());

        return this;
    }

    public void updateResponseShouldBeSuccess(UpdateUserPayload updateUserPayload) {
        UpdateUserResponse user = UpdateUserResponse.createFrom(response);
        Assertions.assertEquals(updateUserPayload.getName(), user.getName());
        Assertions.assertEquals(updateUserPayload.getJob(), user.getJob());
    }

    public void userRegistrationShouldBeSuccess() {
        response.then().assertThat().body("id", notNullValue());
        response.then().assertThat().body("token", notNullValue());
    }
}
