package com.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Movies;
import com.exception.MoviesException;
import com.services.ServicesImpl;

@RestController
@RequestMapping("/api/v1")
public class Controller {
	
	
	@Autowired
	private ServicesImpl servicesImpl;
	
	//for populating movies data from csv file
	
	@GetMapping("/saveAllMovies")
	public String saveAllMovies() throws IOException {
		return servicesImpl.addAllMovieData();
		
	}
	//for populating ratings data from csv file
	
	@GetMapping("/saveAllRatings")
	public String saveAllRatings() throws IOException {
		return servicesImpl.addAllRatingsData();
		
	}
	
	@PostMapping("/new-movie")
	public ResponseEntity<String> saveAllMovies(@RequestBody Movies mov) throws IOException, MoviesException {
		
		return new ResponseEntity<>(servicesImpl.addNewMovie(mov),HttpStatus.OK);
		
	}
	
	@GetMapping("/longest-duration-movies")
	public ResponseEntity<List<Object>> longestDurationMovies() throws IOException, MoviesException {
		return new ResponseEntity<>(servicesImpl.longestRunMovies(),HttpStatus.OK);
		
	}
	
	@GetMapping("/top-rated-movies")
	public List<Object> averageRatingHandler()  {
		return servicesImpl.AverageRating();	
	}
	
	@GetMapping("/genre-movies-with-subtotals")
	public List<Object> genreMovieWithSubTotal() {
		return servicesImpl.genreMovieWithSubTotal();	
	}
	
	@GetMapping("/update-runtime-minutes")
	public String updateRuntimeMinutes() {
		return servicesImpl.updateRuntimeMinute();	
	}
	
	
	

}
