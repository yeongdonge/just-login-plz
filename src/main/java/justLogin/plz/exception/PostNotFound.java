package justLogin.plz.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PostNotFound extends PlzException {
    private static final String error = "존재하지 않는 게시글입니다.";

    public PostNotFound() {
        super(error);
        log.error(error);
    }

    @Override
    public int getStatusCode() {
        return 400;
    }
}
