package com.bigplex.bigplex.movie.Converter;

import com.bigplex.bigplex.movie.dto.EpisodeDto;
import com.bigplex.bigplex.movie.model.Episode;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EpisodeConverter {
    public EpisodeDto entityToDto(Episode episode){
        EpisodeDto episodeDto =new EpisodeDto();
        episodeDto.setEpsId(episode.getEpsId());
        episodeDto.setComment(episode.getComment());
        episodeDto.setEpisodeNumber(episode.getEpisodeNumber());
        episodeDto.setEpStatus(episode.getEpStatus());
        episodeDto.setName(episode.getName());
        episodeDto.setQuality(episode.getQuality());
        episodeDto.setReleased(episode.getReleased());
        episodeDto.setSize(episode.getSize());
        return episodeDto;
    }

    public Episode dtoToEntity(EpisodeDto episodeDto){
        Episode episode =new Episode();
        episode.setComment(episodeDto.getComment());
        episode.setEpisodeNumber(episodeDto.getEpisodeNumber());
        episode.setEpStatus(episodeDto.getEpStatus());
        episode.setName(episodeDto.getName());
        episode.setReleased(episodeDto.getReleased());
        episode.setQuality(episodeDto.getQuality());
        episode.setSize(episodeDto.getSize());
        return episode;
    }

    public List<EpisodeDto> entityToDto(List<Episode> episodeList){
        return episodeList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<Episode> dtoToEntity(List<EpisodeDto> episodeDtoList){
        return episodeDtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
