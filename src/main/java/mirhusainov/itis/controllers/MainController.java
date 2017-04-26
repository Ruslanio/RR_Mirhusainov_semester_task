package mirhusainov.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ruslan on 26.04.2017.
 */
@Controller
public class MainController {

    @RequestMapping("/home")
    public String home(Model model){
        return "home";
    }
}
