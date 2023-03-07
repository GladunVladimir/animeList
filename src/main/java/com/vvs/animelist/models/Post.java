package com.vvs.animelist.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String season;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSeason() {
        return season;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Post(String title, String season) {
        this.title = title;
        this.season = season;
    }

    public Post() {
    }
}
