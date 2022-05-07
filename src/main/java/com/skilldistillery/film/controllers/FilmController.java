package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@RequestMapping(path = { "newFilm.do" })
	public String newFilmPage() {
		return "WEB-INF/views/NewFilmPage.jsp";
	}

	@RequestMapping(path = "getFilmData.do", method = RequestMethod.GET)
	public ModelAndView getFilmById(int id) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDao.findFilmById(id);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/views/film.jsp");
//		NOT DONE
		return mv;
	}

	@RequestMapping(path = "addFilm.do", method = RequestMethod.GET)
	public ModelAndView addFilm(RedirectAttributes redir, String title, String description, short releaseYear,
			int rentalDuration, double rentalRate, int length, double replaceCost, String rating,
			String... specialFeatures) {
		ModelAndView mv = new ModelAndView();
		StringBuilder sb = new StringBuilder();
		String[] featuresList = { "Trailers", "Commentaries", "Deleted Scenes", "Behind The Scenes" };
		for (int i = 0; i < specialFeatures.length; i++) {
			
				if (i < specialFeatures.length - 1) {
					sb.append(specialFeatures[i] + ",");
				} else {
					sb.append(specialFeatures[i]);
				}
			
		}

		Film film = filmDao.addFilm(new Film(title, description, releaseYear, 1, rentalDuration, rentalRate, length,
				replaceCost, rating, sb.toString()));
		redir.addFlashAttribute("film", film);
		mv.setViewName("redirect:redirectDetails.do");
		return mv;
	}

	@RequestMapping(path = "redirectDetails.do", method = RequestMethod.GET)
	private ModelAndView filmDisplay() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/film.jsp");
		return mv;
	}
	
	@RequestMapping(path="deleteFilm.do", method=RequestMethod.GET )
	public ModelAndView deleteFilm(RedirectAttributes redirect, String id) {
		ModelAndView mv = new ModelAndView();
		int idInt = Integer.parseInt(id);
		Film film =  filmDao.findFilmById(idInt);
		boolean success = filmDao.deleteFilm(film);
		if(success) {
			mv.setViewName("redirect:deleteSuccess.do");
		}else {
			mv.setViewName("redirect:deleteFail.do");
		}
		return mv;
	}
	
	@RequestMapping(path="deleteSuccess.do", method=RequestMethod.GET)
	private ModelAndView deleteSuccess() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/home.jsp");
		
		return mv;
	}
	
	@RequestMapping(path="deleteFail.do", method=RequestMethod.GET)
	private ModelAndView deleteFail() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/error.jsp");
		
		return mv;
	}

}
