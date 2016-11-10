package kennesawstate.cs4850.tallulah.domain;

import lombok.Data;

@Data
public class Channel {
    int channelId;
    String channelName;
    String title;
    String text;
    Long refreshTime;
    ChannelType channelType;
}
