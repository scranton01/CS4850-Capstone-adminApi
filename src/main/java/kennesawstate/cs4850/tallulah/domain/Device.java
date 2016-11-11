package kennesawstate.cs4850.tallulah.domain;

import lombok.Data;

@Data
public class Device {
    int deviceId;
    int ownerId;
    String ownerName;
}
