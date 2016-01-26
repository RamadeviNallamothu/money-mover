package com.pivotal.brighton.Data;

import com.pivotal.brighton.Data.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    public User findByUserName(String userName);
}
