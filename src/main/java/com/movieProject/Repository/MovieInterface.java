package com.movieProject.Repository;

import com.movieProject.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieInterface extends JpaRepository<Movie,String> {

}
