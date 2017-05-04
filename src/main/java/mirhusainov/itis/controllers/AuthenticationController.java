package mirhusainov.itis.controllers;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.org.apache.xpath.internal.operations.Mod;
import mirhusainov.itis.entities.UsersEntity;
import mirhusainov.itis.service.UserService;
import mirhusainov.itis.util.SignInDataHolder;
import mirhusainov.itis.util.SignUpDataHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by Ruslan on 27.04.2017.
 */
@Controller
public class AuthenticationController {

    private final UserService userService;
    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/sign-in")
    public String signIn(@RequestParam(value = "error", required = false)Boolean error, Model model) {
        if (error.equals(true)){
            model.addAttribute("error",error);
        }
        model.addAttribute("signUpDataHolder",new SignInDataHolder());
        return "sign-in";
    }

    @RequestMapping("/sign-up")
    public String signUp(Model model) {
        SignUpDataHolder holder = new SignUpDataHolder();
        model.addAttribute("userHolder", holder);
        return "sign-up";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public String doSignUp(@ModelAttribute("userSignUpHolder") @Valid SignUpDataHolder holder, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "sign-up";
        }
        UsersEntity user = new UsersEntity();

        if (holder.getPassword().equals(holder.getRepeatedPassword())) {

            user.setEmail(holder.getEmail());
            user.setUserName(holder.getName());
            user.setPassword(encoder.encode(holder.getPassword()));//md5

        } else {
            return "sign-up-pass-dont-match";
        }

        if (!userService.getAll().contains(user)){
            userService.add(user);
        }
        return "redirect:/home";
    }
}
