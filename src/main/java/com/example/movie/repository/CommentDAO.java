package com.example.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.moive.entity.Comment;

@Repository
public interface CommentDAO extends JpaRepository<Comment, String>{
	

}
