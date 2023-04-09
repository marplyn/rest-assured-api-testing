package reqres;

import api.models.RegisterUserPayload;
import api.models.UpdateUserPayload;
import api.steps.ReqresSteps;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RegisterTest {
    private final ReqresSteps reqresSteps = new ReqresSteps();

    @Test
    public void postRegisterUserSuccess() {
        RegisterUserPayload registerUserPayload = new RegisterUserPayload("eve.holt@reqres.in", "pistol");
        reqresSteps.postRegisterUser(registerUserPayload, 200);
    }

    @Test
    public void postRegisterUserFail() {
        RegisterUserPayload registerUserPayload = new RegisterUserPayload("sydney@fife", "");
        reqresSteps.postRegisterUser(registerUserPayload, 400);
    }

    @ParameterizedTest
    @ValueSource(ints = 2)
    public void putUpdateUserSuccess(int id) {
        UpdateUserPayload updateUserPayload = new UpdateUserPayload("morpheus", "zion resident");
        Response response = reqresSteps.putUpdateUser(updateUserPayload, id);
        reqresSteps.checkUpdateUser(response, updateUserPayload);
    }

    @ParameterizedTest
    @ValueSource(ints = 2)
    public void deleteUserSuccess(int id) {
        reqresSteps.deleteUser(id);
    }

    @ParameterizedTest
    @ValueSource(ints = 2)
    public void getSingleUserSuccess(int id) {
        reqresSteps.getSingleUser(id, 200);
    }

    @ParameterizedTest
    @ValueSource(ints = 23)
    public void getSingleUserFail(int id) {
        reqresSteps.getSingleUser(id, 404);
    }
}
