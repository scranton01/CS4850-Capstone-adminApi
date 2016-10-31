package kennesawstate.cs4850.tallulah.infrastructure;

import kennesawstate.cs4850.tallulah.domain.Sample;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {
    Sample getSample();
    void createGroupId();
    int findLatestGroupId();
    List<Integer> findAllGroupId();
}
