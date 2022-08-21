/**
 * Created by IntelliJ IDEA.
 * User: Cangue.Jamba
 * Project name: microservices
 */
package io.blog.article;

import io.clients.feign.comment.CommentClient;
import io.clients.feign.shared.CommentDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.List;

@Service
 @AllArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    private final RestTemplate restTemplate;
    private final CommentClient commentClient;

public void registerArticle(ArticleRegisterRequest articleRegisterRequest){

    Article article = Article.builder()
            .title(articleRegisterRequest.title())
            .body(articleRegisterRequest.body())
            .createdAt(Instant.now())
            .updatedAt(Instant.now())
            .build();
    articleRepository.save(article);
}
    public ArticleDto findFullDetailsArticle(final Long articleId) {
        final Article article = articleRepository.findArticleById(articleId);
        final ArticleDto articleDto = ArticleDto.builder()
                .articleId(article.getId())
                .title(article.getTitle())
                .body(article.getBody())
                .comments(fillAdditionalData(article))
                .createdAt(article.getCreatedAt())
                .updatedAt(article.getUpdatedAt())
                .build();
        return articleDto;
    }

    private List<CommentDto> fillAdditionalData(final Article article) {

        List<CommentDto>commentDtoList = commentClient.getComment(article.getId());

        return commentDtoList;
    }



}
