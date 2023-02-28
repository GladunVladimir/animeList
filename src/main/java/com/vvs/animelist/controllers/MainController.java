package com.vvs.animelist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/watch")
    public String watchPage(Model model) {
        model.addAttribute("title", "AnimeList/watch");
        return "watchPage";
    }

//    @GetMapping("/watched")
//    public String watchedPage(Model model) {
//        model.addAttribute("title", "AnimeList/watched");
//        return "watchedPage";
//    }

}
