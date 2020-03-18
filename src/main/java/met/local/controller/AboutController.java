package met.local.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;

@Controller
public class AboutController {

    @Value("#{ messageSource.getMessage('admin.email',null,'en')}")
    private String email;

    @RequestMapping("/about")
    public String aboutController(Model model) {
        model.addAttribute("email", email);
        return "about";
    }
}
