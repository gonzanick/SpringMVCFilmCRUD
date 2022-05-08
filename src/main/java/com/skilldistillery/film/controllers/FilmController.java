package com.skilldistillery.film.controllers;

import java.util.List;

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
		if (specialFeatures != null && specialFeatures.length > 0) {

			for (int i = 0; i < specialFeatures.length; i++) {

				if (i < specialFeatures.length - 1) {
					sb.append(specialFeatures[i] + ",");
				} else {
					sb.append(specialFeatures[i]);
				}
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

	@RequestMapping(path = "deleteFilm.do", method = RequestMethod.GET)
	public ModelAndView deleteFilm(RedirectAttributes redirect, String id) {
		ModelAndView mv = new ModelAndView();
		int idInt = Integer.parseInt(id);
		Film film = filmDao.findFilmById(idInt);
		boolean success = filmDao.deleteFilm(film);
		if (success) {
			mv.setViewName("redirect:deleteSuccess.do");
		} else {
			mv.setViewName("redirect:deleteFail.do");
		}
		return mv;
	}

	@RequestMapping(path = "deleteSuccess.do", method = RequestMethod.GET)
	private ModelAndView deleteSuccess() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/home.jsp");

		return mv;
	}

	@RequestMapping(path = "deleteFail.do", method = RequestMethod.GET)
	private ModelAndView deleteFail() {
		ModelAndView mv = new ModelAndView();
		String deleteFailed = "Unable to delete film due to database dependencies";
		mv.addObject("string", deleteFailed);
		mv.setViewName("WEB-INF/views/error.jsp");

		return mv;
	}

	@RequestMapping(path = "editFilm.do", method = RequestMethod.GET)
	public ModelAndView editFilm(String id) {
		ModelAndView mv = new ModelAndView();
		int idInt = Integer.parseInt(id);
		Film film = filmDao.findFilmById(idInt);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/views/editFilm.jsp");
		return mv;
	}

	@RequestMapping(path = "editFilmCategories.do", method = RequestMethod.GET)
	public ModelAndView editFilm(RedirectAttributes redir, int id, String title, String description, short releaseYear,
			int rentalDuration, double rentalRate, int length, double replaceCost, String rating,
			String... specialFeatures) {

		ModelAndView mv = new ModelAndView();
		StringBuilder sb = new StringBuilder();
		if (specialFeatures != null && specialFeatures.length > 0) {

			for (int i = 0; i < specialFeatures.length; i++) {

				if (i < specialFeatures.length - 1) {
					sb.append(specialFeatures[i] + ",");
				} else {
					sb.append(specialFeatures[i]);
				}
			}
		}

		Film film = new Film(id, title, description, releaseYear, 1, rentalDuration, rentalRate, length, replaceCost,
				rating, sb.toString());
		boolean updated = filmDao.updateFilm(film);
		if (updated) {
			redir.addFlashAttribute("film", film);
			mv.setViewName("redirect:updateSucceed.do");
		} else {
			mv.setViewName("redirect:updateFail.do");
		}
		return mv;
	}

	@RequestMapping(path = "updateSucceed.do", method = RequestMethod.GET)
	private ModelAndView updateSucceed() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/home.jsp");
		return mv;
	}

	@RequestMapping(path = "updateFail.do", method = RequestMethod.GET)
	private ModelAndView updateFail() {
		ModelAndView mv = new ModelAndView();
		String updateFailed = "Update failed";
		mv.addObject("string", updateFailed);
		mv.setViewName("WEB-INF/views/error.jsp");
		return mv;
	}
	
	@RequestMapping(path="getFilmByKeyword.do", method = RequestMethod.GET)
	private ModelAndView getFilmByKey(String keyword) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = filmDao.findFilmsByKeyword(keyword);
		mv.addObject("films", films);
		
		mv.setViewName("WEB-INF/views/films.jsp");
		return mv;
	}
	
	@RequestMapping(path="css.do", method=RequestMethod.GET)
	private String cssLink() {
		return "WEB-INF/views/style/main.css";
	}
	
}
