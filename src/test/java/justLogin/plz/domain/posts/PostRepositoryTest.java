package justLogin.plz.domain.posts;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@SpringBootTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @AfterEach
    void init() {
        postRepository.deleteAll();
    }

    /**
     * 게시글 저장 불러오기 기초 테스트
     */
    @Test
    @DisplayName("게시글 저장 후 불러오기")
    void 게시글저장_불러오기() throws Exception
    {
        //given
        String title = "제목";
        String content = "내용";

        Post post = Post.builder()
                .title(title)
                .content(content)
                .author("parrineau")
                .build();

        postRepository.save(post);
        //when
        List<Post> findPosts = postRepository.findAll();
        //then
        Post findPost = findPosts.get(0);
        assertThat(findPost.getTitle()).isEqualTo(title);
        assertThat(findPost.getContent()).isEqualTo(content);
    }

    /**
     * BaseTimeEntity 등록 후 확인 테스트
     */
    @Test
    @DisplayName("BaseTimeEntity 도입 테스트")
    void BaseTimeEntity_등록() throws Exception
    {
        //given
        LocalDateTime firstDate = LocalDateTime.of(2022, 6, 7, 0, 0, 0);
        postRepository.save(Post.builder()
                        .title("제목")
                        .content("내용")
                        .author("Parrineau")
                .build());

        //when

        String modifiedTitle = "제목2";
        String modifiedContent = "내용2";

        List<Post> posts = postRepository.findAll();
        Post post = posts.get(0);
        post.update(modifiedTitle, modifiedContent);
        postRepository.save(post);

        Post modifiedPost = postRepository.findById(post.getId()).get();


        //then
        log.info("modifiedTitle={}, modifiedContent={}", modifiedPost.getTitle(), modifiedPost.getContent());
        log.info("createdDate={}, modifiedDate={}", modifiedPost.getCreateDate(), modifiedPost.getMidifiedDate());

        assertThat(modifiedPost.getCreateDate()).isAfter(firstDate);
        assertThat(modifiedPost.getMidifiedDate()).isAfter(post.getCreateDate());


    }



}