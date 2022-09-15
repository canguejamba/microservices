package io.clients.feign.shared;

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
