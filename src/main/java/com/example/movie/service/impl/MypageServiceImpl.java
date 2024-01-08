package com.example.movie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.moive.entity.Mypage;
import com.example.movie.constant.RtnCode;
import com.example.movie.repository.MypageDAO;
import com.example.movie.service.ifs.MypageService;
import com.example.movie.vo.UserLoginRes;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Optional;

@Service
public class MypageServiceImpl implements MypageService {
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    private MypageDAO mypageDao;

    @Override
    public UserLoginRes create(String account,String favorit,String watchList, String accountMovieList) {
        if (!StringUtils.hasText(account)) {
            return new UserLoginRes(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage());
        }

        mypageDao.save(new Mypage(account, favorit,watchList,accountMovieList));

        return new UserLoginRes(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage());
    }

	@Override
	public UserLoginRes update(String account,String favorit,String watchList, String accountMovieList) {
		Optional<Mypage> op = mypageDao.findById(account);
		if (op.isEmpty()){
			return new UserLoginRes(RtnCode.PAGE_NOT_FOUND.getCode(),RtnCode.PAGE_NOT_FOUND.getMessage());
		}
		Mypage mypage = op.get();
		if(StringUtils.hasText(favorit)){
			mypage.setFavorit(favorit);
		}
		if (StringUtils.hasText(watchList)){
			mypage.setWatchList(watchList);
		}
		if (StringUtils.hasText(accountMovieList)){
			mypage.setAccountMovieList(accountMovieList);
		}
		try {
			mypageDao.save(new Mypage(account,favorit,watchList,accountMovieList));
		} catch (JsonProcessingException e) {
			return new UserLoginRes(RtnCode.PAGE_CREATE_ERROR.getCode(), RtnCode.PAGE_CREATE_ERROR.getMessage());
		}
		return new UserLoginRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());
	}


}
