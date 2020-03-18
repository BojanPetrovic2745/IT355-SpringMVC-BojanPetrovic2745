package met.local.config;

import met.local.domain.SportType;
import met.local.domain.SportTypeConverter;
import met.local.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("met.local")
public class WebConfiguration implements WebMvcConfigurer {
    
    @Autowired
    private ReservationService reservationService;
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new SportTypeConverter(reservationService));
    }
    
}
