package com.example.demo.controller;

import com.example.demo.domain.CommunityWriting;
import com.example.demo.service.WritingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
        CommunityWriting cw = new CommunityWriting();
        cw.setTitle(form.getTitle());
        cw.setContent(form.getContent());
        writingService.createWriting(cw);
        return "redirect:/";
    }

    @GetMapping("/community")
    public String list(Model model){
        List<CommunityWriting> writings = writingService.findAllWritings();
        model.addAttribute("writings",writings);
        return "community/writingList";
    }

    @RequestMapping("/android")
    public void androidTestWithRequest(HttpServletRequest request){
        System.out.println(request.getParameter("title"));
        System.out.println(request.getParameter("content"));
    }

}

