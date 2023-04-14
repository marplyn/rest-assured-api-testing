package reqres;

import api.steps.ReqresSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeleteUserTest {

    private final ReqresSteps reqresSteps = new ReqresSteps();

    @DisplayName("Позитивный тест удаления пользователя")
    @Test
    void deleteUserSuccess() {
        int id = 2;
        reqresSteps.deleteUserById(id)
                .responseStatusShouldBeEqualsTo(204);
    }
}
