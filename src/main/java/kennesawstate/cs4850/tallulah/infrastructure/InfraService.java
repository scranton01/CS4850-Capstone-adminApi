package kennesawstate.cs4850.tallulah.infrastructure;

import kennesawstate.cs4850.tallulah.domain.Group;
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
        return mapper.findCurrentGroupId();
    }

    public List<Integer> findAllGroupId(){
        return mapper.findAllGroupId();
    }

    public int deleteGroupBy(int groupId){
        return mapper.deleteGroupBy(groupId);
    }

    public Group findGroupBy(int groupId){
        return mapper.findGroupBy(groupId);
    }
}
