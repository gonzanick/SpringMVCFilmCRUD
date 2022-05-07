package com.skilldistillery.film.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.film.dao.FilmDAO;
import com.skilldistillery.film.dao.FilmDaoJdbcImpl;

class DatabaseAccessTests {
	private FilmDAO db;
	private Film testFilm;
	private int id;
	private Film testUpdate;

	@BeforeEach
	void setUp() throws Exception {
		db = new FilmDaoJdbcImpl();
		testFilm = new Film(0, "testTitle", "testDesc", (short) 1994, 1, 3, 3.99, 204, 20.99, "PG", "Deleted Scenes");
		testUpdate = new Film(id, "testUpdate", "testDesc", (short) 1994, 1, 3, 3.99, 204, 20.99, "PG",
				"Deleted Scenes");
	}

	@AfterEach
	void tearDown() throws Exception {
		db = null;
	}

	@Test
	void test_findFilmById_with_invalid_id_returns_null() {
		Film f = db.findFilmById(-42);
		assertNull(f);
	}

	@Test
	void test_findActorById_with_invalid_id_returns_null() {
		Actor a = db.findActorById(-42);
		assertNull(a);
	}

	@Test
	void test_findFilmById_returns_valid_film_object() {
		Film f = db.findFilmById(1);
		assertTrue(f.getTitle().contains("ACADEMY DINOSAUR"));
	}

	@Test
	void test_findActorById_returns_valid_actor_object() {
		Actor a = db.findActorById(1);
		assertTrue(a.getFirstName().equals("Penelope"));
	}

	@Test
	void test_findFilmsByKeyword_with_no_match_returns_empty_array() {
		List<Film> f = db.findFilmsByKeyword("NO SUCH KEYWORD");
		assertTrue(f.isEmpty());
	}

	@Test
	void test_findFilmsByKeyword_returns_valid_film_list() {
		List<Film> f = db.findFilmsByKeyword("dinosaur");
		assertFalse(f.isEmpty());
	}

	@Test
	void test_findFilmsByActorId_with_invalid_id_returns_empty_array() {
		List<Film> f = db.findFilmsByActorId(-42);
		assertTrue(f.isEmpty());
	}

	@Test
	void test_findFilmsByActorId_returns_valid_film_list() {
		List<Film> f = db.findFilmsByActorId(1);
		assertFalse(f.isEmpty());
	}

	@Test
	void test_findActorsByFilmId_with_invalid_id_returns_empty_array() {
		List<Actor> a = db.findActorsByFilmId(-42);
		assertTrue(a.isEmpty());
	}

	@Test
	void test_findActorsByFilmId_returns_valid_film_list() {
		List<Actor> a = db.findActorsByFilmId(1);
		assertFalse(a.isEmpty());
	}

	@Test
	void test_addFilm_thenUpdate_thenDelete_correct_returns_and_effects() {
		Film film = db.addFilm(testFilm);
		assertTrue(film.getTitle().equals("testTitle"));
		id = film.getId();
		Film dbFilm = db.findFilmById(id);
		assertEquals(film.getTitle(), dbFilm.getTitle());

//		Test Update
		testUpdate = new Film(id, "testUpdate", "testDesc", (short) 1994, 1, 3, 3.99, 204, 20.99, "PG",
				"Deleted Scenes");
		boolean test = db.updateFilm(testUpdate);
		assertEquals(true, test);
		dbFilm = db.findFilmById(id);
		assertEquals(dbFilm.getTitle(), testUpdate.getTitle());
		
//		Test Delete

	
	}

}
