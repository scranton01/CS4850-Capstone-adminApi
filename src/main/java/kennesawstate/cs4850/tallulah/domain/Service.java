package kennesawstate.cs4850.tallulah.domain;


import kennesawstate.cs4850.tallulah.application.NotFoundException;
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
        User user = infraService.findUserBy(userId);
        if (user == null) {
            throw new NotFoundException();
        }
        return user;
    }

    public void deleteUserBy(int userId) {
        if (infraService.deleteUserBy(userId) == 0) {
            throw new NotFoundException();
        }
    }

    public Integer createGroupId() {
        return infraService.createGroupId();
    }

    public List<Integer> findAllGroupId() {
        return infraService.findAllGroupId();
    }

    public void deleteGroupBy(int groupId) {
        if (infraService.deleteGroupBy(groupId) == 0) {
            throw new NotFoundException();
        }
    }

    public Group findGroupBy(int groupId) {
        Group group = infraService.findGroupBy(groupId);
        if (group == null) {
            throw new NotFoundException();
        }
        return group;
    }

    public List<User> findUserByGroupId(int groupId) {
        return infraService.findUserByGroupId(groupId);
    }

    public void removeUserFromGroup(int groupId, int userId) {
        if (infraService.removeUserFromGroup(groupId, userId) == 0) {
            throw new NotFoundException();
        }
    }

    public void updateLoginDetail(int userId, String loginDetail) {
        if (infraService.updateLoginDetail(userId, loginDetail) == 0) {
            throw new NotFoundException();
        }
    }

    public void addUserToGroup(int groupId, int userId) {
        if (infraService.addUserToGroup(groupId, userId) == 0) {
            throw new NotFoundException();
        }
    }

    public Group findUserInGroupBy(int groupId, int userId) {
        Group group = infraService.findUserInGroupBy(groupId, userId);
        if (group == null) {
            throw new NotFoundException();
        }
        return group;
    }

    public int createDevice(int groupId, int userId) {
        if (infraService.findUserInGroupBy(groupId, userId) == null) {
            throw new NotFoundException();
        }
        return infraService.createDevice(groupId, userId);
    }


    public Group findDeviceInGroup(int groupId) {
        Group group = infraService.findDeviceInGroup(groupId);
        if (group == null) {
            throw new NotFoundException();
        }
        return group;
    }

    public void deleteDevice(int groupId, int deviceId) {
        if (infraService.deleteDevice(groupId, deviceId) == 0) {
            throw new NotFoundException();
        }
    }

    public Group findDeviceInGroupBy(int groupId, int deviceId) {
        Group group = infraService.findDeviceInGroupBy(groupId, deviceId);
        if (group == null) {
            throw new NotFoundException();
        }
        return group;
    }

    public int createChannel(int groupId, Channel channel) {
        return infraService.createChannel(groupId, channel);
    }

    public Group findChannelInGroup(int groupId) {
        return infraService.findChannelInGroup(groupId);
    }

    public void deleteChannel(int groupId, int channelId) {
        if (infraService.deleteChannel(groupId, channelId) == 0) {
            throw new NotFoundException();
        }
    }

    public void updateChannel(int channelId, Channel channel) {
        if (infraService.updateChannel(channelId, channel) == 0) {
            throw new NotFoundException();
        }
    }

    public Group findChannelInGroupBy(int groupId, int channelId) {
        Group group = infraService.findChannelInGroupBy(groupId, channelId);
        if (group == null) {
            throw new NotFoundException();
        }
        return group;
    }

    public int createMessage(int groupId, Message message) {
        return infraService.createMessage(groupId, message);
    }

    public Group findMessageInGroup(int groupId) {
        return infraService.findMessageInGroup(groupId);
    }

    public void deleteMessage(int groupId, int messageId) {
        if (infraService.deleteMessage(groupId, messageId) == 0) {
            throw new NotFoundException();
        }
    }

    public void updateMessage(int messageId, Message message) {
        if (infraService.updateMessage(messageId, message) == 0) {
            throw new NotFoundException();
        }
    }

    public Group findMessageInGroupBy(int groupId, int messageId) {
        Group group = infraService.findMessageInGroupBy(groupId, messageId);
        if (group == null) {
            throw new NotFoundException();
        }
        return group;
    }


}
