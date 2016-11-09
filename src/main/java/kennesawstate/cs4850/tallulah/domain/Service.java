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

    public Group findUserInGroupBy(int groupId, int userId){
        return infraService.findUserInGroupBy(groupId, userId);
    }

    public void createDevice(int userId){
        infraService.createDevice(userId);
    }
}
