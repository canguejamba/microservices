/**
 * Created by IntelliJ IDEA.
 * User: Cangue.Jamba
 * Project name: microservices
 */
package io.blog.article;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {
    public static final String ENTITY_TYPE = "Article";

    @GenericGenerator(name = "article_id_sequence", strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters ={
                    @Parameter(name="article_id_sequence",value="article_id_sequence"),
                    @Parameter(name="increment_size",value="1") })
    @Id
    @GeneratedValue( generator = "article_id_sequence")
    private long id;
    private @NotNull String title;
    private @NotNull String body;
    private @NotNull Instant createdAt;
    private @NotNull Instant updatedAt;
}
