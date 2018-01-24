package com.codeup.sequoiaspringbootblog.daos;

import com.codeup.sequoiaspringbootblog.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
}
