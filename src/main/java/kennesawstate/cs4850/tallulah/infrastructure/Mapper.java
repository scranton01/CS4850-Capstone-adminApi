package kennesawstate.cs4850.tallulah.infrastructure;

import kennesawstate.cs4850.tallulah.domain.Channel;
import kennesawstate.cs4850.tallulah.domain.Group;
import kennesawstate.cs4850.tallulah.domain.Sample;
import kennesawstate.cs4850.tallulah.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {
    Sample getSample();

    List<Integer> findAllUserId();

    void createUser(@Param("name") String name, @Param("email") String email, @Param("userType") String userType);

    void createGroupId();

    int findCurrentUserId();

    User findUserBy(int userId);

    int deleteUserBy(int userId);

    int findCurrentGroupId();

    List<Integer> findAllGroupId();

    int deleteGroupBy(int groupId);

    Group findGroupBy(int groupId);

    List<User> findUserByGroupId(int groupId);

    int removeUserFromGroup(@Param("groupId") int groupId, @Param("userId") int userId);

    int updateLoginDetail(@Param("userId") int userId, @Param("loginDetail") String loginDetail);

    int addUserToGroup(@Param("groupId") int groupId, @Param("userId") int userId);

    Group findUserInGroupBy(@Param("groupId") int groupId, @Param("userId") int userId);

    int createDevice(int userId);

    int addDeviceToGroup(@Param("groupId") int groupId);

    int findLatestDeviceId();

    Group findDeviceInGroup(int groupId);

    int deleteDevice(int deviceId);

    int deleteDeviceInGroup(@Param("groupId") int groupId, @Param("deviceId") int deviceId);

    Group findDeviceInGroupBy(@Param("groupId") int groupId, @Param("deviceId") int deviceId);

    int createChannel(Channel channel);

    int addChannelToGroup(@Param("groupId") int groupId);

    int findLatestChannelId();

    Group findChannelInGroup(int groupId);

    int deleteChannel(int channelId);

    int deleteChannelInGroup(@Param("groupId") int groupId, @Param("channelId") int channelId);

    int updateChannel(@Param("channelId") int channelId, @Param("channel") Channel channel);

    Group findChannelInGroupBy(@Param("groupId") int groupId, @Param("channelId") int channelId);

}
