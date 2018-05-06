package com.imooc.backstage.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.imooc.backstage.domain.Api;

public interface ApiRepository extends JpaRepository<Api, Integer> {
	
	int countByNameLikeAndAddressLike(String name,String address);
	List<Api> findByNameLikeAndAddressLikeOrderByIdDesc(String name,String address,Pageable pageable);

	/*  @Query("select * from api WHERE toid = #{userId} GROUP BY formid ORDER BY created_date desc limit #{offset}, #{limit}")
    List<Api> selectConversationList(@Param("userId") String userId, @Param("offset") int offset, @Param("limit") int limit);
*/
	
	//原生SQL实现更新方法接口
	/*@Query(value = "update api set name=?1 where id=?2 ", nativeQuery = true)  
	@Modifying
	public void updateOne(Api api); */
}
