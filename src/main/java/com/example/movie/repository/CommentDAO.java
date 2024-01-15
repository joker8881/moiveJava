package com.example.movie.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movie.entity.Comment;

@Repository
public interface CommentDAO extends JpaRepository<Comment, String>{
	
	@Transactional
	public int deleteByCommentIndexAndCommentIndexOrderAndMovieID(int commentIndex,int commentIndexOrder, int movieID);
	
	public Optional<Comment> findByCommentIndexAndCommentIndexOrderAndMovieID(int commentIndex,int commentIndexOrder, int movieID);
	
	public Optional<Comment> findAllByMovieID(int movieID);
	
	public Optional<Comment> findTopByMovieAndCommentIndexOrderByCommentIndexOrderDesc(int movieID, int commentIndex);
	
}
