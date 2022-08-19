/**
 * Created by IntelliJ IDEA.
 * User: Cangue.Jamba
 * Project name: microservices
 */
package io.blog.article;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
 @AllArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

public void registerArticle(ArticleRegisterRequest articleRegisterRequest){

    Article article = Article.builder()
            .title(articleRegisterRequest.title())
            .body(articleRegisterRequest.body())
            .createdAt(Instant.now())
            .updatedAt(Instant.now())
            .build();
    articleRepository.save(article);
}

}
