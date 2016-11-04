package kennesawstate.cs4850.tallulah.application.Response;

import lombok.Value;

import java.util.List;

@Value
public class UserIdList {
    List<UserId> users;
}
