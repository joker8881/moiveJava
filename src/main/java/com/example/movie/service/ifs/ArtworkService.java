package com.example.movie.service.ifs;

import com.example.movie.vo.UserLoginRes;

public interface ArtworkService {
	
	public UserLoginRes create(String movie,int movieId,String account,String artname,String artLocation);

	public UserLoginRes update(int artorder,String artname,String artLocation);
	
	public UserLoginRes delete(int artorder);
	
	public UserLoginRes search(String movie,int movieId,String artname);

}
