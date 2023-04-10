package reqres;

import api.steps.ReqresSteps;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GetSingleUserTest {
    private final ReqresSteps reqresSteps = new ReqresSteps();

    @ParameterizedTest
    @ValueSource(ints = 2)
    public void getSingleUserSuccess(int id) {
        Response response = reqresSteps.getSingleUser(id, 200);
        reqresSteps.checkSingleUser(response, id);
    }

    @ParameterizedTest
    @ValueSource(ints = 23)
    public void getSingleUserFail(int id) {
        reqresSteps.getSingleUser(id, 404);
    }
}
