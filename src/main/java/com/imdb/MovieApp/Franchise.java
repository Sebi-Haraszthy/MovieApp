package com.imdb.MovieApp;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Franchises")
public class Franchise {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "franchise", cascade = CascadeType.ALL)
    Set<Movie> movies;

    public Franchise(String name) {
        this.name = name;
    }

    public Franchise() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        if (this.movies == null) {
            this.movies = new HashSet<>();
        }

        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Franchise: " + "id = " + id + "; name = " + name;
    }
}