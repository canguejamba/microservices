/**
 * Created by IntelliJ IDEA.
 * User: Cangue.Jamba
 * Project name: microservices
 */
package io.blog.comment;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    private final ModelMapper mapper;

    public CommentDto registerComment(CommentRegisterRequest commentRegisterRequest) {
        Comment comment = Comment.builder()
                .articleId(commentRegisterRequest.articleId())
                .body(commentRegisterRequest.body())
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
        commentRepository.saveAndFlush(comment);

        return CommentDto.builder()
                .commentId(comment.getId())
                .articleId(comment.getArticleId())
                .body(comment.getBody())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();

    }



    public List<CommentDto> getComment(Long articleId) {

        List<Comment> comments = commentRepository.findCommentsByArticleId(articleId);

        return comments.stream().map(comment -> mapToDTO(comment)).collect(Collectors.toList());
    }

    private CommentDto mapToDTO(Comment comment) {
        //convert entity to DTO
        CommentDto newCommentDto = mapper.map(comment, CommentDto.class);

        return newCommentDto;
    }
}
