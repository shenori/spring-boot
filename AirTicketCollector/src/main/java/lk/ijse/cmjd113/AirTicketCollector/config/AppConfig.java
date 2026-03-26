package lk.ijse.cmjd113.AirTicketCollector.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// ✅ NEW FILE: App configuration — registers ModelMapper as a Spring bean
// and sets up global CORS for Angular frontend
@Configuration
public class AppConfig implements WebMvcConfigurer {

    // ModelMapper converts between DTO and Entity objects automatically
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    // ✅ FIX: Global CORS config — allows Angular (localhost:4200) to call this API
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }
}
