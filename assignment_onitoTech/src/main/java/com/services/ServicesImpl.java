package com.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Movies;
import com.entity.Ratings;
import com.exception.MoviesException;
import com.repository.MovieRepo;
import com.repository.RatingRepo;

@Service
public class ServicesImpl implements Services {

	@Autowired 
	private MovieRepo movieRepo;
	
	@Autowired
	private RatingRepo ratingRepo;
	
	String line="";
	
	@Override
	public String addAllMovieData() throws IOException {
		
			BufferedReader bufferedReader=new BufferedReader(new FileReader("src/main/resources/movies.csv"));
			List<Movies> lmov=new ArrayList<>();
			while(bufferedReader.readLine()!=null) {
				
				line=bufferedReader.readLine();
				
				String[] data =line.split(",");
				
				Movies mov=new Movies(data[0],data[1],data[2],Integer.parseInt(data[3]),data[4]);
				
				lmov.add(mov);
				}
			if(lmov.size()==0) {
				throw new IOException("no data in file to save");
			}
			lmov.remove(0);
			movieRepo.saveAll(lmov);
		return "All movies csvfile data has been saved in the DB";
	}

	@Override
	public String addAllRatingsData() throws NumberFormatException, IOException  {
		
		BufferedReader bufferedReader=new BufferedReader(new FileReader("src/main/resources/ratings.csv"));
		List<Ratings> lrat=new ArrayList<>();
		while(bufferedReader.readLine()!=null) {
			
			line=bufferedReader.readLine();
			
			String[] data =line.split(",");
			
			Ratings rat=new Ratings(data[0], Double.parseDouble(data[1]), Integer.parseInt(data[2]));
			lrat.add(rat);
			}
		if(lrat.size()==0) {
			throw new IOException("no data in file to save");
		}
		lrat.remove(0);
		ratingRepo.saveAll(lrat);
	return "All ratings csvfile data has been saved in the DB";	
	}

	@Override
	public String addNewMovie(Movies mov)throws MoviesException{
		if(mov.equals(null)) {
			throw new MoviesException("movies body is empty");
		}
		Movies mo = movieRepo.save(mov);
		return "Success";
	}

	@Override
	public List<Object> longestRunMovies()throws MoviesException {
	 List<Object> mov = movieRepo.findByRuntimeMinutes();
	 if(mov.isEmpty()) {
		 throw new MoviesException("list is empty try again");
	 }
	 return mov;
	}

	@Override
	public List<Object> AverageRating() {
		return movieRepo.findByAverageRating();	
	}

	@Override
	public List<Object> genreMovieWithSubTotal() {
		
		return movieRepo.findByGenre();
	}

	@Override
	public String updateRuntimeMinute() {
		 movieRepo.UpdateAllByRuntimeMinutes();
		 
		 return "movies data updated according to runtimeMinutes"; 
		
	}

}
