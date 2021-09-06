package tk.jpa.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication  @ComponentScan(basePackages = {"tk.jpa.tutorial.*"}) 
@EnableJpaRepositories("tk.jpa.tutorial.repository")

public class TutorialJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialJpaApplication.class, args);
	}

}
