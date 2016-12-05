package com.cmxy.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmxy.entity.School;
@Repository
public interface SchoolDao extends JpaRepository<School, Long> {

}
