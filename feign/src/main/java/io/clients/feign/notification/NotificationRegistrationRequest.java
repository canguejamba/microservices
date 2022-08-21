package io.clients.feign.notification;

import lombok.Builder;

@Builder
public record NotificationRegistrationRequest(
        String message,
        String sender,
        Long commentId,
        Long articleId
) {

}
