package me.junggunwoo.springbootdeveloper.repository;

import me.junggunwoo.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
