package com.shopme.admin.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.shopme.common.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

	@Query("select u from User u where u.email = :email")
	public User getUserByEmail(@Param("email") String email);
	
	public Long countById(Integer id);
	
	@Query("update User u set u.enabled = ?2 where u.id = ?1")
	@Modifying
	public void updateEnabledStatus(Integer id, boolean enabled);
}
