package com.movieProject.Services;

import com.movieProject.Entity.Movie;
import com.movieProject.Repository.MovieInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MovieService {
    @Autowired

    private MovieInterface movieRepository;



    public Movie saveMovieindb(Movie movie) {
        return movieRepository.save(movie);

    }
}
