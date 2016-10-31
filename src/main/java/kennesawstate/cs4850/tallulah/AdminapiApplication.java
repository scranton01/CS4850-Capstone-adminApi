package kennesawstate.cs4850.tallulah;

import kennesawstate.cs4850.tallulah.infrastructure.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan("Mapper")
public class AdminapiApplication {

	@Autowired
	private Mapper mapper;

	public static void main(String[] args) {
		SpringApplication.run(AdminapiApplication.class, args);
	}
}