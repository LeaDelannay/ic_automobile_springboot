package com.epsi.ic_automobile.api.repository;

import com.epsi.ic_automobile.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
}
