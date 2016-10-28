package me.enmanuel.projectmanager.controller;

import me.enmanuel.projectmanager.entity.User;
import me.enmanuel.projectmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 26-Oct-16
 * Time: 2:57 PM
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public ModelAndView users(ModelAndView modelAndView) {
        modelAndView.addObject("users", userService.findAll());
        modelAndView.setViewName("users");
        return modelAndView;
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ModelAndView save(ModelAndView modelAndView, User user, RedirectAttributes redirectAttributes) {
        userService.save(user);
        redirectAttributes.addFlashAttribute("success", "El usuario fue guardado correctamente");
        modelAndView.setViewName("redirect:/users");

        return modelAndView;
    }

    @RequestMapping(value = "/user/{userId}")
    public ModelAndView edit(ModelAndView modelAndView, @PathVariable("userId") User user) {

        modelAndView.setViewName("user");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/user/create")
    public ModelAndView create(ModelAndView modelAndView) {

        modelAndView.setViewName("user");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value = "/user/delete/{userId}")
    public ModelAndView delete(ModelAndView modelAndView, @PathVariable Integer userId,
                               RedirectAttributes redirectAttributes) {
        userService.delete(userId);
        redirectAttributes.addFlashAttribute("success", "El usuario fue eliminado correctamente");
        modelAndView.setViewName("redirect:/users");
        return modelAndView;
    }
}
