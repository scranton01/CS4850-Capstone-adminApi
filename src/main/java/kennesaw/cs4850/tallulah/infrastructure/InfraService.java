package kennesaw.cs4850.tallulah.infrastructure;

import kennesaw.cs4850.tallulah.domain.Sample;



public class InfraService {
    private Mapper mapper;

    public Sample getSample(){
        return mapper.getSample();
    }
}
