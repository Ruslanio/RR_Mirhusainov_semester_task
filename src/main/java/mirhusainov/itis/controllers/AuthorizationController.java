package mirhusainov.itis.controllers;

import mirhusainov.itis.entities.UsersEntity;
import mirhusainov.itis.service.UserService;
import mirhusainov.itis.util.SignUpDataHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;

/**
 * Created by Ruslan on 27.04.2017.
 */
@Controller
public class AuthorizationController {

    private final UserService userService;
    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthorizationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/sign-in")
    public String signIn() {
        return "sign-in";
    }

    @RequestMapping("/sign-up")
    public String signUp(Model model) {
        SignUpDataHolder holder = new SignUpDataHolder();
        model.addAttribute("userHolder", holder);
        return "sign-up";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public String doSignUp(@ModelAttribute("userHolder") @Valid SignUpDataHolder holder, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "sign-up";
        }
        UsersEntity user = new UsersEntity();

        if (holder.getPassword().equals(holder.getRepeatedPassword())) {

            user.setEmail(holder.getEmail());
            user.setUserName(holder.getName());
            user.setPassword(encoder.encode(holder.getPassword()));//md5

        } else {

        }

        if (!userService.getAll().contains(user)){
            userService.add(user);
        }
        return "redirect:/home";
    }
}
