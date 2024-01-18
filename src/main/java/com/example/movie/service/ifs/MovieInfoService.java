package com.example.movie.service.ifs;

import java.time.LocalDate;

import com.example.movie.vo.UserLoginRes;

public interface MovieInfoService {
	
	public UserLoginRes create(int movieId, String movie, String cinema, String area, int price,
			LocalDate onDate, String time);

	public UserLoginRes update(int number,int movieId, String movie, String cinema, String area, int price,
			LocalDate onDate, String time);
	
	public UserLoginRes delete(int number);
	
	public UserLoginRes search(int movieId,String movie, String cinema, String area, 
			LocalDate startDate, LocalDate endDate);

}
