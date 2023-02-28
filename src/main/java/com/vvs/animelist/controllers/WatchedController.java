package com.vvs.animelist.controllers;

import com.vvs.animelist.models.Post;
import com.vvs.animelist.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WatchedController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/watched")
    public String watchedMain(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "watchedPage";
    }
}
