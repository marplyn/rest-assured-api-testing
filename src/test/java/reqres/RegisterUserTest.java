package reqres;

import api.models.RegisterUserPayload;
import api.steps.ReqresSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RegisterUserTest {

    private final ReqresSteps reqresSteps = new ReqresSteps();

    @DisplayName("Позитивный тест регистрации пользователя")
    @Test
    void postRegisterUserSuccess() {
        RegisterUserPayload payloadForSuccessRegistration = new RegisterUserPayload();
        reqresSteps.postRegisterUser(payloadForSuccessRegistration)
                .responseStatusShouldBeEqualsTo(200)
                .userRegistrationShouldBeSuccess();
    }

    @DisplayName("Негативный тест регистрации пользователя без указания пароля")
    @Test
    void postRegisterUserFail() {
        RegisterUserPayload payloadWithoutPass = RegisterUserPayload.builder()
                .setPassword("")
                .build();
        reqresSteps.postRegisterUser(payloadWithoutPass)
                .responseStatusShouldBeEqualsTo(400);
    }
}
