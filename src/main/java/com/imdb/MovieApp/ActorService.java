package com.imdb.MovieApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ActorService {
    private ActorRepository actorRepository;
    private FranchiseRepository franchiseRepository;
    private MovieRepository movieRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository, FranchiseRepository franchiseRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.franchiseRepository = franchiseRepository;
        this.movieRepository = movieRepository;
    }

    public Set<Actor> findAllByMovie(Movie movie) {
        return actorRepository.findAllByMoviesContaining(movie);
    }
}