package kennesawstate.cs4850.tallulah.domain;


import kennesawstate.cs4850.tallulah.infrastructure.InfraService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service implements Repository {

    @Autowired
    private InfraService infraService;

    public Sample getSample() {
        return infraService.getSample();
    }
    public Integer createGroupId(){
        return infraService.createGroupId();
    }
    public List<Integer> findAllGroupId(){
        return infraService.findAllGroupId();
    }
    public Integer deleteGroupBy(int groupId){
        return infraService.deleteGroupBy(groupId);
    }
    public Group findGroupBy(int groupId){
        return infraService.findGroupBy(groupId);
    }
}
