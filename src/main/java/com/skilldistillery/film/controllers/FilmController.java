package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.dao.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO filmDao;

	@RequestMapping(path = { "/", "home.do" })
	public String home() {
		return "WEB-INF/views/home.jsp";
	}
	
	@RequestMapping(path= {"newFilm.do" })
	public String newFilmPage() {
		return "WEB-INF/views/NewFilmPage.jsp";
	}

	@RequestMapping(path = "getFilm.do", params = "", method = RequestMethod.GET)
	public ModelAndView getFilmById(int id) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDao.findFilmById(id);

//		NOT DONE
		return mv;

	}

	@RequestMapping(path = "addFilm.do", params = { "title", "description", "releaseYear", "rentalDuration",
			"rentalRate", "length", "replaceCost", "rating", "specialFeatures" }, method = RequestMethod.GET)
	public ModelAndView addFilm(String title, String description, short releaseYear, int rentalDuration,
			double rentalRate, int length, double replaceCost, String rating, String specialFeatures) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDao.addFilm(new Film(title, description, releaseYear, 1, rentalDuration, rentalRate, length, replaceCost, rating,
				specialFeatures));
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/views/film.jsp");
		return mv;
	}

}
