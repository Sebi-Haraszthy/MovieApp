package com.imdb.MovieApp;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Actors")
public class Actor {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @ManyToMany(mappedBy = "actors", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Movie> movies;

    public Actor(String name) {
        this.name = name;
    }

    public Actor() {
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
        return "Actor: " + "id = " + id + "; name = " + name;
    }
}