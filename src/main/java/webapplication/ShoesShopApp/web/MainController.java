package webapplication.ShoesShopApp.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import webapplication.ShoesShopApp.model.User;
import webapplication.ShoesShopApp.model.dto.EditUserStatusDto;
import webapplication.ShoesShopApp.service.product.ProductServiceImpl;
import webapplication.ShoesShopApp.service.role.RoleServiceImpl;
import webapplication.ShoesShopApp.service.user.UserServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {
    private UserServiceImpl userServiceImpl;
    private ProductServiceImpl productService;
    private RoleServiceImpl roleService;

    private static Logger logger = LogManager.getLogger(MainController.class);

    public MainController(UserServiceImpl userServiceImpl, ProductServiceImpl productService, RoleServiceImpl roleService) {
        this.userServiceImpl = userServiceImpl;
        this.productService = productService;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/login")
    public String login (){
        return "login";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/newarticle")
    public String newArticle(){
        return "newarticle";
    }

    @GetMapping("/privileges")
    public String privileges(Model model){
        List<User> userList = userServiceImpl.listAll();
        model.addAttribute("userList", userList);
        return "privileges";
    }

    @GetMapping("/deleteUser/{id}")
    public String delUser(@PathVariable(name = "id") int id){
        userServiceImpl.delete(id);
        return "privileges";
    }

    @GetMapping("/changeUserStatus/{id}")
    public String changeUserStatus(
            @PathVariable(name = "id") long id,
            @Valid @ModelAttribute("userStatus") EditUserStatusDto editUserStatusDto,
            BindingResult result){
        userServiceImpl.changeUserStatus(id, editUserStatusDto);
        return "privileges";
    }


/*
    @GetMapping("/changeUserStatus/{id}")
    public String changeUserStatus(
            @PathVariable(name = "id") long id,
            @Valid Role role,
            BindingResult result,
            Model model){
        if (result.hasErrors()){
            role.setId(id);
            return "privileges";
        }
        roleService.save(role);
        return "privileges";
    }
    */


    @GetMapping("/editUserStatus")
    public String editUserStatus(Model model){
        List<User> userList = userServiceImpl.listAll();
        model.addAttribute("userList",userList);
        return "editUserStatus";
    }

    @GetMapping("/editUserStatus/{id}")
    public ModelAndView editUserStatus(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("editUserStatus");
        User user = userServiceImpl.getUserById(id);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

}
