package kennesawstate.cs4850.tallulah.application;


import kennesawstate.cs4850.tallulah.application.Request.LoginDetail;
import kennesawstate.cs4850.tallulah.application.Request.UserRequest;
import kennesawstate.cs4850.tallulah.application.Response.*;
import kennesawstate.cs4850.tallulah.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private static final String users = "/apiadmin/1/users";
    private static final String usersId = "/apiadmin/1/users/{userid}";
    private static final String groups = "/apiadmin/1/groups";
    private static final String groupsId = "/apiadmin/1/groups/{groupid}";
    private static final String groupUsers = "/apiadmin/1/groups/{groupid}/users";
    private static final String groupUsersId = "/apiadmin/1/groups/{groupid}/users/{userid}";
    private static final String devices = "/apiadmin/1/groups/{groupid}/devices";
    private static final String devicesId = "/apiadmin/1/groups/{groupid}/devices/{deviceid}";
    private static final String channels = "/apiadmin/1/groups/{groupid}/channels";
    private static final String channelsId = "/apiadmin/1/groups/{groupid}/channels/{chennelid}";
    private static final String messages = "/apiadmin/1/groups/{groupid}/messages";
    private static final String messagesId = "/apiadmin/1/groups/{groupid}/messages/{messageid}";


    @Autowired
    Repository repository;

    @RequestMapping(path = "/sample", method = RequestMethod.GET)
    public Sample sampleTest() {
        return repository.getSample();
    }


    @RequestMapping(path = users, method = RequestMethod.GET)
    public ResponseEntity<UserIdList> findAllUserId() {
        List<Integer> userIds = repository.findAllUserId();
        List<UserId> userIdList = new ArrayList<>();
        userIds.forEach(i -> userIdList.add(new UserId(i)));
        return new ResponseEntity<>(new UserIdList(userIdList), HttpStatus.OK);
    }

    @RequestMapping(path = users, method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody UserRequest userRequest) {
        User user = new User();
        user.setUserName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setUserType(UserType.valueOf(userRequest.getUsertype()));
        return new ResponseEntity<>(new IdStatus(repository.createUser(user), "create was successful."), HttpStatus.OK);
    }

    @RequestMapping(path = usersId, method = RequestMethod.GET)
    public ResponseEntity<UserResponse> findUserBy(@PathVariable("userid") int userId) {
        User user = repository.findUserBy(userId);
        UserResponse userResponse = new UserResponse();
        //some field may be null
        userResponse.setId(user.getUserId());
        userResponse.setName(user.getUserName());
        userResponse.setEmail(user.getEmail());
        userResponse.setLoginDetail(user.getLoginDetail());
        userResponse.setUserType(user.getUserType().toString());
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }

    @RequestMapping(path = usersId, method = RequestMethod.PUT)
    public ResponseEntity<IdStatus> updateLoginDetail(@PathVariable("userid") int userId, @RequestBody LoginDetail loginDetail){
        repository.updateLoginDetail(userId,loginDetail.getLoginDetail());
        return new ResponseEntity<>(new IdStatus(userId, "update was successful"), HttpStatus.OK);
    }

    @RequestMapping(path = usersId, method = RequestMethod.DELETE)
    public ResponseEntity<IdStatus> deleteUser(@PathVariable("userid") int userId) {
        repository.deleteUserBy(userId);
        return new ResponseEntity<>(new IdStatus(userId, "delete was successful."), HttpStatus.OK);
    }

    @RequestMapping(path = groups, method = RequestMethod.POST)
    public ResponseEntity<IdStatus> createGroup() {
        return new ResponseEntity<>(new IdStatus(repository.createGroupId(), "create was successful."), HttpStatus.CREATED);
    }

    @RequestMapping(path = groups, method = RequestMethod.GET)
    public ResponseEntity<GroupIdList> findGroups() {
        List<Integer> groupIdListInt = repository.findAllGroupId();
        List<GroupId> groups = new ArrayList<>();
        groupIdListInt.forEach(i -> groups.add(new GroupId(i)));
        return new ResponseEntity<>(new GroupIdList(groups), HttpStatus.OK);
    }

    @RequestMapping(path = groupsId, method = RequestMethod.DELETE)
    public ResponseEntity<IdStatus> deleteGroupBy(@PathVariable("groupid") int groupId) {
        repository.deleteGroupBy(groupId);
        return new ResponseEntity<>(new IdStatus(groupId, "delete was successful."), HttpStatus.OK);
    }

    @RequestMapping(path = groupsId, method = RequestMethod.GET)
    public ResponseEntity<DetailGroupIdList> findGroupBy(@PathVariable("groupid") int groupId) {
        Group group = repository.findGroupBy(groupId);
        List<UserId> userIdList = new ArrayList<>();
        group.getUsers().forEach(i -> userIdList.add(new UserId(i.getUserId())));
        List<DeviceId> deviceIdList = new ArrayList<>();
        group.getDevices().forEach(i -> deviceIdList.add(new DeviceId(i.getDeviceId())));
        List<ChannelId> channelIdList = new ArrayList<>();
        group.getChannels().forEach(i -> channelIdList.add(new ChannelId(i.getChannelId())));
        List<MessageId> messageIdList = new ArrayList<>();
        group.getMessages().forEach(i -> messageIdList.add(new MessageId(i.getMessageId())));

//        DetailGroupId detailGroupId = DetailGroupId.builder()
//                .groupid(group.getGroupId())
//                .users(userIdList)
//                .devices(deviceIdList)
//                .channels(channelIdList)
//                .messages(messageIdList)
//                .build();
        DetailGroupId detailGroupId = new DetailGroupId();
        detailGroupId.setGroupid(group.getGroupId());
        detailGroupId.setUsers(userIdList);
        detailGroupId.setDevices(deviceIdList);
        detailGroupId.setChannels(channelIdList);
        detailGroupId.setMessages(messageIdList);
        List<DetailGroupId> detailGroupIdList = new ArrayList<>();
        detailGroupIdList.add(detailGroupId);
        DetailGroupIdList result = new DetailGroupIdList(detailGroupIdList);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //Might not need this endpoint
    @RequestMapping(path = groupUsers, method = RequestMethod.GET)
    public ResponseEntity<GroupUserList> findUsersInGroup(@PathVariable("groupid") int groupId) {
        List<User> users = repository.findUserByGroupId(groupId);
        GroupUser groupUser = new GroupUser();
        groupUser.setGroupid(groupId);
        groupUser.setUsers(users);
        List<GroupUser> groups = new ArrayList<>();
        groups.add(groupUser);

        return new ResponseEntity<>(new GroupUserList(groups), HttpStatus.OK);

    }

    @RequestMapping(path = groupUsersId, method = RequestMethod.DELETE)
    public ResponseEntity<IdStatus> deleteUserByInGroup(@PathVariable("groupid") int groupId, @PathVariable("userid") int userId) {
        repository.removeUserFromGroup(groupId, userId);
        return new ResponseEntity<IdStatus>(new IdStatus(userId,"delete was successful"), HttpStatus.OK);
    }

    @RequestMapping(path = groupUsersId, method = RequestMethod.POST)
    public ResponseEntity<IdStatus> addUserToGroup(@PathVariable("groupid") int groupId, @PathVariable("userid") int userId) {
        repository.addUserToGroup(groupId, userId);
        return new ResponseEntity<>(new IdStatus(userId,"create was successful"), HttpStatus.OK);
    }

    @RequestMapping(path = groupUsersId, method = RequestMethod.GET)
    public ResponseEntity<GroupUserList> findUserInGroupBy(@PathVariable("groupid") int groupId, @PathVariable("userid") int userId) {
        Group group =  repository.findUserInGroupBy(groupId, userId);
        GroupUser groupUser = new GroupUser();
        groupUser.setGroupid(group.getGroupId());
        groupUser.setUsers(group.getUsers());
        List<GroupUser> groups = new ArrayList<>();
        groups.add(groupUser);
        return new ResponseEntity<GroupUserList>(new GroupUserList(groups), HttpStatus.OK);
    }

    @RequestMapping(path = devices, method = RequestMethod.POST)
    public void createDevice() {

    }

    @RequestMapping(path = devices, method = RequestMethod.GET)
    public void findDevices() {

    }

    @RequestMapping(path = devicesId, method = RequestMethod.DELETE)
    public void deleteDeviceBy() {

    }

    @RequestMapping(path = devicesId, method = RequestMethod.GET)
    public void findDeviceBy() {

    }

    @RequestMapping(path = channels, method = RequestMethod.POST)
    public void createChannel() {

    }

    @RequestMapping(path = channels, method = RequestMethod.GET)
    public void findChannels() {

    }

    @RequestMapping(path = channelsId, method = RequestMethod.DELETE)
    public void deleteChannel() {

    }

    @RequestMapping(path = channelsId, method = RequestMethod.PUT)
    public void updateChannel() {

    }

    @RequestMapping(path = channelsId, method = RequestMethod.GET)
    public void findChannelBy() {

    }

    @RequestMapping(path = messages, method = RequestMethod.POST)
    public void createMessage() {

    }

    @RequestMapping(path = messages, method = RequestMethod.GET)
    public void findMessages() {

    }

    @RequestMapping(path = messagesId, method = RequestMethod.DELETE)
    public void deleteMessageBy() {

    }

    @RequestMapping(path = messagesId, method = RequestMethod.PUT)
    public void updateMessageBy() {

    }

    @RequestMapping(path = messagesId, method = RequestMethod.GET)
    public void findMessageBy() {

    }
}
