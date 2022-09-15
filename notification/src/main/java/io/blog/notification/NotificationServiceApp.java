/**
 * Created by IntelliJ IDEA.
 * User: Cangue.Jamba
 * Project name: microservices
 */
package io.blog.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(scanBasePackages = {"io.blog.notification", "io.message.server"})
@EnableEurekaClient
@PropertySources({ @PropertySource("classpath:feign-${spring.profiles.active}.properties")})
public class NotificationServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApp.class, args);
    }





}
