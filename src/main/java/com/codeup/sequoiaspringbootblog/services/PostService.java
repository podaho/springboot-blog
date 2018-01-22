package com.codeup.sequoiaspringbootblog.services;

import com.codeup.sequoiaspringbootblog.daos.PostsRepository;
import com.codeup.sequoiaspringbootblog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PostService {
    private PostsRepository postDao;

    public PostService(PostsRepository postDao) {
        this.postDao = postDao;
    }

    public Iterable<Post> all() {
        return postDao.findAll();
    }

    public Post retrievePostById(long id) {
        return postDao.findOne(id);
    }

    public Post edit(Post post) {
        postDao.save(post);
        return postDao.findOne(post.getId());
    }

    public Post save(Post post) {
        postDao.save(post);
        return postDao.findOne(post.getId());
    }

    public void delete(long id) {
        postDao.delete(id);
    }
}
