package me.enmanuel.projectmanager.repository;

import me.enmanuel.projectmanager.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 26-Oct-16
 * Time: 2:47 PM
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
