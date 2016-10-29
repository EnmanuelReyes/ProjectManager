package me.enmanuel.projectmanager.service;

import me.enmanuel.projectmanager.entity.Task;
import me.enmanuel.projectmanager.entity.User;
import me.enmanuel.projectmanager.repository.TaskRepository;
import me.enmanuel.projectmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 27-Oct-16
 * Time: 2:18 PM
 */
@org.springframework.stereotype.Service
public class TaskService implements Service<Task>{

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Task findOne(Integer var1) {
        return taskRepository.findOne(var1);
    }

    @Override
    public Task save(Task var1) {
        if (var1.getId() == null) var1.setCreationDate(LocalDateTime.now());
        return taskRepository.save(var1);
    }

    @Override
    public void delete(Integer var1) {
        taskRepository.delete(var1);
    }

    @Override
    public void delete(Task entity) {
        taskRepository.delete(entity);
    }

    @Override
    public Iterable<Task> findAll() {
    return taskRepository.findAll();
    }


    public List<Task> getTasksForDashboard() {
        return taskRepository.findByAssignedUserNotNullAndDeadlineNotNull();
    }

    public void createDummyData() {

        User enmanuel = new User();
        enmanuel.setName("Enmanuel");
        enmanuel.setLastName("Reyes");

        User domingo = new User();
        domingo .setName("Domingo");
        domingo .setLastName("Martinez");

        final LocalDateTime now = LocalDateTime.now();
        Task design = new Task();
        design.setName("Diseñar");
        design.setDescription("Diseñar la solución del problema");
        design.setDeadline(now.plusHours(3));
        design.setCreationDate(now);
        design.setAssignedUser(domingo);
        design.setProgress((byte) 50);
        Task program = new Task();
        program.setName("Programar");
        program.setDescription("Tirar código");
        program.setDeadline(now.plusHours(7));
        program.setCreationDate(now.plusHours(4));
        program.setAssignedUser(enmanuel);
        program.setProgress((byte) 25);

        userRepository.save(Arrays.asList(enmanuel,domingo));
        save(design);
        save(program);
    }
}
