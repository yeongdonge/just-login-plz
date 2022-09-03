package justLogin.plz.service;

import justLogin.plz.domain.posts.Post;
import justLogin.plz.domain.posts.PostRepository;
import justLogin.plz.web.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public Long save(PostSaveRequestDto postSaveRequestDto) {
        return postRepository.save(
                Post.builder()
                        .title(postSaveRequestDto.getTitle())
                        .content(postSaveRequestDto.getContent())
                        .author(postSaveRequestDto.getAuthor())
                        .build()
        ).getId();
    }
}
