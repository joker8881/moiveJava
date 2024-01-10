package com.example.movie.constant;

public enum RtnCode {
	SUCCESSFUL(200,"Successful!"),//
	PARAM_ERROR(400,"Param error!"),//
	ACCOUNT_NOT_FOUND(404,"Account not found!"),
	PASSWORD_NOT_FIT(400,"password not fit!"),
	DATE_FORMAT_ERROR(400,"Date format error!"),
	PAGE_NOT_FOUND(400,"Page not found!"),
	PAGE_CANNOT_BE_UPDATED(400,"Page cannot updated!"),
	PAGE_CREATE_ERROR(400,"Page create error!"),
	MOVIE_COMMENT_NOT_FOUND(400,"Movie comment not found!"),
	COMMENT_IS_NOT_EXSISTED(400,"Comment is not exsisted!"),
	COMMENT_TEXT_IS_NONE(400,"Comment text is none!"),
	ART_IS_NOT_FOUND(400,"Art is not found!"),
	ART_DLETE_ORDER_NOT_FOUND(400,"Art dlete order not found!"),
	DELETED_MOVIE_INFO_NOT_EXSISTED(400,"Deleted movie info not exsisted!"),
	CHECK_MOVIE_INPUT(400,"Check movie input"),
	CHECK_CINEMA_INPUT(400,"Check cinema input"),
	CHECK_AREA_INPUT(400,"Check area input"),
	CHECK_PRICE_INPUT(400,"Check price input"),
	CHECK_STARTDATE_INPUT(400,"Check startdate input"),
	CHECK_ENDDATE_INPUT(400,"Check enddate input"),
	CHECK_ONDATE_INPUT(400,"Check ondate input"),
	CHECK_ONTIME_INPUT(400,"Check ontime input"),
	ACCOUNT_EXISTED(400,"Account existed!");
	
	private int code;
	
	private String message;

	private RtnCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
	
	
}
