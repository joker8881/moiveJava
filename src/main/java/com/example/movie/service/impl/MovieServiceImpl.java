package com.example.movie.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.movie.constant.RtnCode;
import com.example.movie.entity.MovieInfo;
import com.example.movie.repository.MovieInfoDAO;
import com.example.movie.service.ifs.MovieInfoService;
import com.example.movie.vo.MovieInfoGetRes;
import com.example.movie.vo.UserLoginRes;

@Service
public class MovieServiceImpl implements MovieInfoService {
	
    @Autowired
    private MovieInfoDAO movieInfoDao;

    @Override
    public UserLoginRes create(String movie, String cinema, String area, int price,
			LocalDate startDate, LocalDate endDate, LocalDate onDate, String time) {
        if (!StringUtils.hasText(movie)) {
            return new UserLoginRes(RtnCode.CHECK_MOVIE_INPUT.getCode(),RtnCode.CHECK_MOVIE_INPUT.getMessage());
        }
        if (!StringUtils.hasText(cinema)) {
            return new UserLoginRes(RtnCode.CHECK_CINEMA_INPUT.getCode(),RtnCode.CHECK_CINEMA_INPUT.getMessage());
        }
        if (!StringUtils.hasText(area)) {
            return new UserLoginRes(RtnCode.CHECK_AREA_INPUT.getCode(),RtnCode.CHECK_AREA_INPUT.getMessage());
        }
        if (price==0) {
            return new UserLoginRes(RtnCode.CHECK_PRICE_INPUT.getCode(),RtnCode.CHECK_PRICE_INPUT.getMessage());
        }
        if (startDate==null) {
            return new UserLoginRes(RtnCode.CHECK_STARTDATE_INPUT.getCode(),RtnCode.CHECK_STARTDATE_INPUT.getMessage());
        }
        if (endDate==null) {
            return new UserLoginRes(RtnCode.CHECK_ENDDATE_INPUT.getCode(),RtnCode.CHECK_ENDDATE_INPUT.getMessage());
        }
        if (onDate==null) {
            return new UserLoginRes(RtnCode.CHECK_ONDATE_INPUT.getCode(),RtnCode.CHECK_ONDATE_INPUT.getMessage());
        }
        if (!StringUtils.hasText(time)) {
            return new UserLoginRes(RtnCode.CHECK_ONTIME_INPUT.getCode(),RtnCode.CHECK_ONTIME_INPUT.getMessage());
        }

        movieInfoDao.save(new MovieInfo(movie,cinema,area,price,startDate,endDate,onDate,time));
        
        return new UserLoginRes(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage());
    }
    
	@Override
	public UserLoginRes update(int order,String movie, String cinema, String area, int price,
			LocalDate startDate, LocalDate endDate, LocalDate onDate, String time) {
        if (!StringUtils.hasText(movie)) {
            return new UserLoginRes(RtnCode.CHECK_MOVIE_INPUT.getCode(),RtnCode.CHECK_MOVIE_INPUT.getMessage());
        }
        if (!StringUtils.hasText(cinema)) {
            return new UserLoginRes(RtnCode.CHECK_CINEMA_INPUT.getCode(),RtnCode.CHECK_CINEMA_INPUT.getMessage());
        }
        if (!StringUtils.hasText(area)) {
            return new UserLoginRes(RtnCode.CHECK_AREA_INPUT.getCode(),RtnCode.CHECK_AREA_INPUT.getMessage());
        }
        if (price==0) {
            return new UserLoginRes(RtnCode.CHECK_PRICE_INPUT.getCode(),RtnCode.CHECK_PRICE_INPUT.getMessage());
        }
        if (startDate==null) {
            return new UserLoginRes(RtnCode.CHECK_STARTDATE_INPUT.getCode(),RtnCode.CHECK_STARTDATE_INPUT.getMessage());
        }
        if (endDate==null) {
            return new UserLoginRes(RtnCode.CHECK_ENDDATE_INPUT.getCode(),RtnCode.CHECK_ENDDATE_INPUT.getMessage());
        }
        if (onDate==null) {
            return new UserLoginRes(RtnCode.CHECK_ONDATE_INPUT.getCode(),RtnCode.CHECK_ONDATE_INPUT.getMessage());
        }
        if (!StringUtils.hasText(time)) {
            return new UserLoginRes(RtnCode.CHECK_ONTIME_INPUT.getCode(),RtnCode.CHECK_ONTIME_INPUT.getMessage());
        }
        Optional<MovieInfo> op = movieInfoDao.findByOrderAndMovieAndCinemaAndArea(order,movie,cinema,area);
        MovieInfo movieinfo = op.get();
		try {
			movieinfo.setMovieName(movie);
			movieinfo.setCinema(cinema);
			movieinfo.setArea(area);
			movieinfo.setPrice(price);
			movieinfo.setStartDate(startDate);
			movieinfo.setEndDate(endDate);
			movieinfo.setOnDate(onDate);
			movieinfo.setOnTime(time);
			movieInfoDao.save(movieinfo);
		} catch (Exception e) {
			return new UserLoginRes(RtnCode.PAGE_CREATE_ERROR.getCode(), RtnCode.PAGE_CREATE_ERROR.getMessage());
		}
        return new UserLoginRes(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage());
	}


	@Override
	public UserLoginRes delete(int order) {
		int res = movieInfoDao.deleteByOrder(order);
		if(res == 0) {
			return new UserLoginRes(RtnCode.DELETED_MOVIE_INFO_NOT_EXSISTED.getCode(), RtnCode.DELETED_MOVIE_INFO_NOT_EXSISTED.getMessage());
		}else {
			return new UserLoginRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());
		}
	}

	@Override
	public UserLoginRes search(String movie, String cinema, String area, 
			LocalDate startDate, LocalDate endDate) {
		movie = !StringUtils.hasText(movie) ? "" : movie;
		cinema = !StringUtils.hasText(cinema) ? "" : cinema;
		area = !StringUtils.hasText(area) ? "" : area;
		startDate = startDate== null ? LocalDate.of(1970,01,01) : startDate;
		endDate = endDate == null ? LocalDate.of(2099,12,31) : endDate;
		List<MovieInfo> res = new ArrayList<>();
			res = movieInfoDao.findByMovieNameContainingAndCinemaContainingAndAreaContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual(movie,cinema,area,startDate,endDate);
				return new MovieInfoGetRes(RtnCode.SUCCESSFUL.getCode(),
						RtnCode.SUCCESSFUL.getMessage(),res);

		
	}

}
