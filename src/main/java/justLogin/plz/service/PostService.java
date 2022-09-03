package justLogin.plz.service;

import justLogin.plz.domain.posts.Post;
import justLogin.plz.domain.posts.PostRepository;
import justLogin.plz.exception.PlzException;
import justLogin.plz.exception.PostNotFound;
import justLogin.plz.web.dto.PostResponseDto;
import justLogin.plz.web.dto.PostSaveRequestDto;
import justLogin.plz.web.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;


    @Transactional
    public Long save(PostSaveRequestDto postSaveRequestDto) {
        return postRepository.save(
                Post.builder()
                        .title(postSaveRequestDto.getTitle())
                        .content(postSaveRequestDto.getContent())
                        .author(postSaveRequestDto.getAuthor())
                        .build()
        ).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto updateRequestDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(PostNotFound::new);

        post.update(updateRequestDto.getTitle(), updateRequestDto.getContent());

        return id;
    }

    public PostResponseDto findById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(PostNotFound::new);

        return new PostResponseDto(post);
    }
}
