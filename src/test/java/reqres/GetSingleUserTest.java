package reqres;

import api.steps.ReqresSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GetSingleUserTest {

    private final ReqresSteps reqresSteps = new ReqresSteps();

    @DisplayName("Позитивный тест получения данных пользователя")
    @Test()
    void getSingleUserSuccess() {
        int id = 2;
        reqresSteps.getSingleUserById(id)
                .responseStatusShouldBeEqualsTo(200);
    }

    @DisplayName("Негативный тест получения данных пользователя")
    @ParameterizedTest(name = "{displayName} [{index}] Параметры: id=[{0}]")
    @ValueSource(ints = {23, -1, 0})
    void getSingleUserFail(int id) {
        reqresSteps.getSingleUserById(id)
                .responseStatusShouldBeEqualsTo(404);
    }
}