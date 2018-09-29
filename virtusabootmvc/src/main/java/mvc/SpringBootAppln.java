package mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"mvc"})
public class SpringBootAppln {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppln.class, args);
	}
}
