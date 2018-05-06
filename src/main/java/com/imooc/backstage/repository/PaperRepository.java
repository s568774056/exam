package com.imooc.backstage.repository;

import com.imooc.backstage.domain.Paper;
import com.imooc.backstage.domain.Topic;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaperRepository extends JpaRepository<Paper, Integer> {


}
