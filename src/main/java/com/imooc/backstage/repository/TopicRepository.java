package com.imooc.backstage.repository;

import com.imooc.backstage.domain.Topic;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

    int countByNameLikeAndType(String name, String type);

    List<Topic> findByNameLikeAndTypeOrderByIdDesc(String name, String type, Pageable pageable);

    int countByNameLike(String name);

    List<Topic> findByNameLikeOrderByIdDesc(String name, Pageable pageable);

    int countByNameLikeAndSubjectId(String name, String subjectId);

    List<Topic> findByNameLikeAndSubjectIdOrderByIdDesc(String name, String subjectId, Pageable pageable);

    int countByNameLikeAndTypeAndSubjectId(String name, String type, String subjectId);

    List<Topic> findByNameLikeAndTypeAndSubjectIdOrderByIdDesc(String name, String type, String subjectId, Pageable pageable);

    void deleteAllBySubjectId(String subjectId);
}
