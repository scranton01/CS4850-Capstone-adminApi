package kennesawstate.cs4850.tallulah;


import kennesawstate.cs4850.tallulah.domain.Service;
import kennesawstate.cs4850.tallulah.infrastructure.InfraService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Jun on 10/30/2016.
 */
@Configuration
public class AppConfig {
    @Bean
    public InfraService infraService(){
        return new InfraService();
    }
    @Bean
    public Service service(){
        return new Service();
    }
}
