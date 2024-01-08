package com.example.movie.service.ifs;


import java.util.List;

import com.example.movie.vo.UserLoginRes;

public interface CommentService {
	
	public UserLoginRes create(String movie,String commentText);

	public UserLoginRes update(int commentIndex,String movie,String commentText);
	
	public UserLoginRes delete( List<Integer> numList );
	
	public UserLoginRes likeAndDislike(int commentIndex,int commentIndexOrder,String movie,int like,int dislike);

}
