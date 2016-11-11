package kennesawstate.cs4850.tallulah.application.Response;

import lombok.Data;

@Data
public class UserResponse {
    int id;
    String name;
    String email;
    String loginDetail;
    String userType;
}
