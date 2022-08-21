package io.clients.feign.shared;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private long commentId;
    private long articleId;
    private String body;
    private Instant createdAt ;
    private Instant updatedAt;
}


