package me.junggunwoo.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.junggunwoo.springbootdeveloper.domain.Article;
import me.junggunwoo.springbootdeveloper.dto.AddArticleRequest;
import me.junggunwoo.springbootdeveloper.dto.ArticleResponse;
import me.junggunwoo.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController // HTTP Response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
public class BlogApiController {

    private final BlogService blogService;

    // HTTP 메소드가 POST 일 때 전달받은 URL과 동일하면 메소드로 매핑
    @PostMapping("/api/articles")
    // 요청 본문 값 매핑
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){

        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

    // GET 요청이 오면 글 전체 조회 메소드 호출 후 응답용 객체인 ArticleResponse 로 파싱해
    // body에 담아 클라이언트에게 전송 (스트림 적용)
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {

        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }
}
