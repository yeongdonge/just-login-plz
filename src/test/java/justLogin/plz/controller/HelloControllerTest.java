package justLogin.plz.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    /**
     * MockMvc 기초 테스트
     */
    @Test
    @DisplayName("hello 리턴 MockMvc 기초 테스트")
    void return_hello() throws Exception
    {
        //given
        mvc.perform(get("/hello")
                        )
                //when
                .andExpect(status().isOk())
                //then
                .andExpect(content().string("hello"))
                .andDo(print());
    }

    /**
     * HelloDTO 리턴
     */
    @Test
    @DisplayName("HelloDTO 리턴")
    void return_helloDto() throws Exception
    {
        //given
        String name = "hello";
        int amount = 1000;
        //when
        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.amount").value(amount))
                .andDo(print());
        //then
    }



}