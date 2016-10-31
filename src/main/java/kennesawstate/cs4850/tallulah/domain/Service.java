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
    public int createGroupId(){
        return infraService.createGroupId();
    }
    public List<Integer> findAllGroupId(){
        return infraService.findAllgroupId();
    }
    public Integer deleteGroupBy(){
        return null;
    }
}
