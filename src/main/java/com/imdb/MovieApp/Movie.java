package com.imdb.MovieApp;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "Movies")
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "title")
    private String name;
    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "movie_actor", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<Actor> actors;

    public Movie(String name) {
        this.name = name;
    }

    public Movie() {
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

    public Franchise getFranchise() {
        return franchise;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }

    public Set<Actor> getActors() {
        if (this.actors == null) {
            this.actors = new HashSet<>();
        }

        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movie: " + "id = " + id + "; name = " + name + "; franchise = " + franchise + "; actors = " + actors;
    }
}