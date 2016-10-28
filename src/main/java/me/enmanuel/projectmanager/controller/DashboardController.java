package me.enmanuel.projectmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 28-Oct-16
 * Time: 1:09 PM
 */
@Controller
public class DashboardController {
    @RequestMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}
