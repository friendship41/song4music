package com.friendship41.song4music.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController
{
    @RequestMapping(value = "/")
    public String goToIndexPage(Model model)
    {
        model.addAttribute("test","5555test");
        return "index.html";
    }

//    @Autowired
//    private MemberService memberService;
//
//    @RequestMapping(value = "/member/{id}")
//    public ResponseEntity<List<MusiclistMember>> goToIndexPage(@PathVariable("id") String mMemberId)
//    {
//        List<MusiclistMember> member = memberService.getMemberList();
//        return new ResponseEntity<List<MusiclistMember>>(member, HttpStatus.OK);
//    }
}
