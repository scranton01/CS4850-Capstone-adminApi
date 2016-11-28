package kennesawstate.cs4850.tallulah.application.Response;

import kennesawstate.cs4850.tallulah.domain.Device;
import kennesawstate.cs4850.tallulah.domain.Message;
import lombok.Data;

import java.util.List;

@Data
public class GroupMessage {
    int groupId;
    List<Device> devices;
    List<Message> messages;
}
