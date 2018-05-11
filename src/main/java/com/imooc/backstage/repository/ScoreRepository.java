package com.imooc.backstage.repository;

import com.imooc.backstage.domain.PaperUser;
import com.imooc.backstage.domain.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Integer> {

}
