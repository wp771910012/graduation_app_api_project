package com.cmxy.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmxy.entity.Comment;
@Repository
public interface CommentDao extends JpaRepository<Comment, Long> {
	public List<Comment> findByMid(Long mid);
	public List<Comment> findByUid(Long uid);
}
