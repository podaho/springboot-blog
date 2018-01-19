package com.codeup.sequoiaspringbootblog;

import com.codeup.sequoiaspringbootblog.models.Post;
import com.codeup.sequoiaspringbootblog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostsController {
    private PostService service;

    @Autowired
    public PostsController(PostService service) {
        this.service = service;
    }

    @GetMapping("/posts")
    public String getPostIndex(Model m) {
        List<Post> posts = service.all();
        m.addAttribute("postsArr", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getIndividualPost(@PathVariable String id, Model m) {
        Post post = service.retrievePostById(Long.parseLong(id));
        m.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String getCreatePostForm(Model m) {
        Post post = new Post();
        m.addAttribute("post", post);
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postNewPost(@ModelAttribute Post post) {
        service.save(post);
        return "redirect:/posts";
    }
}
