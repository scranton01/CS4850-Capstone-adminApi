package kennesawstate.cs4850.tallulah.application.Response;

import kennesawstate.cs4850.tallulah.domain.Channel;
import lombok.Data;

import java.util.List;

/**
 * Created by n_jun on 11/10/2016.
 */
@Data
public class GroupChannel {
    int groupId;
    List<Channel> channels;
}
