package com.example.movie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.moive.entity.Artwork;
import com.example.moive.entity.Comment;
import com.example.moive.entity.Mypage;
import com.example.moive.entity.User;
import com.example.movie.constant.RtnCode;
import com.example.movie.repository.ArtworkDAO;
import com.example.movie.repository.CommentDAO;
import com.example.movie.repository.MypageDAO;
import com.example.movie.repository.UserDAO;
import com.example.movie.service.ifs.ArtworkService;
import com.example.movie.service.ifs.CommentService;
import com.example.movie.service.ifs.MypageService;
import com.example.movie.service.ifs.UserService;
import com.example.movie.vo.ArtworkGetRes;
import com.example.movie.vo.UserLoginRes;
import com.example.quiz.entity.Quiz;
import com.example.quiz.vo.QuizGetRes;
import com.example.quiz.vo.QuizRes;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtworkServiceImpl implements ArtworkService {
	
    @Autowired
    private ArtworkDAO artworkDao;

    @Override
    public UserLoginRes create(String movie,String account,String artname) {
        if (!StringUtils.hasText(movie)) {
            return new UserLoginRes(RtnCode.PARAM_ERROR.getCode(),RtnCode.PARAM_ERROR.getMessage());
        }
        if (!StringUtils.hasText(account)) {
            return new UserLoginRes(RtnCode.PARAM_ERROR.getCode(),RtnCode.PARAM_ERROR.getMessage());
        }
        Optional<Artwork> op = artworkDao.findById(account);
        Artwork comment = op.get();
        if(comment.getArtOrder() == 0) {
        	artworkDao.save(new Artwork(movie, account, 1, artname));
        }
        int x = comment.getArtOrder() + 1 ;
        
        artworkDao.save(new Artwork(movie, account, x, artname));
        return new UserLoginRes(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage());
    }

	@Override
	public UserLoginRes update(int artorder, String movie, String account,String artname) {
		Optional<Artwork> op = artworkDao.findById(account);
		if (op.isEmpty()){
			return new UserLoginRes(RtnCode.ART_IS_NOT_FOUND.getCode(),RtnCode.ART_IS_NOT_FOUND.getMessage());
		}
		Artwork comment = op.get();
		if(comment.getArtOrder() != artorder) {
			return new UserLoginRes(RtnCode.ART_IS_NOT_FOUND.getCode(),RtnCode.ART_IS_NOT_FOUND.getMessage());
		}
		try {
			artworkDao.save(new Artwork(movie,account,artorder,artname));
		} catch (JsonProcessingException e) {
			return new UserLoginRes(RtnCode.PAGE_CREATE_ERROR.getCode(), RtnCode.PAGE_CREATE_ERROR.getMessage());
		}
		return new UserLoginRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public UserLoginRes delete(List<Integer> numList) {
		if(CollectionUtils.isEmpty(numList)){
			return new UserLoginRes(RtnCode.COMMENT_IS_NOT_EXSISTED.getCode(), RtnCode.COMMENT_IS_NOT_EXSISTED.getMessage());
		}
		artworkDao.deleteAllById(numList);
		return new UserLoginRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public UserLoginRes search(String movie,String artname) {
		movie = !StringUtils.hasText(movie) ? "" : movie;
		artname = !StringUtils.hasText(artname) ? "" : artname;
		List<Artwork> res = new ArrayList<>();
			res = artworkDao.findByName(movie,artname);
		 	return new ArtworkGetRes(RtnCode.SUCCESSFUL.getCode(),
					RtnCode.SUCCESSFUL.getMessage(),res);
		}


}
