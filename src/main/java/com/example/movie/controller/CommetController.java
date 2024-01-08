package com.example.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie.service.ifs.CommentService;
import com.example.movie.service.ifs.MypageService;
import com.example.movie.vo.CommentReq;
import com.example.movie.vo.MypageReq;
import com.example.movie.vo.UserLoginRes;

@CrossOrigin(origins = "*")
@RestController
public class CommetController {
	
	@Autowired
	private CommentService commentService;
	

	@PostMapping(value = "movie/comment/create")
	public UserLoginRes create(@RequestBody CommentReq req) {
		return commentService.create(req.getMovie(),req.getCommentText());
	}
	
	@PostMapping(value = "movie/comment/update")
	public UserLoginRes update(@RequestParam(value = "index") int index, @RequestBody CommentReq req) {
				return commentService.update(index,req.getMovie(),req.getCommentText());
	}
	
	@PostMapping(value = "movie/comment/delete")
	public UserLoginRes delete(@RequestParam(value = "movieCommentIndex") List<Integer> index) {
		return commentService.delete(index);
	}
	
	@PostMapping(value = "movie/comment/likeAndDislike")
	public UserLoginRes likeAndDislike(@RequestParam(value = "movieCommentIndex") int index,@RequestParam(value = "movieCommentIndexOrder") int order, @RequestBody CommentReq req) {
				return commentService.likeAndDislike(index,order,req.getMovie(),req.getLike(),req.getDislike());
	}

}
