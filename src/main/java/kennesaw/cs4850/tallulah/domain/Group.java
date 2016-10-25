package kennesaw.cs4850.tallulah.domain;

import lombok.Data;

import java.util.List;

@Data
public class Group {
    int groupid;
    List<User> users;
    List<Device> devices;
    List<Group> channels;
    List<Message> messages;
}
