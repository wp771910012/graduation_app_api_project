package com.cmxy.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmxy.entity.EmploymentSign;
@Repository
public interface EmploymentSignDao extends JpaRepository<EmploymentSign, Long> {

}
