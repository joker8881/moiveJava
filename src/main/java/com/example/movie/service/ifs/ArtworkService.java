package com.example.movie.service.ifs;


import java.util.List;

import com.example.movie.vo.UserLoginRes;

public interface ArtworkService {
	
	public UserLoginRes create(String movie,String account,String artname);

	public UserLoginRes update(int artorder,String movie,String account,String artname);
	
	public UserLoginRes delete(List<Integer> numList );
	
	public UserLoginRes search(String movie,String artname);

}
