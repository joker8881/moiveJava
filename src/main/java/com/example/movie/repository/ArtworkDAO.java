package com.example.movie.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.moive.entity.Artwork;
import com.example.moive.entity.Comment;
import com.example.quiz.entity.Quiz;

@Repository
public interface ArtworkDAO extends JpaRepository<Artwork, String>{
	
    public List<Artwork> findByName
    (String searchName, String searchArtName);

}
