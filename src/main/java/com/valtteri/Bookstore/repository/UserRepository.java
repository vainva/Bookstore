package com.valtteri.Bookstore.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.valtteri.Bookstore.bean.User;


public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
