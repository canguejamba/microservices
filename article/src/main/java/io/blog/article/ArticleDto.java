/**
 * Created by IntelliJ IDEA.
 * User: Cangue.Jamba
 * Project name: microservices
 */
package io.blog.article;

import io.clients.feign.shared.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private long articleId;
    private String title;
    private String body;
    private List<CommentDto> comments;
    private Instant createdAt;
    private Instant updatedAt;
}

