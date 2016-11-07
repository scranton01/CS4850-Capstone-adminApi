package kennesawstate.cs4850.tallulah.application.Response;

import kennesawstate.cs4850.tallulah.domain.User;
import lombok.Data;

import java.util.List;

@Data
public class GroupUser {
    int groupid;
    List<User> users;
}
