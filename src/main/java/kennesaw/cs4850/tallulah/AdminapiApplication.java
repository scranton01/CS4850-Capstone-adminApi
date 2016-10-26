package kennesaw.cs4850.tallulah;

import kennesaw.cs4850.tallulah.infrastructure.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdminapiApplication {

	@Autowired
	private Mapper mapper;

	public static void main(String[] args) {
		SpringApplication.run(AdminapiApplication.class, args);
	}
}
