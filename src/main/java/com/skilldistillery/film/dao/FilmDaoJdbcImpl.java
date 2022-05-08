package com.skilldistillery.film.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Component
public class FilmDaoJdbcImpl implements FilmDAO {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private String user = "student";
	private String pass = "student";

	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM film WHERE film.id = ?;");
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String desc = rs.getString("description");
				short releaseYear = rs.getShort("release_year");
				int langId = rs.getInt("language_id");
				int rentDur = rs.getInt("rental_duration");
				double rate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double repCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String features = rs.getString("special_features");
				List<Actor> actors = findActorsByFilmId(conn, filmId);
				film = new Film(id, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating, features,
						actors);
				setOtherFilmAttributes(conn, film);
			}
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;

	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		try (Connection conn = DriverManager.getConnection(URL, user, pass);
				PreparedStatement stmt = prepStatementActor(conn, actorId);
				ResultSet rs = stmt.executeQuery();) {
			ResultSet actorResult = stmt.executeQuery();
			if (actorResult.next()) {
				actor = new Actor();
				actor.setId(actorResult.getInt(1));
				actor.setFirstName(actorResult.getString(2));
				actor.setLastName(actorResult.getString(3));
				actor.setFilms(findFilmsByActorId(actorId));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return actor;

	}

	public List<Film> findFilmsByActorId(int actorId) {
		List<Film> films = new ArrayList<>();
		String user = "student";
		String pass = "student";
		try (Connection conn = DriverManager.getConnection(URL, user, pass);
				PreparedStatement stmt = prepStatementFilmList(conn, actorId);
				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				int filmId = rs.getInt("id");
				String title = rs.getString("title");
				String desc = rs.getString("description");
				short releaseYear = rs.getShort("release_year");
				int langId = rs.getInt("language_id");
				int rentDur = rs.getInt("rental_duration");
				double rate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double repCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String features = rs.getString("special_features");
				List<Actor> actors = findActorsByFilmId(conn, filmId);
				Film film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
						features, actors);
				setOtherFilmAttributes(conn, film);
				films.add(film);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	private List<Film> findFilmsByActorId(Connection conn, int id) {
		List<Film> films = new ArrayList<>();
		try (PreparedStatement stmt = prepStatementFilmList(conn, id); ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				int filmId = rs.getInt("id");
				String title = rs.getString("title");
				String desc = rs.getString("description");
				short releaseYear = rs.getShort("release_year");
				int langId = rs.getInt("language_id");
				int rentDur = rs.getInt("rental_duration");
				double rate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double repCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String features = rs.getString("special_features");
				Film film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
						features);
				setOtherFilmAttributes(conn, film);
				films.add(film);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(URL, user, pass);
				PreparedStatement stmt = prepStatementActorList(conn, filmId);
				ResultSet rs = stmt.executeQuery();) {
			ResultSet actorResult = stmt.executeQuery();
			while (actorResult.next()) {
				int id = actorResult.getInt("id");
				String firstName = actorResult.getString("first_name");
				String lastName = actorResult.getString("last_name");
				List<Film> films = findFilmsByActorId(conn, id);
				actors.add(new Actor(id, firstName, lastName, films));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return actors;
	}

	private List<Actor> findActorsByFilmId(Connection conn, int filmId) {
		List<Actor> actors = new ArrayList<>();
		try (PreparedStatement stmt = prepStatementActorList(conn, filmId); ResultSet rs = stmt.executeQuery();) {
			ResultSet actorResult = stmt.executeQuery();
			while (actorResult.next()) {

				int id = actorResult.getInt("id");
				String firstName = actorResult.getString("first_name");
				String lastName = actorResult.getString("last_name");
				actors.add(new Actor(id, firstName, lastName));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return actors;

	}

	public List<Film> findFilmsByKeyword(String keyPhrase) {
		List<Film> films = new ArrayList<>();
		String user = "student";
		String pass = "student";
		try (Connection conn = DriverManager.getConnection(URL, user, pass);
				PreparedStatement stmt = prepStatementFilmList(conn, keyPhrase);
				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				int filmId = rs.getInt("id");
				String title = rs.getString("title");
				String desc = rs.getString("description");
				short releaseYear = rs.getShort("release_year");
				int langId = rs.getInt("language_id");
				int rentDur = rs.getInt("rental_duration");
				double rate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double repCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String features = rs.getString("special_features");
				List<Actor> actors = findActorsByFilmId(filmId);
				Film film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
						features, actors);
				setOtherFilmAttributes(conn, film);
				films.add(film);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	private void setOtherFilmAttributes(Connection conn, Film film) {

		try (PreparedStatement stmt = prepStatementLanguage(conn, film.getLanguageId());
				ResultSet rs = stmt.executeQuery();) {

			if (rs.next()) {
				film.setLanguage(rs.getString("name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try (PreparedStatement stmt = prepStatementFilmCategory(conn, film); ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				film.addCategory(rs.getString("name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try (PreparedStatement stmt = prepStatementFilmInvCondition(conn, film); ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				film.addInventoryCondition(rs.getString("media_condition"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film addFilm(Film film) {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);

			PreparedStatement stmt = prepStatementAddFilm(conn, film);

			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					int filmId = keys.getInt(1);
					film.setId(filmId);
					if (film.getCast() != null && film.getCast().size() > 0) {
						String sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?, ?)";
						stmt = conn.prepareStatement(sql);
						for (Actor actor : film.getCast()) {
							stmt.setInt(1, filmId);
							stmt.setInt(2, actor.getId());
							updateCount = stmt.executeUpdate();
						}
					}
				}
			} else {
				film = null;
			}
			conn.commit();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
		}

		return film;
	}

	@Override
	public boolean deleteFilm(Film film) {
		boolean removed = false;
		Connection conn = null;
		String sql = "DELETE FROM film_actor WHERE film_id = ?;";
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);

//			Remove Film from film_actor
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, film.getId());
			int updateCount = stmt.executeUpdate();

//			Remove Film from film
			sql = "DELETE FROM film WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, film.getId());
			updateCount = stmt.executeUpdate();

//			Commit if code finishes
			conn.commit();

//			update boolean
			removed = true;

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying rollback");
				}
			}

		}

		return removed;
	}

	@Override
	public boolean updateFilm(Film film) {
		boolean updated = false;
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);

			PreparedStatement stmt = prepStatementUpdateFilm(conn, film);
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {

				if (film.getCast() != null && !film.getCast().isEmpty()) {

//			Remove existing actor associations from database
					String sql = "DELETE FROM film_actor WHERE film_id = ?";
					stmt = conn.prepareStatement(sql);
					stmt.setInt(1, film.getId());
					updateCount = stmt.executeUpdate();

//			Replace actor associations from Object
					sql = "INSERT INTO film_actor (film_id, actor_id)";
					stmt = conn.prepareStatement(sql);
					for (Actor actor : film.getCast()) {
						stmt.setInt(1, film.getId());
						stmt.setInt(2, actor.getId());
						updateCount = stmt.executeUpdate();
					}
				}
				
				updated = true;
				conn.commit();
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
		}

		return updated;
	}

	private PreparedStatement prepStatementLanguage(Connection conn, int langId) throws SQLException {
		String sql = "SELECT name FROM language WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, langId);
		return stmt;
	}

	private PreparedStatement prepStatementActorList(Connection conn, int filmId) throws SQLException {
		String sql = "SELECT actor.id, actor.first_name, actor.last_name FROM actor JOIN film_actor ON film_actor.actor_id = actor.id JOIN film ON film_actor.film_id = film.id WHERE film.id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		return stmt;

	}

	private PreparedStatement prepStatementActor(Connection conn, int actorId) throws SQLException {
		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, actorId);
		return stmt;

	}

	private PreparedStatement prepStatementFilmList(Connection conn, int actorId) throws SQLException {

		String sql = "SELECT id, title, description, release_year, language_id, rental_duration, ";
		sql += " rental_rate, length, replacement_cost, rating, special_features "
				+ " FROM film JOIN film_actor ON film.id = film_actor.film_id " + " WHERE actor_id = ?";
		PreparedStatement tempStmt = conn.prepareStatement(sql);
		tempStmt.setInt(1, actorId);
		return tempStmt;

	}

	private PreparedStatement prepStatementFilmList(Connection conn, String keyPhrase) throws SQLException {
		String sql = "SELECT id, title, description, release_year, language_id, rental_duration, ";
		sql += " rental_rate, length, replacement_cost, rating, special_features " + " FROM film"
				+ " WHERE title LIKE ? or description LIKE ?";
		PreparedStatement tempStmt = conn.prepareStatement(sql);
		tempStmt.setString(1, "%" + keyPhrase + "%");
		tempStmt.setString(2, "%" + keyPhrase + "%");
		return tempStmt;
	}

	private PreparedStatement prepStatementFilmCategory(Connection conn, Film film) throws SQLException {
		String sql = "SELECT category.name FROM category JOIN film_category ON category.id = film_category.category_id JOIN film ON film_category.film_id = film.id WHERE film.id = ?";
		PreparedStatement tempStmt = conn.prepareStatement(sql);
		tempStmt.setInt(1, film.getId());
		return tempStmt;
	}

	private PreparedStatement prepStatementFilmInvCondition(Connection conn, Film film) throws SQLException {
		String sql = "SELECT media_condition, store_id FROM inventory_item WHERE film_id = ?";
		PreparedStatement tempStmt = conn.prepareStatement(sql);
		tempStmt.setInt(1, film.getId());
		return tempStmt;
	}

	private PreparedStatement prepStatementAddFilm(Connection conn, Film film) throws SQLException {
		String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration,"
				+ " rental_rate, length, replacement_cost, rating, special_features)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, (?) );";
		PreparedStatement tempStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		tempStmt.setString(1, film.getTitle());
		tempStmt.setString(2, film.getDescription());
		tempStmt.setInt(3, film.getReleaseYear());
//		---HARDCODED---
		int languageId = 1;
		tempStmt.setInt(4, languageId);
//		----FOR NOW----
		tempStmt.setInt(5, film.getRentalDuration());
		tempStmt.setDouble(6, film.getRentalRate());
		tempStmt.setInt(7, film.getLength());
		tempStmt.setDouble(8, film.getReplaceCost());
		tempStmt.setString(9, film.getRating());
		tempStmt.setString(10, film.getSpecialFeatures());

		return tempStmt;

	}

	private PreparedStatement prepStatementUpdateFilm(Connection conn, Film film) throws SQLException {

		String sql = "UPDATE film SET title=?, description=?, release_year=?, language_id=?, rental_duration=?,"
				+ " rental_rate=?, length=?, replacement_cost=?, rating=?, special_features=?" + " WHERE id=?";
		PreparedStatement tempStmt = conn.prepareStatement(sql);
		tempStmt.setString(1, film.getTitle());
		tempStmt.setString(2, film.getDescription());
		tempStmt.setInt(3, film.getReleaseYear());
//		---HARDCODED---
		int languageId = 1;
		tempStmt.setInt(4, languageId);
//		----FOR NOW----
		tempStmt.setInt(5, film.getRentalDuration());
		tempStmt.setDouble(6, film.getRentalRate());
		tempStmt.setInt(7, film.getLength());
		tempStmt.setDouble(8, film.getReplaceCost());
		tempStmt.setString(9, film.getRating());
		tempStmt.setString(10, film.getSpecialFeatures());
		tempStmt.setInt(11, film.getId());

		return tempStmt;

	}

}
