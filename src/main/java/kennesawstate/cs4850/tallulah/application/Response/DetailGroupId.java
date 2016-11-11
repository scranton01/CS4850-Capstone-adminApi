package kennesawstate.cs4850.tallulah.application.Response;

import lombok.Data;

import java.util.List;

//@Builder
@Data
public class DetailGroupId {
    int groupId;
    List<UserId> users;
    List<DeviceId> devices;
    List<ChannelId> channels;
    List<MessageId> messages;
}
