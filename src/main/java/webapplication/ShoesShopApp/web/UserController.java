package webapplication.ShoesShopApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webapplication.ShoesShopApp.model.User;
import webapplication.ShoesShopApp.model.dto.UserRegistrationDto;
import webapplication.ShoesShopApp.service.user.UserServiceImpl;

import java.security.Principal;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/userPanel")
    public String userPanel(Model model, Principal principal) {
        String email = principal.getName();
        model.addAttribute("user", userService.getByEmail(email));
        return "userPanel";
    }


    @RequestMapping(value = "/saveUserData", method = RequestMethod.POST)
    public String saveUserData(@ModelAttribute("user") UserRegistrationDto userReg, Principal principal,
                               @RequestParam("oldPassword") String oldPassword,
                               @RequestParam("newPassword") String newPassword) {
        String email = principal.getName();
        Optional<User> optionalUser = userService.getByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setFirstName(userReg.getFirstName());
            user.setLastName(userReg.getLastName());
            userService.changeUserPassword(oldPassword, newPassword, principal);
            userService.saveUserData(user);
        }

        return "redirect:/userPanel";
    }
}
