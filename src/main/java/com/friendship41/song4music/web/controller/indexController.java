package com.friendship41.song4music.web.controller;

import com.friendship41.song4music.repository.entity.Member;
import com.friendship41.song4music.repository.entity.MusicList;
import com.friendship41.song4music.web.service.MusicListService;
import com.friendship41.song4music.web.service.PageBlockService;
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
    @Autowired
    private PageBlockService pageBlockService;

    @RequestMapping(value = "/")
    public String goToIndexPage(@PageableDefault(sort = "mListSeq", direction = Sort.Direction.DESC, size = 10) Pageable page, HttpSession session, Model model)
    {
        Member member = (Member)session.getAttribute("member");
        Page<MusicList> musicListPage = webMusicListService.getMusicList(member.getMMemberId(), page);
        model.addAttribute("musicListPage", musicListPage);
        model.addAttribute("nowPage", page.getPageNumber());
        model.addAttribute("prevPage", page.getPageNumber()-1);
        model.addAttribute("nextPage", page.getPageNumber()+1);
        model.addAttribute("startBlock", pageBlockService.getStartBlockNum(musicListPage));
        model.addAttribute("endBlock", pageBlockService.getEndBlockNum(musicListPage));
        System.out.println(model.getAttribute("startBlock")+" / "+model.getAttribute("endBlock"));
        return "index.html";
    }
}
