package com.skilldistillery.film.dao;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	  public Film findFilmById(int filmId);
	  public Actor findActorById(int actorId);
	  public List<Actor> findActorsByFilmId(int filmId);
	  public List<Film> findFilmsByActorId(int actorId); 
	  public List<Film> findFilmsByKeyword(String keyPhrase); 
	  public Film addFilm(Film film);
	  public boolean deleteFilm(Film film);
	  public boolean updateFilm(Film film);
}
