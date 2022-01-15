package com.bigplex.bigplex.movie.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue
    private int movieId;
    @Column(unique=true)
    private String title;
    private String summary;
    private String cover;
    private String category;
    private String subCat;
    private double size;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", locale = "pt-BR", timezone = "EAT")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    @OneToMany(targetEntity = Episode.class,cascade= CascadeType.ALL, fetch= FetchType.EAGER)
    @JoinColumn()
    private List<Episode> episodes;

    }
