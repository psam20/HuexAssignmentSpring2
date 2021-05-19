package com.movieProject.Controller;

import com.movieProject.Entity.Movie;
import com.movieProject.Services.MovieService;
import com.movieProject.Services.WriteToCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class MovieWriteDbController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private WriteToCsv writeToCsv;

    @PostMapping(value = "/tvshows",params = "saveFlag")
    public void AddMovie(@RequestBody Movie movie, @RequestParam String saveFlag, HttpServletResponse response) throws IOException {
        long startTime = System.currentTimeMillis();
        if(saveFlag.equals("db"))
            movieService.saveMovieindb(movie);
        if(saveFlag.equals("csv")) {
            writeToCsv.writeToCSVfromRequestBody(movie);
            movieService.saveMovieindb(movie);
        }
        long endTime = System.currentTimeMillis();

        //Adding the execution time in header
        response.setHeader("TIME-TO-EXECUTE",(endTime-startTime)+"ms");

    }
}
