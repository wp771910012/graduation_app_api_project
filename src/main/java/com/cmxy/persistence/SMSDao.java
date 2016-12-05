package com.cmxy.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmxy.entity.SMS;
@Repository
public interface SMSDao extends JpaRepository<SMS, Long> {
	public SMS findByPhone(Long phone);

}
