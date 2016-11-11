package kennesawstate.cs4850.tallulah.application.Request;

import lombok.Data;

@Data
public class MessageRequest {
    String text;
    int priority;
}
