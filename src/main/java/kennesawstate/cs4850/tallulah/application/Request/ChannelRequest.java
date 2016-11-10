package kennesawstate.cs4850.tallulah.application.Request;

import lombok.Data;

@Data
public class ChannelRequest {
    String name;
    String title;
    String text;
    Long refreshTime;
}
