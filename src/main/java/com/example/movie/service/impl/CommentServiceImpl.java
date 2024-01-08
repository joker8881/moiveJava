package com.example.movie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.moive.entity.Comment;
import com.example.moive.entity.Mypage;
import com.example.moive.entity.User;
import com.example.movie.constant.RtnCode;
import com.example.movie.repository.CommentDAO;
import com.example.movie.repository.MypageDAO;
import com.example.movie.repository.UserDAO;
import com.example.movie.service.ifs.CommentService;
import com.example.movie.service.ifs.MypageService;
import com.example.movie.service.ifs.UserService;
import com.example.movie.vo.UserLoginRes;
import com.example.quiz.vo.QuizRes;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
	
    @Autowired
    private CommentDAO commentDao;

    @Override
    public UserLoginRes create(String movie,String commentText) {
        if (!StringUtils.hasText(commentText)) {
            return new UserLoginRes(RtnCode.COMMENT_TEXT_IS_NONE.getCode(),RtnCode.COMMENT_TEXT_IS_NONE.getMessage());
        }
        Optional<Comment> op = commentDao.findById(movie);
        Comment comment = op.get();
        if(comment.getCommentIndex() == 0) {
        	commentDao.save(new Comment(movie, 1, commentText));
        }
        int x = comment.getCommentIndex() + 1 ;
        
        commentDao.save(new Comment(movie, x, commentText));
        return new UserLoginRes(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage());
    }

	@Override
	public UserLoginRes update(int commentIndex, String movie, String commentText) {
		Optional<Comment> op = commentDao.findById(movie);
		if (op.isEmpty()){
			return new UserLoginRes(RtnCode.MOVIE_COMMENT_NOT_FOUND.getCode(),RtnCode.MOVIE_COMMENT_NOT_FOUND.getMessage());
		}
		Comment comment = op.get();
		if(comment.getCommentIndex() != commentIndex) {
			return new UserLoginRes(RtnCode.MOVIE_COMMENT_NOT_FOUND.getCode(),RtnCode.MOVIE_COMMENT_NOT_FOUND.getMessage());
		}
		if(StringUtils.hasText(commentText)){
			comment.setCommentText(commentText);
		}
		try {
			commentDao.save(new Comment(movie,commentIndex,commentText));
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
		commentDao.deleteAllById(numList);
		return new UserLoginRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public UserLoginRes likeAndDislike(int commentIndex, int commentIndexOrder, String movie, int like, int dislike) {
        Optional<Comment> op = commentDao.findById(movie);
        Comment comment = op.get();
        if(comment.getCommentIndex() != commentIndex) {
        	return new UserLoginRes(RtnCode.COMMENT_IS_NOT_EXSISTED.getCode(), RtnCode.COMMENT_IS_NOT_EXSISTED.getMessage());
        }
        if(comment.getCommentIndexOrder() !=commentIndexOrder) {
        	return new UserLoginRes(RtnCode.COMMENT_IS_NOT_EXSISTED.getCode(), RtnCode.COMMENT_IS_NOT_EXSISTED.getMessage());
        }
        int likeNew = comment.getLike() + like;
        int dislikeNew = comment.getDislike() + dislike;
        commentDao.save(new Comment(movie,commentIndex,commentIndexOrder, likeNew, dislikeNew));
        
        return new UserLoginRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());
	}


}
