package org.aleksid.wikime_storage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "article_texts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleText {

    @Id
    public String articleId;
    public String text;

}
