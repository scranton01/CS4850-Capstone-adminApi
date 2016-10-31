package kennesawstate.cs4850.tallulah.application;


import kennesawstate.cs4850.tallulah.domain.Sample;
import kennesawstate.cs4850.tallulah.domain.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private static final String groups = "/apiadmin/1/groups";
    private static final String groupsId = "/apiadmin/1/groups/{groupid}";
    private static final String users = "/apiadmin/1/groups/{groupid}/users";
    private static final String usersId = "/apiadmin/1/groups/{groupid}/users/{userid}";
    private static final String devices = "/apiadmin/1/groups/{groupid}/devices";
    private static final String devicesId = "/apiadmin/1/groups/{groupid}/devices/{deviceid}";
    private static final String channels = "/apiadmin/1/groups/{groupid}/channels";
    private static final String channelsId = "/apiadmin/1/groups/{groupid}/channels/{chennelid}";
    private static final String messages = "/apiadmin/1/groups/{groupid}/messages";
    private static final String messagesId = "/apiadmin/1/groups/{groupid}/messages/{messageid}";

    @Autowired
    private Service service;

    @RequestMapping(path = "/sample", method = RequestMethod.GET)
    public Sample sampleTest() {
        return service.getSample();
    }

    @RequestMapping(path = groups, method = RequestMethod.POST)
    public String createGroup() {
        return "success";
    }

    @RequestMapping(path = groups, method = RequestMethod.GET)
    public void findGroups() {

    }

    @RequestMapping(path = groupsId, method = RequestMethod.DELETE)
    public void deleteGroupBy() {

    }

    @RequestMapping(path = groupsId, method = RequestMethod.GET)
    public void findGroupBy() {

    }

    @RequestMapping(path = users, method = RequestMethod.POST)
    public void createUser() {

    }

    @RequestMapping(path = users, method = RequestMethod.GET)
    public void findUsers() {

    }

    @RequestMapping(path = usersId, method = RequestMethod.DELETE)
    public void deleteUserBy() {

    }

    @RequestMapping(path = usersId, method = RequestMethod.PUT)
    public void updateUserBy() {

    }

    @RequestMapping(path = usersId, method = RequestMethod.GET)
    public void findUserBy() {

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
