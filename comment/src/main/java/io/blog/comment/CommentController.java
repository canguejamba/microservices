/**
 * Created by IntelliJ IDEA.
 * User: Cangue.Jamba
 * Project name: microservices
 */
package io.blog.comment;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;


@RestController
@AllArgsConstructor
@RequestMapping("api/v1/comments")
@Slf4j
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public CommentDto registerComment(@RequestBody CommentRegisterRequest commentRegisterRequest) {
        log.info("new Comment registration {}", commentRegisterRequest);
        return commentService.registerComment(commentRegisterRequest);
    }

    @GetMapping(path = "{articleId}")
    public List<CommentDto> getComment(@PathVariable(value = "articleId") Long articleId){
        log.info("get Comment by Article id {}", articleId);
        return commentService.getComment(articleId);
    }


}
