package kennesawstate.cs4850.tallulah.domain;

import lombok.Data;

@Data
public class Message {
    int messageId;
    String text;
    int priority;
}
