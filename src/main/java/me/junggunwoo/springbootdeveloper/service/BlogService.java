package me.junggunwoo.springbootdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.junggunwoo.springbootdeveloper.domain.Article;
import me.junggunwoo.springbootdeveloper.dto.AddArticleRequest;
import me.junggunwoo.springbootdeveloper.dto.UpdateArticleRequest;
import me.junggunwoo.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final 이 붙거나 @Notnull 이 붙은 필드의 생성자 추가
@Service // 빈 으로 등록
public class BlogService {

    private final BlogRepository blogRepository;

    // 블로그 글 추가 메소드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    // 블로그 글 목록 조회 메소드
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    // 블로그 글 1개 조회 메소드
    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
    }

    // 블로그 글 삭제 메소드
    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    // 블로그 글 수정 메소드
    @Transactional // 트랜잭션 메소드
    public Article update(long id, UpdateArticleRequest request) {

        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
