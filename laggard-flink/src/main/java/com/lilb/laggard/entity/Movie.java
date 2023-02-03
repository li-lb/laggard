package com.lilb.laggard.entity;

import jakarta.persistence.*;
import lombok.Data;


/**
 * @author lilinbi1
 * @date 2023年02月03日
 */
@Entity
@Table(name = "movie")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String releaseYear;

    private String title;

    private String origin;

    private String director;

    private String cast;

    private String genre;

    private String wikiPage;

    private String plot;

}
