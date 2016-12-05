package com.cmxy.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmxy.entity.Position;
@Repository
public interface PositionDao extends JpaRepository<Position, Long> {

}
