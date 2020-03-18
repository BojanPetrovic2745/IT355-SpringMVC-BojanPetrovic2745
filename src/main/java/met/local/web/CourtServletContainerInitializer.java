package met.local.web;

import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import met.local.config.CourtConfiguration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class CourtServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext sc) throws ServletException {
       
        AnnotationConfigWebApplicationContext applicationContext
                = new AnnotationConfigWebApplicationContext();
        
        applicationContext.register(CourtConfiguration.class);
        
        DispatcherServlet dispatcherServlet = 
                new DispatcherServlet(applicationContext);
        
        ServletRegistration.Dynamic courtRegistration
                = sc.addServlet("court", dispatcherServlet);
        
        courtRegistration.setLoadOnStartup(1);
        courtRegistration.addMapping("/");
    }
    
}
