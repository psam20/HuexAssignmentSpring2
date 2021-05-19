package com.movieProject.Services;

import com.movieProject.Entity.Movie;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class WriteToCsv {
    public void writeToCSVfromRequestBody(Movie movie) throws IOException, IOException {
        File file = ResourceUtils.getFile("classpath:netflix_titles.csv");;
        CSVWriter writer = new CSVWriter(new FileWriter(file, true));
        String[] values = new String[11];
        System.out.println(movie);
        values[0]=movie.getShow_id();
        values[1]=movie.getType();
        values[2]=movie.getTitle();
        values[3]=movie.getDirector();
        values[4]=movie.getCast();
        values[5]=movie.getCountry();
        values[6]=movie.getDate_added().toString();
        values[7]=movie.getRelease_year();
        values[8]=movie.getRating();
        values[9]=movie.getListed_in();
        values[10]=movie.getDuration();

        writer.writeNext(values);
        writer.flush();
        System.out.println(values[0]+values[1]);
        System.out.println("Success");


    }
}

