package me.enmanuel.projectmanager.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 26-Oct-16
 * Time: 3:20 PM
 */
@Configuration
@EnableJpaRepositories(basePackages = "me.enmanuel.projectmanager.repository")
@EntityScan(basePackages = "me.enmanuel.projectmanager.entity")
public class ApplicationDataSource {
}
