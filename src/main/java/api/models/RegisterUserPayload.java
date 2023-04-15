package api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(setterPrefix = "set")
@NoArgsConstructor()
@AllArgsConstructor
@Getter
public class RegisterUserPayload {

    @Builder.Default
    private String email = "eve.holt@reqres.in";

    @Builder.Default
    private String password = "pistol";
}
