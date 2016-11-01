package kennesawstate.cs4850.tallulah.infrastructure;

import kennesawstate.cs4850.tallulah.domain.Sample;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class InfraService {
    @Autowired
    private Mapper mapper;

    public Sample getSample(){
        return mapper.getSample();
    }

    public int createGroupId(){
        mapper.createGroupId();
        return mapper.findLatestGroupId();
    }

    public List<Integer> findAllgroupId(){
        return mapper.findAllGroupId();
    }

    public int deleteGroupBy(int groupId){
        return mapper.deleteGroupBy(groupId);
    }
}
