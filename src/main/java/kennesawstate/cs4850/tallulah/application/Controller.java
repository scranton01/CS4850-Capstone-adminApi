package kennesawstate.cs4850.tallulah.application;


import kennesawstate.cs4850.tallulah.application.Request.*;
import kennesawstate.cs4850.tallulah.application.Response.*;
import kennesawstate.cs4850.tallulah.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
    private static final String messages = "/apiadmin/1/groups/{groupid}/devices/{deviceid}/messages";
    private static final String messagesId = "/apiadmin/1/groups/{groupid}/devices/{deviceid}/messages/{messageid}";
    private static final String channels = "/apiadmin/1/groups/{groupid}/channels";
    private static final String channelsId = "/apiadmin/1/groups/{groupid}/channels/{channelid}";


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
        user.setUserType(UserType.valueOf(userRequest.getUserType()));
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
    public ResponseEntity<IdStatus> updateLoginDetail(@PathVariable("userid") int userId, @RequestBody LoginDetail loginDetail) {
        repository.updateLoginDetail(userId, loginDetail.getLoginDetail());
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

        DetailGroupId detailGroupId = new DetailGroupId();
        detailGroupId.setGroupId(group.getGroupId());
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
        groupUser.setGroupId(groupId);
        groupUser.setUsers(users);
        List<GroupUser> groups = new ArrayList<>();
        groups.add(groupUser);

        return new ResponseEntity<>(new GroupUserList(groups), HttpStatus.OK);

    }

    @RequestMapping(path = groupUsersId, method = RequestMethod.DELETE)
    public ResponseEntity<IdStatus> deleteUserByInGroup(@PathVariable("groupid") int groupId, @PathVariable("userid") int userId) {
        repository.removeUserFromGroup(groupId, userId);
        return new ResponseEntity<>(new IdStatus(userId, "delete was successful"), HttpStatus.OK);
    }

    @RequestMapping(path = groupUsersId, method = RequestMethod.POST)
    public ResponseEntity<IdStatus> addUserToGroup(@PathVariable("groupid") int groupId, @PathVariable("userid") int userId) {
        repository.addUserToGroup(groupId, userId);
        return new ResponseEntity<>(new IdStatus(userId, "create was successful"), HttpStatus.OK);
    }

    @RequestMapping(path = groupUsersId, method = RequestMethod.GET)
    public ResponseEntity<GroupUserList> findUserInGroupBy(@PathVariable("groupid") int groupId, @PathVariable("userid") int userId) {
        Group group = repository.findUserInGroupBy(groupId, userId);
        GroupUser groupUser = new GroupUser();
        groupUser.setGroupId(group.getGroupId());
        groupUser.setUsers(group.getUsers());
        List<GroupUser> groups = new ArrayList<>();
        groups.add(groupUser);
        return new ResponseEntity<>(new GroupUserList(groups), HttpStatus.OK);
    }

    @RequestMapping(path = devices, method = RequestMethod.POST)
    public ResponseEntity<IdStatus> createDevice(@PathVariable("groupid") int groupId, @RequestBody UserIdRequest userIdRequest) {
        int deviceId = repository.createDevice(groupId, userIdRequest.getUserId());
        return new ResponseEntity<>(new IdStatus(deviceId, "create was successful"), HttpStatus.OK);
    }

    @RequestMapping(path = devices, method = RequestMethod.GET)
    public ResponseEntity<GroupDeviceList> findDevices(@PathVariable("groupid") int groupId) {
        Group group = repository.findDeviceInGroup(groupId);
        GroupDevice groupDevice = new GroupDevice();
        groupDevice.setGroupId(group.getGroupId());
        groupDevice.setDevices(group.getDevices());
        List<GroupDevice> groups = new ArrayList<>();
        groups.add(groupDevice);
        return new ResponseEntity<>(new GroupDeviceList(groups), HttpStatus.OK);
    }

    @RequestMapping(path = devicesId, method = RequestMethod.DELETE)
    public ResponseEntity<IdStatus> deleteDeviceBy(@PathVariable("groupid") int groupId, @PathVariable("deviceid") int deviceId) {
        repository.deleteDevice(groupId, deviceId);
        return new ResponseEntity<>(new IdStatus(deviceId, "delete was successful"), HttpStatus.OK);
    }

    @RequestMapping(path = devicesId, method = RequestMethod.GET)
    public ResponseEntity<GroupDeviceList> findDeviceBy(@PathVariable("groupid") int groupId, @PathVariable("deviceid") int deviceId) {
        Group group = repository.findDeviceInGroupBy(groupId, deviceId);
        GroupDevice groupDevice = new GroupDevice();
        groupDevice.setGroupId(group.getGroupId());
        groupDevice.setDevices(group.getDevices());
        List<GroupDevice> groups = new ArrayList<>();
        groups.add(groupDevice);
        return new ResponseEntity<>(new GroupDeviceList(groups), HttpStatus.OK);
    }

    @RequestMapping(path = messages, method = RequestMethod.POST)
    public ResponseEntity<IdStatus> createMessage(@PathVariable("groupid") int groupId, @PathVariable("deviceid") int deviceId, @RequestBody MessageRequest messageRequest) {
        Message message = new Message();
        message.setText(messageRequest.getText());
        message.setPriority(messageRequest.getPriority());
        int messageId = repository.createMessage(groupId, deviceId, message);
        //calling firebase api
        Group group = repository.findMessageInGroupBy(groupId, deviceId, messageId);
        GroupMessage groupMessage = new GroupMessage();
        groupMessage.setGroupId(group.getGroupId());
        groupMessage.setDevices(group.getDevices());
        groupMessage.setMessages(group.getMessages());
        List<GroupMessage> groups = new ArrayList<>();
        groups.add(groupMessage);
        GroupMessageList groupMessageList = new GroupMessageList(groups);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForLocation("https://blistering-fire-4554.firebaseio.com/restApiTest.json",groupMessageList);
        //
        return new ResponseEntity<>(new IdStatus(messageId, "create was successful"), HttpStatus.OK);
    }

    @RequestMapping(path = messages, method = RequestMethod.GET)
    public ResponseEntity<GroupMessageList> findMessages(@PathVariable("groupid") int groupId, @PathVariable("deviceid") int deviceId) {
        Group group = repository.findMessageInGroup(groupId, deviceId);
        GroupMessage groupMessage = new GroupMessage();
        groupMessage.setGroupId(group.getGroupId());
        groupMessage.setDevices(group.getDevices());
        groupMessage.setMessages(group.getMessages());
        List<GroupMessage> groups = new ArrayList<>();
        groups.add(groupMessage);
        return new ResponseEntity<>(new GroupMessageList(groups), HttpStatus.OK);
    }

    @RequestMapping(path = messagesId, method = RequestMethod.DELETE)
    public ResponseEntity<IdStatus> deleteMessageBy(@PathVariable("groupid") int groupId, @PathVariable("deviceid") int deviceId, @PathVariable("messageid") int messageId) {
        repository.deleteMessage(groupId, messageId);
        return new ResponseEntity<>(new IdStatus(messageId, "delete was successful"), HttpStatus.OK);
    }

    @RequestMapping(path = messagesId, method = RequestMethod.PUT)
    public ResponseEntity<IdStatus> updateMessageBy(@PathVariable("groupid") int groupId, @PathVariable("deviceid") int deviceId, @PathVariable("messageid") int messageId, @RequestBody MessageRequest messageRequest) {
        Message message = new Message();
        message.setText(messageRequest.getText());
        message.setPriority(messageRequest.getPriority());
        repository.updateMessage(messageId, message);
        return new ResponseEntity<IdStatus>(new IdStatus(messageId, "update was successful"), HttpStatus.OK);
    }

    @RequestMapping(path = messagesId, method = RequestMethod.GET)
    public ResponseEntity<GroupMessageList> findMessageBy(@PathVariable("groupid") int groupId, @PathVariable("deviceid") int deviceId, @PathVariable("messageid") int messageId) {
        Group group = repository.findMessageInGroupBy(groupId, deviceId, messageId);
        GroupMessage groupMessage = new GroupMessage();
        groupMessage.setGroupId(group.getGroupId());
        groupMessage.setDevices(group.getDevices());
        groupMessage.setMessages(group.getMessages());
        List<GroupMessage> groups = new ArrayList<>();
        groups.add(groupMessage);
        GroupMessageList groupMessageList = new GroupMessageList(groups);
        return new ResponseEntity<>(groupMessageList, HttpStatus.OK);
    }

    @RequestMapping(path = channels, method = RequestMethod.POST)
    public ResponseEntity<IdStatus> createChannel(@PathVariable("groupid") int groupId, @RequestBody ChannelRequest channelRequest) {
        Channel channel = new Channel();
        channel.setChannelName(channelRequest.getChannelName());
        channel.setTitle(channelRequest.getTitle());
        channel.setText(channelRequest.getText());
        channel.setRefreshTime(channelRequest.getRefreshTime());
        channel.setChannelType(ChannelType.valueOf(channelRequest.getChannelType()));
        int channelId = repository.createChannel(groupId, channel);
        //calling firebase api
        Group group = repository.findChannelInGroupBy(groupId, channelId);
        GroupChannel groupChannel = new GroupChannel();
        groupChannel.setGroupId(group.getGroupId());
        groupChannel.setChannels(group.getChannels());
        List<GroupChannel> groups = new ArrayList<>();
        groups.add(groupChannel);
        GroupChannelList groupChannelList = new GroupChannelList(groups);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForLocation("https://blistering-fire-4554.firebaseio.com/restApiTest.json",groupChannelList);
        //
        return new ResponseEntity<>(new IdStatus(channelId, "create was successful"), HttpStatus.OK);
    }

    @RequestMapping(path = channels, method = RequestMethod.GET)
    public ResponseEntity<GroupChannelList> findChannels(@PathVariable("groupid") int groupId) {
        Group group = repository.findChannelInGroup(groupId);
        GroupChannel groupChannel = new GroupChannel();
        groupChannel.setGroupId(group.getGroupId());
        groupChannel.setChannels(group.getChannels());
        List<GroupChannel> groups = new ArrayList<>();
        groups.add(groupChannel);
        GroupChannelList result = new GroupChannelList(groups);

//        //consuming
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.postForObject("https://blistering-fire-4554.firebaseio.com/testOrg/Channels.json", , GroupChannelList.class);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(path = channelsId, method = RequestMethod.DELETE)
    public ResponseEntity<IdStatus> deleteChannel(@PathVariable("groupid") int groupId, @PathVariable("channelid") int channelId) {
        repository.deleteChannel(groupId, channelId);
        return new ResponseEntity<>(new IdStatus(channelId, "delete was successful"), HttpStatus.OK);
    }

    @RequestMapping(path = channelsId, method = RequestMethod.PUT)
    public ResponseEntity<IdStatus> updateChannel(@PathVariable("channelid") int channelId, @RequestBody ChannelRequest channelRequest) {
        Channel channel = new Channel();
        channel.setChannelName(channelRequest.getChannelName());
        channel.setTitle(channelRequest.getTitle());
        channel.setText(channelRequest.getText());
        channel.setRefreshTime(channelRequest.getRefreshTime());
        channel.setChannelType(ChannelType.valueOf(channelRequest.getChannelType()));
        repository.updateChannel(channelId, channel);
        return new ResponseEntity<>(new IdStatus(channelId, "update was successful"), HttpStatus.OK);
    }

    @RequestMapping(path = channelsId, method = RequestMethod.GET)
    public ResponseEntity<GroupChannelList> findChannelBy(@PathVariable("groupid") int groupId, @PathVariable("channelid") int channelId) {
        Group group = repository.findChannelInGroupBy(groupId, channelId);
        GroupChannel groupChannel = new GroupChannel();
        groupChannel.setGroupId(group.getGroupId());
        groupChannel.setChannels(group.getChannels());
        List<GroupChannel> groups = new ArrayList<>();
        groups.add(groupChannel);
        GroupChannelList groupChannelList = new GroupChannelList(groups);
        return new ResponseEntity<>(groupChannelList, HttpStatus.OK);
    }


}
