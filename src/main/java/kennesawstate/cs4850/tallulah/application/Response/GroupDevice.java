package kennesawstate.cs4850.tallulah.application.Response;

import kennesawstate.cs4850.tallulah.domain.Device;
import lombok.Data;

import java.util.List;

@Data
public class GroupDevice {
    int groupId;
    List<Device> devices;
}
