package com.example.movie.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movie.entity.MovieInfo;

@Repository
public interface MovieInfoDAO extends JpaRepository<MovieInfo, String>{
	
	@Transactional
	public int deleteByOrder(int order);
	
	public Optional<MovieInfo> findByOrderAndMovieAndCinemaAndArea(int order,String movie,String cinema, String area);
	
	public Optional<MovieInfo> findAllByMovie(String movie);
	
	public List<MovieInfo> findByMovieNameContainingAndCinemaContainingAndAreaContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual(
			String movie, String cinema, String area, LocalDate startDate, LocalDate endDate);
	
}
