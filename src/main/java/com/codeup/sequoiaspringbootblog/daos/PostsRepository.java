package com.codeup.sequoiaspringbootblog.daos;

import com.codeup.sequoiaspringbootblog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostsRepository extends CrudRepository<Post, Long> {
}
