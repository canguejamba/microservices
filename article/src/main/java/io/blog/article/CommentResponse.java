package io.blog.article;

import lombok.Builder;

@Builder
public record CommentResponse(Long commentId, Long articleId, String body) {
}

