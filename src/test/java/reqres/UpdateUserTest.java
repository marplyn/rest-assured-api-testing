package reqres;

import api.models.UpdateUserPayload;
import api.steps.ReqresSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UpdateUserTest {

    private final ReqresSteps reqresSteps = new ReqresSteps();

    @DisplayName("Позитивный тест обновления данных пользователя")
    @Test
    void putUpdateUserSuccess() {
        int id = 2;
        UpdateUserPayload updateUserPayload = new UpdateUserPayload();
        reqresSteps.putUpdateUser(updateUserPayload, id)
                .updateResponseShouldBeSuccess(updateUserPayload);
    }
}
