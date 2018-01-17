package com.codeup.sequoiaspringbootblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostsController {
    @GetMapping("/post")
    @ResponseBody
    public String getPostIndex() {
        return "post index page";
    }

    @GetMapping("/post/{id}")
    @ResponseBody
    public String getIndividualPost(@PathVariable String id) {
        return "view an individual post where id="+id;
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
