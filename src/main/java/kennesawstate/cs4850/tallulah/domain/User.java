package kennesawstate.cs4850.tallulah.domain;

import lombok.Data;

@Data
public class User {
    int userId;
    String email;
    String loginDetail;
    UserType userType;
}
