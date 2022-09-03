package justLogin.plz.web.controller;

import justLogin.plz.service.PostService;
import justLogin.plz.web.dto.PostResponseDto;
import justLogin.plz.web.dto.PostSaveRequestDto;
import justLogin.plz.web.dto.PostUpdateRequestDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping("/api/v1/post")
    public Long save(@RequestBody PostSaveRequestDto postSaveRequestDto) {
        return postService.save(postSaveRequestDto);
    }

    @PostMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto updateRequestDto) {
        return postService.update(id, updateRequestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostResponseDto findById(@PathVariable Long id) {
        return postService.findById(id);
    }
}
