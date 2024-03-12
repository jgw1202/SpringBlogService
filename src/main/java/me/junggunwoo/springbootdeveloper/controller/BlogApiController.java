package me.junggunwoo.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.junggunwoo.springbootdeveloper.domain.Article;
import me.junggunwoo.springbootdeveloper.dto.AddArticleRequest;
import me.junggunwoo.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController // HTTP Response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
public class BlogApiController {

    private final BlogService blogService;

    // HTTP 메소드가 POST 일 때 전달받은 URL과 동일하면 메소드로 매핑
    @PostMapping("api/articles")
    // 요청 본문 값 매핑
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }
}
