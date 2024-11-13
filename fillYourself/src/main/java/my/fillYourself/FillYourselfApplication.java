package my.fillYourself;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FillYourselfApplication {

	public static void main(String[] args) {
		SpringApplication.run(FillYourselfApplication.class, args);
	}

}
