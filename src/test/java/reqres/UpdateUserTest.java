package reqres;

import api.models.UpdateUserPayload;
import api.steps.ReqresSteps;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UpdateUserTest {
    private final ReqresSteps reqresSteps = new ReqresSteps();

    @ParameterizedTest
    @ValueSource(ints = 2)
    public void putUpdateUserSuccess(int id) {
        UpdateUserPayload updateUserPayload = new UpdateUserPayload("morpheus", "zion resident");
        Response response = reqresSteps.putUpdateUser(updateUserPayload, id);
        reqresSteps.checkUpdateUser(response, updateUserPayload);
    }
}
