package com.imdb.MovieApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MovieService {
    private ActorRepository actorRepository;
    private FranchiseRepository franchiseRepository;
    private MovieRepository movieRepository;

    @Autowired
    public MovieService(ActorRepository actorRepository, FranchiseRepository franchiseRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.franchiseRepository = franchiseRepository;
        this.movieRepository = movieRepository;
    }

    public void addActorToMovie(Actor actor, Movie movie) {
        actor.getMovies().add(movie);
        movie.getActors().add(actor);
        movieRepository.save(movie);
    }

    public Set<Movie> findAllByFranchise(Franchise franchise){
        return movieRepository.findAllByFranchise(franchise);
    }
}