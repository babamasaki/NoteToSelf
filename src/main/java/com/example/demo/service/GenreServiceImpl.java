package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entitiy.Genre;
import com.example.demo.repsitory.GenreDao;

@Service
public class GenreServiceImpl implements GenreService {

	private final GenreDao genreDao;

	public GenreServiceImpl(GenreDao genreDao) {
		this.genreDao = genreDao;
	}

	@Override
	public List<Genre> findAll() {
		return genreDao.findAll();
	}

	@Override
	public boolean genreCheck(Genre genre) {
		return genreDao.genreCheck(genre);
	}

	@Override
	public void save(Genre genre) {
		genreDao.genreInsert(genre);
	}



}
