/**
 * Created by IntelliJ IDEA.
 * User: Cangue.Jamba
 * Project name: microservices
 */
package io.blog.article;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/articles")
@AllArgsConstructor
public class ArticleController {

    public final ArticleService articleService;

    @PostMapping
    public void registerArticle(@RequestBody ArticleRegisterRequest articleRegisterRequest){
        log.info("new Article registration {}", articleRegisterRequest);
        articleService.registerArticle(articleRegisterRequest);
    }

    @GetMapping(path = "{articleId}")
    public ArticleDto findArticle(@PathVariable(value = "articleId") final Long articleId) {
        final ArticleDto articleDto = articleService.findFullDetailsArticle(articleId);

        return articleDto;
    }


}
