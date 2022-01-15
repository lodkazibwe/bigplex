package com.bigplex.bigplex.movie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private int movieId;
    private String title;
    private String summary;
    private String cover;
    private String category;
    private String subCat;
    private double size;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", locale = "pt-BR", timezone = "EAT")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    private List<EpisodeDto> episodes;
}
