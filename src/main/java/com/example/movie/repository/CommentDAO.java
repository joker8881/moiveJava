package com.example.movie.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movie.entity.Comment;

@Repository
public interface CommentDAO extends JpaRepository<Comment, String>{
	
	@Transactional
	public int deleteByCommentIndexAndCommentIndexIndexAndMovieID(int commentIndex,int commentIndexIndex, int movieID);
	
	public int deleteByCommentIndexAndMovieID(int commentIndex, int movieID);
	
	public Optional<Comment> findByCommentIndexAndCommentIndexIndexAndMovieID(int commentIndex,int commentIndexIndex, int movieID);
	
	public Optional<Comment> findTopByMovieIDOrderByCommentIndexDesc(int movieID);
	
	public Optional<Comment> findTopByMovieIDAndCommentIndexOrderByCommentIndexIndexDesc(int movieID, int commentIndex);
	
	public List<Comment> findAllByMovieID(int movieID);
	
}
