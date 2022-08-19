/**
 * Created by IntelliJ IDEA.
 * User: Cangue.Jamba
 * Project name: microservices
 */
package io.blog.article;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/article")
@AllArgsConstructor
public class ArticleController {

    public final ArticleService articleService;

    @PostMapping
    public void registerArticle(@RequestBody ArticleRegisterRequest articleRegisterRequest){
        log.info("new Article registration {}", articleRegisterRequest);
        articleService.registerArticle(articleRegisterRequest);
    }
}
