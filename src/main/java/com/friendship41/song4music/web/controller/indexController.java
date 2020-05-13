package com.friendship41.song4music.web.controller;

import com.friendship41.song4music.repository.entity.Member;
import com.friendship41.song4music.repository.entity.MusicList;
import com.friendship41.song4music.web.data.BlockedPage;
import com.friendship41.song4music.web.service.MusicListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class indexController
{
    @Autowired
    @Qualifier("WebMusicListService")
    private MusicListService webMusicListService;

    @RequestMapping(value = "/")
    public String goToIndexPage(@PageableDefault(sort = "mListSeq", direction = Sort.Direction.DESC, size = 10) Pageable page, HttpSession session, Model model)
    {
        Member member = (Member)session.getAttribute("member");
        Page<MusicList> musicListPage = webMusicListService.getMusicList(member.getMMemberId(), page);
        BlockedPage blockedPage = new BlockedPage(musicListPage);
        model.addAttribute("musicPage", blockedPage);
        return "index.html";
    }
}
