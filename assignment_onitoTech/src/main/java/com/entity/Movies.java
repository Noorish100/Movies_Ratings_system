package com.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movies {
	
	@Id
	private String tconst;
	private String titleType;
	private String primaryTitle;
	private Integer runtimeMinutes;
	private String genres;
	@OneToOne(cascade = CascadeType.ALL)
	private Ratings rating;
	
	public Movies(String tconst, String primaryTitle, Integer runtimeMinutes, String genres) {
		super();
		this.tconst = tconst;
		this.primaryTitle = primaryTitle;
		this.runtimeMinutes = runtimeMinutes;
		this.genres = genres;
	}
	
	public Movies(String tconst, String titleType, String primaryTitle, Integer runtimeMinutes, String genres) {
		super();
		this.tconst = tconst;
		this.titleType = titleType;
		this.primaryTitle = primaryTitle;
		this.runtimeMinutes = runtimeMinutes;
		this.genres = genres;
	}
	
	
	
	

}
