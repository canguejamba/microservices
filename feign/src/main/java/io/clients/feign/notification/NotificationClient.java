package io.clients.feign.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("notification")
public interface NotificationClient {
    @GetMapping(path = "api/v1/notification")
    void registerNotification(@RequestBody NotificationRegistrationRequest notificationRegistrationRequest);
}
