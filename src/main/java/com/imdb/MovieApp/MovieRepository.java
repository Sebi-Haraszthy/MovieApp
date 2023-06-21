package com.imdb.MovieApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    public Set<Movie> findAllByFranchise(Franchise franchise);
}