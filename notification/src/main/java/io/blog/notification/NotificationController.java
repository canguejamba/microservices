/**
 * Created by IntelliJ IDEA.
 * User: Cangue.Jamba
 * Project name: microservices
 */
package io.blog.notification;

import io.clients.feign.notification.NotificationRegistrationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/notification")
@AllArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;
    @PostMapping()
    public void registerNotification(@RequestBody NotificationRegistrationRequest notificationRegistrationRequest){
        log.info("new Notification registration {}", notificationRegistrationRequest);
        notificationService.registerNotification(notificationRegistrationRequest);
    }
}
