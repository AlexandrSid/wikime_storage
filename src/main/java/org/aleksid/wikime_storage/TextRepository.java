package org.aleksid.wikime_storage;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TextRepository extends MongoRepository<ArticleText, String> {
}