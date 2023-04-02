package com.vvs.animelist.controllers;

import com.vvs.animelist.models.DeletedPost;
import com.vvs.animelist.models.Post;
import com.vvs.animelist.repo.DeletedPostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WatchedController {

    private final DeletedPostRepository deletedPostRepository;


    public WatchedController(DeletedPostRepository deletedPostRepository) {
        this.deletedPostRepository = deletedPostRepository;
    }


    @GetMapping("/watched")
    public String watchedPage(Model model) {
        Iterable<DeletedPost> posts = deletedPostRepository.findAll();
        model.addAttribute("posts", posts);
        return "WatchedPage";
    }

    @PostMapping("/watched/{id}/remove")
    public String postDeleteTitle(@PathVariable(value = "id") long id, Model model){
        DeletedPost delPost = deletedPostRepository.findById(id).orElseThrow();
        deletedPostRepository.delete(delPost);
        return "redirect:/watched";
    }
}
