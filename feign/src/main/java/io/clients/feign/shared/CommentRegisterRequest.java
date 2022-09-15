package io.clients.feign.shared;

public record CommentRegisterRequest(Long articleId, String body) {
}

