package reqres;

import api.models.RegisterUserPayload;
import api.models.UpdateUserPayload;
import api.steps.ReqresSteps;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RegisterUserTest {
    private final ReqresSteps reqresSteps = new ReqresSteps();

    @Test
    public void postRegisterUserSuccess() {
        RegisterUserPayload registerUserPayload = new RegisterUserPayload("eve.holt@reqres.in", "pistol");
        Response response = reqresSteps.postRegisterUser(registerUserPayload, 200);
        reqresSteps.checkRegisterUser(response);
    }

    @Test
    public void postRegisterUserFail() {
        RegisterUserPayload registerUserPayload = new RegisterUserPayload("sydney@fife", "");
        reqresSteps.postRegisterUser(registerUserPayload, 400);
    }
}
