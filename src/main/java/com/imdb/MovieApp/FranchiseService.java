package com.imdb.MovieApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FranchiseService {
    private ActorRepository actorRepository;
    private FranchiseRepository franchiseRepository;
    private MovieRepository movieRepository;

    @Autowired
    public FranchiseService(ActorRepository actorRepository, FranchiseRepository franchiseRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.franchiseRepository = franchiseRepository;
        this.movieRepository = movieRepository;
    }

    public void addMovieToFranchise(Movie movie, Franchise franchise) {
        franchise.getMovies().add(movie);
        movie.setFranchise(franchise);
        franchiseRepository.save(franchise);
    }
}