package com.cmxy.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmxy.entity.UserCollection;
@Repository
public interface UserCollectionDao extends JpaRepository<UserCollection, Long> {
	public List<UserCollection> findByUidAndType(Long uid,Integer Type);
}
