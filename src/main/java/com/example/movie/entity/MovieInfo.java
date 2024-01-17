package com.example.movie.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movieinfo")
public class MovieInfo {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "number")
	private int number;
	
	@Column(name = "movie_id")
	private int movieId;
	
	@Column(name = "movie_name")
	private String movie;
	
	@Column(name = "cinema")
	private String cinema;
	
	@Column(name = "area")
	private String area;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;

	@Column(name = "on_date")
	private LocalDate onDate;
	
	@Column(name = "on_time")
	private String onTime;
	


	public MovieInfo() {
		super();
		// TODO Auto-generated constructor stub
	}



	public MovieInfo(int number,int movieId, String movie, String cinema, String area, int price, LocalDate startDate,
			LocalDate endDate, LocalDate onDate, String onTime) {
		super();
		this.number = number;
		this.movieId = movieId;
		this.movie = movie;
		this.cinema = cinema;
		this.area = area;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.onDate = onDate;
		this.onTime = onTime;
	}
	
	public MovieInfo(String movie, String cinema, String area, int price, LocalDate startDate,
			LocalDate endDate, LocalDate onDate, String onTime) {
		super();
		this.movie = movie;
		this.cinema = cinema;
		this.area = area;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.onDate = onDate;
		this.onTime = onTime;
	}
	
	public MovieInfo(int movieId,String movie, String cinema, String area, int price, LocalDate startDate,
			LocalDate endDate, LocalDate onDate, String onTime) {
		super();
		this.movieId = movieId;
		this.movie = movie;
		this.cinema = cinema;
		this.area = area;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.onDate = onDate;
		this.onTime = onTime;
	}


	public int getNumber() {
		return number;
	}



	public void setNumber(int number) {
		this.number = number;
	}



	public String getMovie() {
		return movie;
	}



	public void setMovie(String movie) {
		this.movie = movie;
	}



	public String getCinema() {
		return cinema;
	}



	public void setCinema(String cinema) {
		this.cinema = cinema;
	}



	public String getArea() {
		return area;
	}



	public void setArea(String area) {
		this.area = area;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public LocalDate getStartDate() {
		return startDate;
	}



	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}



	public LocalDate getEndDate() {
		return endDate;
	}



	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}



	public LocalDate getOnDate() {
		return onDate;
	}



	public void setOnDate(LocalDate onDate) {
		this.onDate = onDate;
	}



	public String getOnTime() {
		return onTime;
	}



	public void setOnTime(String onTime) {
		this.onTime = onTime;
	}



	public int getMovieId() {
		return movieId;
	}



	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	
}
