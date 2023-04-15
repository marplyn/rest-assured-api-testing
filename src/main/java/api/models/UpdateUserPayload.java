package api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(setterPrefix = "set")
@NoArgsConstructor()
@AllArgsConstructor
@Getter
public class UpdateUserPayload {

    @Builder.Default
    private String name = "morpheus";

    @Builder.Default
    private String job = "zion resident";
}
