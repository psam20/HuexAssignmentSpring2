package com.movieProject.Controller;

import com.movieProject.Entity.Movie;
import com.movieProject.Services.FilterMovieData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
public class MovieController {
    @Autowired
    private FilterMovieData filterMovieData;
    @GetMapping(value = "/tvshows",params = "count")
    public List<Movie> getNthTvShow(@RequestParam int count, HttpServletResponse response) throws FileNotFoundException, IOException, ParseException {
        long startTime = System.currentTimeMillis();
        List<Movie> result = new ArrayList<>();
        result = filterMovieData.filterByTypeTvShow(count);
        long endTime = System.currentTimeMillis();
        response.setHeader("Time to Execute",(endTime-startTime)+"ms");
        return result;

    }
    @GetMapping(value="/tvshows",params = "movieType")
    public List<Movie> getHorrorMovies(@RequestParam String movieType,HttpServletResponse response) throws FileNotFoundException, IOException, ParseException {
        long startTime = System.currentTimeMillis();
        List<Movie> result = new ArrayList<>();
        result= filterMovieData.findListedHorrorMovie(movieType);
        System.out.println(result);
        long endTime = System.currentTimeMillis();
        response.setHeader("Time to Execute",(endTime-startTime)+"ms");
        return result;

    }
    @GetMapping(value = "/tvshows", params = "country")
    public List<Movie> getCountryBasedMovie(@RequestParam String country, HttpServletResponse response) throws FileNotFoundException, IOException, ParseException
    {
        long startTime = System.currentTimeMillis();
        List<Movie> result = new ArrayList<>();
        result = filterMovieData.filterIndianMovie(country);
        long endTime = System.currentTimeMillis();

        //Adding the execution time in header
        response.setHeader("TIME-TO-EXECUTE",(endTime-startTime)+"ms");
        return result;

    }

    @GetMapping(value = "/tvshows", params = {"startDate","endDate"})
    public  List<Movie> getDateBasedMovie(@RequestParam Date startDate, Date endDate, HttpServletResponse response) throws FileNotFoundException, IOException, ParseException
    {
        long startTime = System.currentTimeMillis();
        List<Movie> result = new ArrayList<>();
        result = filterMovieData.filterMovie(startDate,endDate);
        long endTime = System.currentTimeMillis();

        //Adding the execution time in header
        response.setHeader("X-TIME-TO-EXECUTE",(endTime-startTime)+"ms");
        return result;
    }

}
