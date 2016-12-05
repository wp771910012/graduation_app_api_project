package com.cmxy.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmxy.entity.Infomation;
@Repository
public interface InfomationDao extends JpaRepository<Infomation, Long> {

}
