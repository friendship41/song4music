package com.friendship41.song4music.web.controller;

import com.friendship41.song4music.web.service.MusicService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MusicController.class)
@Slf4j
class MusicControllerTest
{
    @Autowired
    private MockMvc mvc;

    @Autowired
    @Qualifier("WebMusicService")
    private MusicService webMusicService;

    @Test
    void getMusics() throws Exception
    {
        ResultActions actions =
                mvc.perform(get("/musics?mListSeq=1")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andDo(print());

        actions.andExpect(status().isOk()).andExpect(content()
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }
}
