package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Ratings;

public interface RatingRepo extends JpaRepository<Ratings, String> {
	
	
}
