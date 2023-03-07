package com.vvs.animelist.controllers;

import com.vvs.animelist.models.Post;
import com.vvs.animelist.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WatchedController {


    @GetMapping("/watched")
    public String watchedMain(Model model){
        return "watchedPage";
    }
}
