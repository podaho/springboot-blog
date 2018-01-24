package com.codeup.sequoiaspringbootblog;

import com.codeup.sequoiaspringbootblog.daos.PostsRepository;
import com.codeup.sequoiaspringbootblog.daos.UsersRepository;
import com.codeup.sequoiaspringbootblog.models.Post;
import com.codeup.sequoiaspringbootblog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostsController {
    private PostsRepository postDao;
    private UsersRepository userDao;

    @Autowired
    public PostsController(PostsRepository postDao, UsersRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String getPostIndex(Model m) {
        Iterable<Post> posts = postDao.findAll();
        m.addAttribute("postsArr", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getIndividualPost(@PathVariable long id, Model m) {
        Post post = postDao.findOne(id);
        m.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String editIndividualPost(@PathVariable long id, Model m) {
        Post post = postDao.findOne(id);
        m.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String postEditPost(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String getCreatePostForm(Model m) {
        Post post = new Post();
        m.addAttribute("post", post);
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postNewPost(@ModelAttribute Post post) {
        post.setUser(userDao.findOne((long)3));
        postDao.save(post);
        return "redirect:/posts";
    }

    //Should use Post but Post will need the delete button to be in a form, since anchor tags will default on get methods
    @GetMapping("/posts/{id}/delete")
    public String removePost(@PathVariable long id) {
        postDao.delete(id);
        return "redirect:/posts";
    }
}
