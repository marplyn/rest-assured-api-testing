package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateUserResponse {

    private String name;

    private String job;

    public static UpdateUserResponse createFrom(Response response) {
        return response.getBody().as(UpdateUserResponse.class);
    }
}
