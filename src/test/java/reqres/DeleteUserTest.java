package reqres;

import api.steps.ReqresSteps;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DeleteUserTest {
    private final ReqresSteps reqresSteps = new ReqresSteps();

    @ParameterizedTest
    @ValueSource(ints = 2)
    public void deleteUserSuccess(int id) {
        reqresSteps.deleteUser(id);
    }
}
