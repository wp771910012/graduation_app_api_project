package com.cmxy.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmxy.entity.Matter;
@Repository
public interface MatterDao extends JpaRepository<Matter, Long> {
	public List<Matter> findBySender(Long sender);
	public List<Matter> findByReciverLike(String reciver);

}
