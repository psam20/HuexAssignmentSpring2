package com.movieProject.Services;

import com.movieProject.Entity.Movie;
import com.movieProject.Utility.Reader;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class FilterMovieData {
    public List<Movie> showAll() throws IOException, ParseException {
        List<Movie> result=new ArrayList<>();
        result = Reader.ParseCSVandRead();
        return result;
    }
    public  List<Movie> filterByTypeTvShow(int count) throws FileNotFoundException, IOException, ParseException {
        List<Movie> movies = new ArrayList<>();
        movies=Reader.ParseCSVandRead();
        List<Movie> result = movies.stream().filter(m -> m.getDate_added() !=null)
                .filter(m -> m.getType().equals("TV Show")).limit(count).collect(Collectors.toList());
        return result;
    }

    public List<Movie> findListedHorrorMovie(String movieType) throws FileNotFoundException, IOException, ParseException
    {
        List<Movie> movies = new ArrayList<>();
        movies = Reader.ParseCSVandRead();
        List<Movie> result = new ArrayList<>();
        result = movies.stream().filter(m -> m.getDate_added() != null)
                .filter(m -> m.getListed_in().toLowerCase().contains(movieType.toLowerCase()))
                .collect(Collectors.toList());
        return result;
    }

    public  List<Movie> filterIndianMovie(String country) throws FileNotFoundException, IOException, ParseException
    {
        List<Movie> movies = new ArrayList<>();
        movies = Reader.ParseCSVandRead();
        List<Movie> result = new ArrayList<>();
        result = movies.stream().filter(m -> m.getDate_added() != null)
                .filter(m -> m.getCountry().toLowerCase().contains(country.toLowerCase()))
                .collect(Collectors.toList());

        return result;
    }

    public  List<Movie> filterMovie(Date startDate, Date endDate) throws FileNotFoundException, IOException, ParseException
    {
        List<Movie> movies = new ArrayList<>();
        movies = Reader.ParseCSVandRead();
        List<Movie> result = new ArrayList<>();
        result = movies.stream().filter(m -> m.getDate_added() != null)
                .filter(m -> m.getDate_added().after(startDate) && m.getDate_added().before(endDate))
                .collect(Collectors.toList());
        return result;
    }
}
