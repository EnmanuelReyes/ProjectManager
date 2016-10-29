package me.enmanuel.projectmanager.controller;

import me.enmanuel.projectmanager.entity.Task;
import me.enmanuel.projectmanager.service.TaskService;
import me.enmanuel.projectmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 26-Oct-16
 * Time: 10:52 AM
 */
@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @RequestMapping("/tasks")
    public ModelAndView tasks(ModelAndView modelAndView) {
        modelAndView.addObject("tasks", taskService.findAll());
        modelAndView.setViewName("tasks");
        return modelAndView;
    }


    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public ModelAndView save(ModelAndView modelAndView, Task task, RedirectAttributes redirectAttributes) {
        if (task.getAssignedUser().getId() == null) task.setAssignedUser(null);
        taskService.save(task);
        redirectAttributes.addFlashAttribute("success", "La tarea fue guardada correctamente");
        modelAndView.setViewName("redirect:/tasks");

        return modelAndView;
    }


    @RequestMapping(value = "/task/{taskId}")
    public ModelAndView edit(ModelAndView modelAndView, @PathVariable("taskId") Task task) {

        modelAndView.setViewName("task");
        modelAndView.addObject("task", task);
        attachUsers(modelAndView.getModelMap());
        return modelAndView;
    }


    @RequestMapping(value = "/task/create")
    public ModelAndView create(ModelAndView modelAndView) {

        modelAndView.setViewName("task");
        modelAndView.addObject("task", new Task());
        attachUsers(modelAndView.getModelMap());
        return modelAndView;
    }


    @RequestMapping(value = "/task/delete/{taskId}")
    public ModelAndView delete(ModelAndView modelAndView, @PathVariable Integer taskId,
                               RedirectAttributes redirectAttributes) {
        taskService.delete(taskId);
        redirectAttributes.addFlashAttribute("success", "El usuario fue eliminado correctamente");
        modelAndView.setViewName("redirect:/tasks");
        return modelAndView;
    }

    private void attachUsers(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.findAll());
    }

    @RequestMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Task> tasks() {
        return taskService.getTasksForDashboard();
    }

    @RequestMapping(value = "/mocktasks")
    public ResponseEntity createDummyData() {
        taskService.createDummyData();
        return ResponseEntity.ok().build();
    }
}
