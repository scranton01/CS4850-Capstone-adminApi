package kennesaw.cs4850.tallulah.domain;


import kennesaw.cs4850.tallulah.infrastructure.InfraService;
import org.springframework.beans.factory.annotation.Autowired;

public class Service implements Repository {
    @Autowired
    private InfraService infraService;

    public Sample getSample() {
        return infraService.getSample();
    }
}
