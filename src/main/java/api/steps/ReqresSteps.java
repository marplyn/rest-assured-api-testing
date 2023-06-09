package api.steps;

import api.models.RegisterUserPayload;
import api.models.UpdateUserPayload;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ReqresSteps {
    public static Response postRegisterUser(RegisterUserPayload registerUserPayload, int httpStatus) {
        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(registerUserPayload)
                .post("register")
                .then()
                .spec(SpecHelper.getResponseSpec(httpStatus))
                .extract()
                .response();
    }

    public static Response putUpdateUser(UpdateUserPayload updateUserPayload, int id) {
        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(updateUserPayload)
                .put(String.format("users/%d", id))
                .then()
                .spec(SpecHelper.getResponseSpec(200))
                .extract()
                .response();
    }

    public static void deleteUser(int id) {
        given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .delete(String.format("users/%d", id))
                .then()
                .spec(SpecHelper.getResponseSpec(204));
    }

    public static Response getSingleUser(int id, int httpStatus) {
        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .get(String.format("users/%d", id))
                .then()
                .spec(SpecHelper.getResponseSpec(httpStatus))
                .extract()
                .response();
    }

    public void checkUpdateUser(Response response, UpdateUserPayload updateUserPayload) {
        Assertions.assertEquals(updateUserPayload.getName(), response.jsonPath().get("name"));
        Assertions.assertEquals(updateUserPayload.getJob(), response.jsonPath().get("job"));
    }

    public void checkRegisterUser(Response response) {
        response.then().assertThat().body("id", notNullValue());
        response.then().assertThat().body("token", notNullValue());
    }

    public void checkSingleUser(Response response, int id) {
        response.then().assertThat().body("data.id", equalTo(id));
    }
}
