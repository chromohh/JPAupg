package sindre.ec.JPAinl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class JpAinlApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpAinlApplication.class, args);
	}

}
