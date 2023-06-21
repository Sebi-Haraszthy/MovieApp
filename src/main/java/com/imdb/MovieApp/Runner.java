package com.imdb.MovieApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private ActorRepository actorRepository;
    private ActorService actorService;
    private FranchiseRepository franchiseRepository;
    private FranchiseService franchiseService;
    private MovieRepository movieRepository;
    private MovieService movieService;

    @Autowired
    public Runner(ActorRepository actorRepository, ActorService actorService, FranchiseRepository franchiseRepository, FranchiseService franchiseService, MovieRepository movieRepository, MovieService movieService) {
        this.actorRepository = actorRepository;
        this.actorService = actorService;
        this.franchiseRepository = franchiseRepository;
        this.franchiseService = franchiseService;
        this.movieRepository = movieRepository;
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) throws Exception {
        Actor actor1 = new Actor("Arnold Schwarzenegger");
        Actor actor2 = new Actor("Michael Biehn");
        Actor actor3 = new Actor("Linda Hamilton");
        Actor actor4 = new Actor("Edward Furlong");
        actorRepository.save(actor1);
        actorRepository.save(actor2);
        actorRepository.save(actor3);
        actorRepository.save(actor4);
        Movie movie1 = new Movie("The Terminator");
        Movie movie2 = new Movie("Terminator 2");
        movieRepository.save(movie1);
        movieRepository.save(movie2);
        Franchise franchise1 = new Franchise("Skynet");
        franchiseRepository.save(franchise1);

        movieService.addActorToMovie(actor1, movie1);
        movieService.addActorToMovie(actor2, movie1);
        movieService.addActorToMovie(actor3, movie1);
        movieService.addActorToMovie(actor1, movie2);
        movieService.addActorToMovie(actor3, movie2);
        movieService.addActorToMovie(actor4, movie2);
        franchiseService.addMovieToFranchise(movie1, franchise1);
        franchiseService.addMovieToFranchise(movie2, franchise1);

        System.out.println("All movies by franchise: " + movieService.findAllByFranchise(franchise1));
        System.out.println("All actors by movie: " + actorService.findAllByMovie(movie1));
    }
}