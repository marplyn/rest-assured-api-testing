package reqres;

import api.steps.ReqresSteps;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GetSingleUserTest {
    private final ReqresSteps reqresSteps = new ReqresSteps();

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
