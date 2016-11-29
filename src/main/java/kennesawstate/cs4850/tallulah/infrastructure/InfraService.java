package kennesawstate.cs4850.tallulah.infrastructure;

import kennesawstate.cs4850.tallulah.domain.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;


public class InfraService {
    @Autowired
    private Mapper mapper;

    public Sample getSample() {
        return mapper.getSample();
    }

    public List<Integer> findAllUserId() {
        return mapper.findAllUserId().stream()
                .filter(i -> i != 0)
                .collect(Collectors.toList());
    }

    public int createUser(User user) {
        mapper.createUser(user.getUserName(), user.getEmail(), user.getUserType().toString());
        return mapper.findCurrentUserId();
    }

    public User findUserBy(int userId) {
        return mapper.findUserBy(userId);
    }

    public int deleteUserBy(int userId) {
        mapper.removeUserFromDevice(userId);
        mapper.deleteUserFromGroup(userId);
        return mapper.deleteUserBy(userId);
    }

    public int createGroupId() {
        mapper.createGroupId();
        return mapper.findCurrentGroupId();
    }

    public List<Integer> findAllGroupId() {
        return mapper.findAllGroupId();
    }

    //return number row effected
    public int deleteGroupBy(int groupId) {
        return mapper.deleteGroupBy(groupId);
    }

    public Group findGroupBy(int groupId) {
        Group group = mapper.findGroupBy(groupId);
        //getting rid of place holder
        group.setUsers(group.getUsers()
                .stream()
                .filter(i -> i.getUserId() != 0)
                .collect(Collectors.toList()));
        group.setDevices(group.getDevices()
                .stream()
                .filter(i -> i.getDeviceId() != 0)
                .collect(Collectors.toList()));
        group.setChannels(group.getChannels()
                .stream()
                .filter(i -> i.getChannelId() != 0)
                .collect(Collectors.toList()));
        group.setMessages(group.getMessages()
                .stream()
                .filter(i -> i.getMessageId() != 0)
                .collect(Collectors.toList()));
        return group;
    }

    public List<User> findUserByGroupId(int groupId) {
        List<User> users = mapper.findUserByGroupId(groupId)
                .stream()
                .filter(i -> i.getUserId() != 0)
                .collect(Collectors.toList());
        return users;
    }

    public int removeUserFromGroup(int groupId, int userId) {
        return mapper.removeUserFromGroup(groupId, userId);
    }

    public int updateLoginDetail(int userId, String loginDetail) {
        return mapper.updateLoginDetail(userId, loginDetail);
    }

    public int addUserToGroup(int groupId, int userId) {
        return mapper.addUserToGroup(groupId, userId);
    }

    public Group findUserInGroupBy(int groupId, int userId) {
        Group group = mapper.findUserInGroupBy(groupId, userId);
        return group;
    }

    //return created id
    public int createDevice(int groupId, int userId) {
        mapper.createDevice(userId);
        mapper.addDeviceToGroup(groupId);
        return mapper.findLatestDeviceId();
    }


    public Group findDeviceInGroup(int groupId) {
        Group group = mapper.findDeviceInGroup(groupId);
        group.setDevices(group.getDevices()
                .stream()
                .filter(i -> i.getDeviceId() != 0)
                .collect(Collectors.toList()));
        return group;
    }

    public int deleteDevice(int groupId, int deviceId) {
        mapper.deleteDeviceInGroup(groupId, deviceId);
        return mapper.deleteDevice(deviceId);
    }

    public Group findDeviceInGroupBy(int groupId, int deviceId) {
        return mapper.findDeviceInGroupBy(groupId, deviceId);
    }

    public int createChannel(int groupId, Channel channel) {
        mapper.createChannel(channel);
        mapper.addChannelToGroup(groupId);
        return mapper.findLatestChannelId();
    }

    public Group findChannelInGroup(int groupId) {
        Group group = mapper.findChannelInGroup(groupId);
        group.setChannels(group.getChannels()
                .stream()
                .filter(i -> i.getChannelId() != 0)
                .collect(Collectors.toList()));
        return group;
    }

    public int deleteChannel(int groupId, int channelId) {
        mapper.deleteChannelInGroup(groupId, channelId);
        return mapper.deleteChannel(channelId);
    }

    public int updateChannel(int channelId, Channel channel) {
        return mapper.updateChannel(channelId, channel);
    }

    public Group findChannelInGroupBy(int groupId, int deviceId) {
        return mapper.findChannelInGroupBy(groupId, deviceId);
    }

    public int createMessage(int groupId, int deviceId, Message message) {
        mapper.createMessage(message);
        mapper.addMessageToGroup(groupId, deviceId);
        return mapper.findLatestMessageId();
    }

    public Group findMessageInGroup(int groupId, int deviceId) {
        Group group = mapper.findMessageInGroup(groupId, deviceId);
        group.setMessages(group.getMessages()
                .stream()
                .filter(i -> i.getMessageId() != 0)
                .collect(Collectors.toList()));
        return group;
    }

    public int deleteMessage(int groupId, int messageId) {
        mapper.deleteMessageInGroup(groupId, messageId);
        return mapper.deleteMessage(messageId);
    }

    public int updateMessage(int messageId, Message message) {
        return mapper.updateMessage(messageId, message);
    }

    public Group findMessageInGroupBy(int groupId, int deviceId, int messageId) {
        return mapper.findMessageInGroupBy(groupId, deviceId, messageId);
    }
}
