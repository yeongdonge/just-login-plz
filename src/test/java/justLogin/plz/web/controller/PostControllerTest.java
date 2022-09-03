package justLogin.plz.web.controller;

import justLogin.plz.domain.posts.Post;
import justLogin.plz.domain.posts.PostRepository;
import justLogin.plz.web.dto.PostSaveRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostRepository postRepository;

    @AfterEach
    void init() {
        postRepository.deleteAll();
    }

    @Test
    void POST_등록() throws Exception {
        //given
        String title = "제목";
        String content = "내용";
        String author = "Parrineau";

        PostSaveRequestDto saveRequestDto = PostSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();

        String url = "http://localhost:"+ port + "/api/v1/post";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, saveRequestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);


        List<Post> findPosts = postRepository.findAll();
        assertThat(findPosts.get(0).getTitle()).isEqualTo(title);
        assertThat(findPosts.get(0).getContent()).isEqualTo(content);


    }

}