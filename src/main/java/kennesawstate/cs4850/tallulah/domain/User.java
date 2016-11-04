package kennesawstate.cs4850.tallulah.domain;

import lombok.Data;

@Data
public class User {
    int userId;
    String name;
    String email;
    String loginDetail;
    UserType userType;
}
