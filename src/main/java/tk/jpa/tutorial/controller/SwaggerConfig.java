package tk.jpa.tutorial.controller;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiDocket() {

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("tk.jpa.tutorial.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getAppInfo());

	}

	private ApiInfo getAppInfo() {
		ApiInfo info = new ApiInfo(
				"Users Rest API",
				"This tis the description of the API",
				"v1.0",
				"TERMS OF SERVICE URL",
				new Contact("Toseef", "https://toseefkhilji.github.io/", "toseefhusen@rangam.com"),
				"Apache License Version 2.0",
				"https://www.apache.org/licenses/LICENSE-2.0",
				new ArrayList<>()
				); 
		return info;
	}
}