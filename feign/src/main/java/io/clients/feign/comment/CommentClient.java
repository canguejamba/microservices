package io.clients.feign.comment;

import io.clients.feign.shared.CommentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("comment")
public interface CommentClient {
    @GetMapping(path = "api/v1/comments/{articleId}")
    List<CommentDto> getComment(@PathVariable(value = "articleId") final Long articleId);
}

