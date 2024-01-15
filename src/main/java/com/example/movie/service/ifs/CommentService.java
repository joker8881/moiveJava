package com.example.movie.service.ifs;

import com.example.movie.vo.UserLoginRes;

public interface CommentService {
	
	public UserLoginRes create(String movie,int movieID,String commentText,String account);
	
	public UserLoginRes createchild(int commentIndex,String movie,int movieID,String commentText,String account);

	public UserLoginRes update(int commentIndex,int commentIndexOrder,String movie,int movieID,String commentText,String account);
	
	public UserLoginRes delete(int commentIndex,int commentIndexOrder,int movieID);
	
	public UserLoginRes likeAndDislike(int commentIndex,int commentIndexOrder,int movieID,int like,int dislike);

}
