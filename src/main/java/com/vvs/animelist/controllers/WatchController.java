package com.vvs.animelist.controllers;

import com.vvs.animelist.models.DeletedPost;
import com.vvs.animelist.models.Post;
import com.vvs.animelist.repo.DeletedPostRepository;
import com.vvs.animelist.repo.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WatchController {
    private final PostRepository postRepository;
    private final DeletedPostRepository deletedPostRepository;

    public WatchController(PostRepository postRepository, DeletedPostRepository deletedPostRepository) {
        this.postRepository = postRepository;
        this.deletedPostRepository = deletedPostRepository;
    }

    @GetMapping("/watch")
    public String watchPage(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "WatchPage";
    }

    @GetMapping("/add-title")
    public String addTitle(Model model){
        return "WatchAdd";
    }

    @PostMapping("/add-title")
    public String postAddTitle(@RequestParam String title, @RequestParam String season, Model model){
        Post post = new Post(title, season);
        postRepository.save(post);
        return "redirect:/watch";
    }

    @PostMapping("/watch/{id}/remove")
    public String postDeleteTitle(@PathVariable(value = "id") long id, Model model){
        Post post = postRepository.findById(id).orElseThrow();
        DeletedPost delPost = new DeletedPost(post.getTitle(), post.getSeason());
        deletedPostRepository.save(delPost);
        postRepository.delete(post);
        return "redirect:/watch";
    }


}
