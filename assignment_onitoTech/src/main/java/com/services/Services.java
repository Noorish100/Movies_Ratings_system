package com.services;

import java.io.IOException;

import java.util.List;

import com.entity.Movies;
import com.exception.GlobalException;
import com.exception.MoviesException;

public interface Services {
	
	public String addAllMovieData() throws IOException;
	
	public String addAllRatingsData() throws NumberFormatException, IOException;

	public String addNewMovie(Movies mov) throws MoviesException;
	
	public List<Object> longestRunMovies() throws MoviesException;
	
	public List<Object> AverageRating()throws Exception;
	
	public List<Object> genreMovieWithSubTotal()throws Exception;
	
	public String updateRuntimeMinute()throws Exception;
	
	
}
