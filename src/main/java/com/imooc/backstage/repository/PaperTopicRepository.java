package com.imooc.backstage.repository;

import com.imooc.backstage.domain.PaperTopic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaperTopicRepository extends JpaRepository<PaperTopic, Integer> {

}
