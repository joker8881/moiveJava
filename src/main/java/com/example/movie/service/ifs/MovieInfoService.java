package com.example.movie.service.ifs;

import java.time.LocalDate;

import com.example.movie.vo.UserLoginRes;

public interface MovieInfoService {
	
	public UserLoginRes create(String movie, String cinema, String area, int price,
			LocalDate startDate, LocalDate endDate, LocalDate onDate, String time);

	public UserLoginRes update(int order, String movie, String cinema, String area, int price,
			LocalDate startDate, LocalDate endDate, LocalDate onDate, String time);
	
	public UserLoginRes delete(int order);
	
	public UserLoginRes search(String movie, String cinema, String area, 
			LocalDate startDate, LocalDate endDate);

}
