package me.enmanuel.projectmanager.repository;

import me.enmanuel.projectmanager.entity.Task;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 27-Oct-16
 * Time: 2:15 PM
 */
public interface TaskRepository extends CrudRepository<Task, Integer> {
}
