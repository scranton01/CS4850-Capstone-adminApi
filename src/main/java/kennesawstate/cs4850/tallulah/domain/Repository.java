package kennesawstate.cs4850.tallulah.domain;

import java.util.List;

public interface Repository {
    Sample getSample();

    List<Integer> findAllUserId();

    Integer createUser(User user);

    User findUserBy(int userId);

    void deleteUserBy(int userId);

    Integer createGroupId();

    List<Integer> findAllGroupId();

    void deleteGroupBy(int groupId);

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

    int createMessage(int groupId, Message message);

    Group findMessageInGroup(int groupId);

    void deleteMessage(int groupId, int messageId);

    void updateMessage(int messageId, Message message);

    Group findMessageInGroupBy(int groupId, int messageId);
}
