package com.cmxy.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmxy.entity.Team;
@Repository
public interface TeamDao extends JpaRepository<Team, Long> {

	
}
