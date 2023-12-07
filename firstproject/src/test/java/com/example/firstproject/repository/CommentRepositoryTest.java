package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // JPA와 연동한 테스트
class CommentRepositoryTest {

    @Autowired CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        /* Case 1: 4번 게시글의 모든 댓글 조회 */
        {
            // 입력 데이터 준비
            Long articleId = 1L;
            // 실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            // 예상하기
            Article article = new Article(4L, "돈까스", "댓글 ㄱ");
            Comment a = new Comment(1L, article, "Park", "샐드");
            Comment b = new Comment(2L, article, "Kim", "김치");
            Comment c = new Comment(3L, article, "Choi", "인석");
            List<Comment> expected = Arrays.asList(a,b,c);
            // 검증
            assertEquals(expected.toString(), comments.toString(), "4번 글의 모든 댓글을 출력!");
        }
        /* Case 2: 1번 게시글의 모든 댓글 조회 */
        {
            // 입력 데이터 준비
            Long articleId = 1L;
            // 실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            // 예상하기
            Article article = new Article(1L, "가가", "11");

            List<Comment> expected = Arrays.asList();
            // 검증
            assertEquals(expected.toString(), comments.toString(), "1번 글의 댓글은 없음");
        }
        /* Case 3: 9번 게시글의 모든 댓글 조회 */
        {

        }
        /* Case 4: 9999번 게시글의 모든 댓글 조회 */
        {

        }
        /* Case 5: -1번 게시글의 모든 댓글 조회 */
        {

        }
    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        /* Case 5: "Park"의 모든 댓글 조회 */
        {
            // 입력 데이터를 준비
            String nickname = "Park";
            // 실제 수행
            List<Comment> comments = commentRepository.findByNickname(nickname);
            // 예상하기
            Comment a = new Comment(1L, new Article(4L,"돈까스","댓글 ㄱ"), nickname, "샐드");
            Comment b = new Comment(4L, new Article(5L,"피자","댓글 ㄱㄱ"), nickname, "사라다");
            Comment c = new Comment(7L, new Article(6L,"햄복어","댓글 ㄱㄱㄱ"), nickname, "샐러드");
            List<Comment> expected = Arrays.asList(a,b,c);
            // 검증
            assertEquals(expected.toString(), comments.toString(), "Park의 모든 댓글 출력");
        }

        /* Case 6: "Park"의 모든 댓글 조회 */
        {}
        /* Case 7: null의 모든 댓글 조회 */
        {}
        /* Case 8: "i"의 모든 댓글 조회 */
        {}
    }
}