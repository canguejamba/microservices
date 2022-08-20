/**
 * Created by IntelliJ IDEA.
 * User: Cangue.Jamba
 * Project name: microservices
 */
package io.blog.comment;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class CommentServiceApp {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    public static void main(String[] args) {
        SpringApplication.run(CommentServiceApp.class, args);
    }
}

