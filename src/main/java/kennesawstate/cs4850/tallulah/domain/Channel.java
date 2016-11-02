package kennesawstate.cs4850.tallulah.domain;

import lombok.Data;

@Data
public class Channel {
    int channelId;
    String name;
    String title;
    String text;
    double refreshTime;
    ChannelType channelType;
}
