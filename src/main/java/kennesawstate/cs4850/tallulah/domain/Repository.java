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

    int createDevice(int groupId, int userId);


    Group findDeviceInGroup(int groupId);

    void deleteDevice(int groupId, int deviceId);

    Group findDeviceInGroupBy(int groupId, int deviceId);

    int createChannel(int groupId, Channel channel);

    Group findChannelInGroup(int groupId);

    void deleteChannel(int groupId, int channelId);

    void updateChannel(int channelId, Channel channel);

    Group findChannelInGroupBy(int groupId, int channelId);




}
