package io.blog.comment;

public record CommentRegisterRequest(Long articleId, String body) {
}

