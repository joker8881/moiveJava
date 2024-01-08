package com.example.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie.service.ifs.MypageService;
import com.example.movie.vo.MypageReq;
import com.example.movie.vo.UserLoginRes;

@CrossOrigin(origins = "*")
@RestController
public class MypageController {
	
	@Autowired
	private MypageService mypageService;
	

	@PostMapping(value = "movie/mypage/create")
	public UserLoginRes create(@RequestBody MypageReq req) {
		return mypageService.create(req.getAccount(),req.getFavorit(),req.getWatchList(),req.getAccountMovieList());
	}
	
	@PostMapping(value = "movie/mypage/update")
	public UserLoginRes update(@RequestParam(value = "index") int index, @RequestBody MypageReq req) {
				return mypageService.update(req.getAccount(),req.getFavorit(),req.getWatchList(),req.getAccountMovieList());
	}

}
