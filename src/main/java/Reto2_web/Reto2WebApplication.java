//modelo
//interface
//repositorio
//servicio
//contolador
package Reto2_web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class Reto2WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(Reto2WebApplication.class, args);
	}
        
        @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*").allowedOrigins("");
            }
        };
    }
}
