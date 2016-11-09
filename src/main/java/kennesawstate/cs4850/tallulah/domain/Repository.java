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

    List<User> findUserByGroupId(int groupId);

    void removeUserFromGroup(int groupId, int userId);

    void updateLoginDetail(int userId, String loginDetail);

    void addUserToGroup(int groupId, int userId);

    Group findUserInGroupBy(int groupId, int userId);

    void createDevice(int userId);
}
