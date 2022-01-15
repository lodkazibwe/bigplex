package com.bigplex.bigplex.movie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeDto {
    private int epsId;
    private int episodeNumber;
    private String name;
    private double size;
    private String comment;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", locale = "pt-BR", timezone = "EAT")
    @Temporal(TemporalType.DATE)
    private Date released;
    private int quality;
    private String epStatus;
}
