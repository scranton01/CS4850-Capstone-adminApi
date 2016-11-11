package kennesawstate.cs4850.tallulah.domain;


import kennesawstate.cs4850.tallulah.infrastructure.InfraService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service implements Repository {

    @Autowired
    private InfraService infraService;

    public Sample getSample() {
        return infraService.getSample();
    }

    public List<Integer> findAllUserId() {
        return infraService.findAllUserId();
    }

    public Integer createUser(User user) {
        return infraService.createUser(user);
    }

    public User findUserBy(int userId) {
        return infraService.findUserBy(userId);
    }

    public Integer deleteUserBy(int userId) {
        return infraService.deleteUserBy(userId);
    }

    public Integer createGroupId() {
        return infraService.createGroupId();
    }

    public List<Integer> findAllGroupId() {
        return infraService.findAllGroupId();
    }

    public Integer deleteGroupBy(int groupId) {
        return infraService.deleteGroupBy(groupId);
    }

    public Group findGroupBy(int groupId) {
        return infraService.findGroupBy(groupId);
    }

    public List<User> findUserByGroupId(int groupId) {
        return infraService.findUserByGroupId(groupId);
    }

    public void removeUserFromGroup(int groupId, int userId) {
        infraService.removeUserFromGroup(groupId, userId);
    }

    public void updateLoginDetail(int userId, String loginDetail) {
        infraService.updateLoginDetail(userId, loginDetail);
    }

    public void addUserToGroup(int groupId, int userId) {
        infraService.addUserToGroup(groupId, userId);
    }

    public Group findUserInGroupBy(int groupId, int userId) {
        return infraService.findUserInGroupBy(groupId, userId);
    }

    public int createDevice(int groupId, int userId) {
        return infraService.createDevice(groupId, userId);
    }


    public Group findDeviceInGroup(int groupId) {
        return infraService.findDeviceInGroup(groupId);
    }

    public void deleteDevice(int groupId, int deviceId) {
        infraService.deleteDevice(groupId, deviceId);
    }

    public Group findDeviceInGroupBy(int groupId, int deviceId) {
        return infraService.findDeviceInGroupBy(groupId, deviceId);
    }

    public int createChannel(int groupId, Channel channel) {
        return infraService.createChannel(groupId, channel);
    }

    public Group findChannelInGroup(int groupId) {
        return infraService.findChannelInGroup(groupId);
    }

    public void deleteChannel(int groupId, int channelId) {
        infraService.deleteChannel(groupId, channelId);
    }

    public void updateChannel(int channelId, Channel channel){
        infraService.updateChannel(channelId, channel);
    }

    public Group findChannelInGroupBy(int groupId, int channelId) {
        return infraService.findChannelInGroupBy(groupId, channelId);
    }
}
