package KaamaBeemacom.example.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication()
@OpenAPIDefinition(info = @Info(title = "KaamaBeema main API", version = "1.0"))
public class KaamaBeemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaamaBeemaApplication.class, args);
	}

}
