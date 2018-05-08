package com.imooc.backstage.repository;

import com.imooc.backstage.domain.Api;
import com.imooc.backstage.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

	int countByNameLike(String name);
	List<User> findByNameLikeOrderByIdDesc(String name, Pageable pageable);
}
