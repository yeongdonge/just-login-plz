package justLogin.plz.web.dto;

import justLogin.plz.domain.posts.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getAuthor();
        this.content = post.getContent();
        this.author = post.getAuthor();
    }
}
