package me.enmanuel.projectmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel
 * Date: 05/11/2016
 * Time: 09:38 AM
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "redirect:/dashboard";
    }
}


