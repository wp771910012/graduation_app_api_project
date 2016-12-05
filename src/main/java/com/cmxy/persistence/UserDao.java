package com.cmxy.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmxy.entity.User;
@Repository
public interface UserDao extends JpaRepository<User,Long>{
	public User findByPhone(Long phone);

}
