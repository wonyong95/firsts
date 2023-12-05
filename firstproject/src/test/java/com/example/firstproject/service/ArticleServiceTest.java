package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 해당 클래스는 스프링부트와 연동되어 테스트된다
class ArticleServiceTest {

    @Autowired ArticleService articleService;

    @Test
    void index() {
        //예상
        Article a = new Article(1L, "가가", "11");
        Article b = new Article(2L, "나나", "22");
        Article c = new Article(3L, "다다", "33");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));

        // 실제
        List<Article> articles = articleService.index();

        //비교
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show_성공___존재하는_id_입력() {
        // 예상
        Long id = 1L;
        Article expected = new Article(id, "가가", "11");

        // 실제
        Article article = articleService.show(id);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show_실패___존재하지_않는_id_입력() {
        // 예상
        Long id = -1L;
        Article expected = null;

        // 실제
        Article article = articleService.show(id);

        // 비교
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void create_성공____title_content_있는_dto_입력() {
        // 예상
        String title = "라라";
        String content = "44";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);

        // 실제
        Article article = articleService.create(dto);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void create_실패____title_content_포함된_dto_입력() {
        // 예상
        String title = "라라";
        String content = "44";
        ArticleForm dto = new ArticleForm(4L, title, content);
        Article expected = null;

        // 실제
        Article article = articleService.create(dto);

        // 비교
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void update_성공____존재하는_id_title_content가_있는_dto_입력() {

        Long id = 1L;
        String title = "수정 가";
        String content = "111";
        ArticleForm dto = new ArticleForm(id, title, content);

        // 예상
        Article expected = new Article(id, title, content);

        // 실제
        Article article = articleService.update(id,dto);

        // 비교
        assertEquals(expected.toString(), article.toString());



    }

    @Test
    @Transactional
    void update_성공____존재하는_id_title만_있는_dto_입력() {
        Long id = 1L;
        String title = "수정 가";
        ArticleForm dto = new ArticleForm(id, title, null);

        // 예상
        Article expected = new Article(id, title, "11");

        // 실제
        Article article = articleService.update(id,dto);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void update_실패____존재하지않는_id의_dto_입력() {
        Long id = -1L;
        ArticleForm dto = new ArticleForm(id, null, null);

        // 예상
        Article expected = null;

        // 실제
        Article article = articleService.update(id,dto);

        // 비교
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void update_실패____id가_다른_dto_입력() {
        Long id = -1L;
        ArticleForm dto = new ArticleForm(1L, null, null);

        // 예상
        Article expected = null;

        // 실제
        Article article = articleService.update(id,dto);

        //비교
        assertEquals(expected,article);
    }

    @Test
    @Transactional
    void delete_성공____존재하는_id_입력() {
        Long id = 1L;
        String title = "가가";
        String content = "11";
        // 예상
        Article expected = new Article(id, title, content);

        // 실제
        Article article = articleService.delete(id);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void delete_실패____존재하지않는_id_입력() {
        Long id = -1L;

        // 예상
        Article expected = null;

        // 실제
        Article article = articleService.delete(id);

        // 비교
        assertEquals(expected,article);
    }
}