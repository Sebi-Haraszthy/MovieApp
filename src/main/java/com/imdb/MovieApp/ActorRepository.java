package com.imdb.MovieApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    public Set<Actor> findAllByMoviesContaining(Movie movie);
}