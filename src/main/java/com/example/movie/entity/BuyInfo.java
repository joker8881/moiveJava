package com.example.movie.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movieinfo")
public class BuyInfo {
	
	@Id
	@Column(name = "order")
	private int order;
	
	@Column(name = "account")
	private String account;
	
	@Column(name = "cinema")
	private String cinema;
	
	@Column(name = "area")
	private String area;
	
	@Column(name = "movie")
	private String movie;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "on_date")
	private LocalDate date;
	
	@Column(name = "on_time")
	private String onTime;
	
	@Column(name = "seat")
	private String seat;

	public BuyInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BuyInfo(int order, String account, String cinema, String area, String movie, int price, LocalDate date,
			String onTime, String seat) {
		super();
		this.order = order;
		this.account = account;
		this.cinema = cinema;
		this.area = area;
		this.movie = movie;
		this.price = price;
		this.date = date;
		this.onTime = onTime;
		this.seat = seat;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCinema() {
		return cinema;
	}

	public void setCinema(String cinema) {
		this.cinema = cinema;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getOnTime() {
		return onTime;
	}

	public void setOnTime(String onTime) {
		this.onTime = onTime;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	
	
}
