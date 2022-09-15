package io.clients.feign.comment;

import io.clients.feign.shared.CommentDto;
import io.clients.feign.shared.CommentRegisterRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name = "comment",
        url = "${feign.comment.url}"
)
public interface CommentClient {

    @GetMapping(path = "api/v1/comments/{articleId}")
    List<CommentDto> getComment(@PathVariable(value = "articleId") final Long articleId);
}

