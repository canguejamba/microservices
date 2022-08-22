package io.clients.feign.notification;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
public record NotificationRegistrationRequest(
        String message,
        String sender,
        Long commentId,
        Long articleId
) {

}
