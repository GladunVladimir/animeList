package com.vvs.animelist.controllers;

import com.vvs.animelist.models.Post;
import com.vvs.animelist.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class WatchController {
    private final PostRepository postRepository;

    public WatchController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/watch")
    public String watchPage(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "watchPage";
    }

    @GetMapping("/add-title")
    public String addTitle(Model model){
        return "titleWatchAdd";
    }

    @PostMapping("/add-title")
    public String postAddTitle(@RequestParam String title, @RequestParam String season, Model model){
        Post post = new Post(title, season);
        postRepository.save(post);
        return "redirect:/watch";
    }

    @RequestMapping("/watch/{id}/remove")
    public String postDeleteTitle(@PathVariable(value = "id") long id, Model model){
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/watch";
    }


}
