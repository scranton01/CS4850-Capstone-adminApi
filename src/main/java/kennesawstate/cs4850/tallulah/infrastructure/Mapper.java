package kennesawstate.cs4850.tallulah.infrastructure;

import kennesawstate.cs4850.tallulah.domain.Group;
import kennesawstate.cs4850.tallulah.domain.Sample;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {
    Sample getSample();
    void createGroupId();
    int findCurrentGroupId();
    int findLatestGroupId();
    List<Integer> findAllGroupId();
    int deleteGroupBy(int groupId);
    Group findGroupBy(int groupId);
}
