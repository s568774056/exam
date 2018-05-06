package com.imooc.backstage.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.imooc.backstage.domain.Api;
import com.imooc.backstage.domain.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
	
	int countByNameLike(String name);
	List<Subject> findByNameLikeOrderByIdDesc(String name,Pageable pageable);

}
