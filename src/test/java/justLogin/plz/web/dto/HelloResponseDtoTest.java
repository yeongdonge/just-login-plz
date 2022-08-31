package justLogin.plz.web.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloResponseDtoTest {

    /**
     * 롬복 테스트
     */
    @Test
    @DisplayName("롬복 테스트")
    void 롬복_테스트() throws Exception
    {
        //given
        String name = "test";
        int amount = 1000;
        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);
        //then
        Assertions.assertThat(dto.getAmount()).isEqualTo(amount);
        Assertions.assertThat(dto.getName()).isEqualTo(name);
    }


}