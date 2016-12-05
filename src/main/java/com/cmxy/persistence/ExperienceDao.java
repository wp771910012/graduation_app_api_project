package com.cmxy.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmxy.entity.Experience;
@Repository
public interface ExperienceDao extends JpaRepository<Experience, Long> {
	public List<Experience> findByUid(Long uid);

}
