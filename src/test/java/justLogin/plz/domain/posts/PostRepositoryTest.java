package justLogin.plz.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
        Assertions.assertThat(findPost.getTitle()).isEqualTo(title);
        Assertions.assertThat(findPost.getContent()).isEqualTo(content);
    }


}