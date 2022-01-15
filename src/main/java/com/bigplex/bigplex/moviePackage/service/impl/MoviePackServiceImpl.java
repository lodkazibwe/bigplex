package com.bigplex.bigplex.moviePackage.service.impl;

import com.bigplex.bigplex.exceptions.InvalidValuesException;
import com.bigplex.bigplex.exceptions.ResourceNotFoundException;
import com.bigplex.bigplex.moviePackage.Converter.PackConverter;
import com.bigplex.bigplex.moviePackage.dao.MoviePackDao;
import com.bigplex.bigplex.moviePackage.dto.MoviePackDto;
import com.bigplex.bigplex.moviePackage.model.MoviePack;
import com.bigplex.bigplex.moviePackage.service.MoviePackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviePackServiceImpl implements MoviePackService {
    @Autowired MoviePackDao packageDao;
    @Autowired PackConverter packConverter;

    @Override
    public MoviePack addPackage(MoviePackDto moviePackDto) {
        boolean bool =packExists(moviePackDto.getName());
        if(bool){
            throw new InvalidValuesException("package name already used");
        }
        return packageDao.save(packConverter.dtoToEntity(moviePackDto));
    }

    @Override
    public MoviePack getPackage(int packId) {
        return packageDao.findById(packId)
                .orElseThrow(()->new ResourceNotFoundException("no such package "+packId));
    }

    @Override
    public MoviePack getPackage(String name) {
        return packageDao.findByName(name);
    }

    @Override
    public boolean packExists(String name) {
        return packageDao.existsByName(name);
    }

    @Override
    public List<MoviePack> getAll() {
        return packageDao.findAll();
    }
}
