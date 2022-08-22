/**
 * Created by IntelliJ IDEA.
 * User: Cangue.Jamba
 * Project name: microservices
 */
package io.blog.comment;

import io.clients.feign.notification.NotificationClient;
import io.clients.feign.notification.NotificationRegistrationRequest;
import io.message.server.RabbitMQMessageProducer;
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
    private final NotificationClient notificationClient;

    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    private final ModelMapper mapper;

    public CommentDto registerComment(CommentRegisterRequest commentRegisterRequest) {
        Comment comment = Comment.builder()
                .articleId(commentRegisterRequest.articleId())
                .body(commentRegisterRequest.body())
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
        commentRepository.saveAndFlush(comment);

        // todo:send notification to admin
        NotificationRegistrationRequest notificationRegistrationRequest = NotificationRegistrationRequest.builder()
                .message("new comment")
                .sender("admin")
                .commentId(comment.getId())
                .articleId(comment.getArticleId())
                .build();
 //notificationClient.registerNotification(notificationRegistrationRequest);

        rabbitMQMessageProducer.publish(
                notificationRegistrationRequest,
                "internal.exchange",
                "internal-notification.routing-key"
        );

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
