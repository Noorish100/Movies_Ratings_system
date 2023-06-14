package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Movies;

import jakarta.transaction.Transactional;

@Repository
public interface MovieRepo extends JpaRepository<Movies, String>{

	@Query(value="select m.tconst,m.primary_title,m.runtime_minutes,m.genres from movies m order by m.runtime_minutes desc limit 10",nativeQuery = true) 
    List<Object> findByRuntimeMinutes();
	
	@Query(value="select m.tconst,m.primary_title,m.genres,average_rating from movies m,ratings where average_rating>0.6 order by average_rating desc",nativeQuery = true)
	List<Object> findByAverageRating();
	
	@Query(value="select m.genres,m.primary_title,num_votes from movies m inner Join ratings on m.tconst=ratings.tconst order by genres",nativeQuery = true)
	List<Object> findByGenre();
	
	@Transactional
	@Modifying
	@Query(value="UPDATE movies SET runtime_minutes=CASE WHEN genres='Documentary' THEN runtime_minutes+15 WHEN genres='Animation' THEN runtime_minutes+30 ELSE runtime_minutes+45 END",nativeQuery = true)
	void UpdateAllByRuntimeMinutes();
    
    
	
}
