package com.codeup.sequoiaspringbootblog;

import com.codeup.sequoiaspringbootblog.models.Post;
import com.codeup.sequoiaspringbootblog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostsController {
    private PostService service;

    public PostsController(PostService service) {
        this.service = service;
    }

    @GetMapping("/post")
    public String getPostIndex(Model m) {
        List<Post> posts = service.all();
        m.addAttribute("postsArr", posts);
        return "posts/index";
    }

    @GetMapping("/post/{id}")
    public String getIndividualPost(@PathVariable String id, Model m) {
        Post post = service.retrievePostById(Long.parseLong(id));
        m.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/post/create")
    @ResponseBody
    public String getCreatePostForm() {
        return "view the form for creating a post";
    }

    @PostMapping("/post/create")
    @ResponseBody
    public String postNewPost() {
        return "create a new post";
    }
}
