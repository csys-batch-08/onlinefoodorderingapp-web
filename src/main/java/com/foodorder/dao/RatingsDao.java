package com.foodorder.dao;

import java.sql.SQLException;

import com.onlinefoodorder.model.Ratings;

public interface RatingsDao {
	public int insertRatings(Ratings rating) throws SQLException;
	public double fetchRating(int restarantid) throws SQLException;
}
