package kennesawstate.cs4850.tallulah.domain;

import java.util.List;

public interface Repository {
    Sample getSample();

    List<Integer> findAllUserId();

    Integer createUser(User user);

    User findUserBy(int userId);

    Integer deleteUserBy(int userId);

    Integer createGroupId();

    List<Integer> findAllGroupId();

    Integer deleteGroupBy(int groupId);

    Group findGroupBy(int groupid);


}
