package com.imooc.backstage.repository;

import com.imooc.backstage.domain.PaperUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaperUserRepository extends JpaRepository<PaperUser, Integer> {

}
