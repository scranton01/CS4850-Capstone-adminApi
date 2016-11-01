package kennesawstate.cs4850.tallulah.domain;

import lombok.Data;

import java.util.List;

@Data
public class Group {
    int groupid;
    List<User> users;
    List<Device> devices;
    List<Channel> channels;
    List<Message> messages;
}
