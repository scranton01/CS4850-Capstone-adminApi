package kennesawstate.cs4850.tallulah.application.Response;

import lombok.Builder;

import java.util.List;

@Builder
public class DetailGroupId {
    int groupid;
    List<UserId> users;
    List<DeviceId> devices;
    List<ChannelId> channels;
    List<MessageId> messages;
}
