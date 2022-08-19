/**
 * Created by IntelliJ IDEA.
 * User: Cangue.Jamba
 * Project name: microservices
 */
package io.blog.comment;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    public CommentResponse registerComment(CommentRegisterRequest commentRegisterRequest) {
        Comment comment = Comment.builder()
                .articleId(commentRegisterRequest.articleId())
                .body(commentRegisterRequest.body())
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
        commentRepository.saveAndFlush(comment);

        return CommentResponse.builder()
                .commentId(comment.getId())
                .articleId(comment.getArticleId())
                .body(comment.getBody())
                .build();
    }

    public Comment getComment(Long articleId) {
        return commentRepository.findByArticleId(articleId);
    }
}
