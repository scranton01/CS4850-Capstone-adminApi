package kennesawstate.cs4850.tallulah.infrastructure;

import kennesawstate.cs4850.tallulah.domain.Sample;
import org.springframework.beans.factory.annotation.Autowired;


public class InfraService {
    @Autowired
    private Mapper mapper;

    public Sample getSample(){
        return mapper.getSample();
    }
}
