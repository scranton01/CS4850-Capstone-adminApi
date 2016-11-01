package kennesawstate.cs4850.tallulah.domain;

import java.util.List;

public interface Repository {
    Sample getSample();
    Integer createGroupId();
    List<Integer> findAllGroupId();
    Integer deleteGroupBy(int groupId);
}
