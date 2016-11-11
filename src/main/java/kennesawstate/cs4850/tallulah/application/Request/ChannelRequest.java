package kennesawstate.cs4850.tallulah.application.Request;

import lombok.Data;

@Data
public class ChannelRequest {
    String channelName;
    String title;
    String text;
    long refreshTime;
    String channelType;
}
