package com.example.demo.controller;

import com.example.demo.domain.CommunityWriting;
import com.example.demo.service.WritingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommunityController {

    private final WritingService writingService;

    @Autowired
    public CommunityController(WritingService writingService) {
        this.writingService = writingService;
    }

    @GetMapping("/community/new")
    public String createForm(){
        return "community/createWritingForm";
    }

    @PostMapping("/community/new")
    public String create(WritingForm form) {
//    writingList
        CommunityWriting cw = new CommunityWriting();
        cw.setTitle(form.getTitle());
        cw.setContent(form.getContent());
        writingService.
    }
}

// 일단 웹사이트에서 돌아가는걸로 확인
