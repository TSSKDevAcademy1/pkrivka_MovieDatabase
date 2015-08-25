package sk.tsystems.akademia.MovieDatabase.dao;

import java.util.List;

import sk.tsystems.akademia.MovieDatabase.model.Celebrity;
import sk.tsystems.akademia.MovieDatabase.model.Genre;
import sk.tsystems.akademia.MovieDatabase.model.JpaHelper;
import sk.tsystems.akademia.MovieDatabase.model.Movie;
import sk.tsystems.akademia.MovieDatabase.model.Review;
import sk.tsystems.akademia.MovieDatabase.model.TvSeries;
import sk.tsystems.akademia.MovieDatabase.model.VideoArt;

public class VideoArtDao {

	public void saveVideoArt(VideoArt videoart) {
		JpaHelper.beginTransaction();
		JpaHelper.getEntityManager().persist(videoart);
		JpaHelper.commitTransaction();
	}

	public void addDirector(VideoArt videoart, Celebrity celebrity) {
		videoart.addDirectors(celebrity);
		JpaHelper.beginTransaction();
		JpaHelper.getEntityManager().persist(videoart);
		JpaHelper.commitTransaction();
	}

	public void addActor(VideoArt videoart, Celebrity celebrity) {
		videoart.addActors(celebrity);
		JpaHelper.beginTransaction();
		JpaHelper.getEntityManager().persist(videoart);
		JpaHelper.commitTransaction();
	}

	public void createReview(VideoArt videoart, Review review) {
		videoart.addReviews(review);
		JpaHelper.beginTransaction();
		JpaHelper.getEntityManager().persist(videoart);
		JpaHelper.commitTransaction();
	}

	public void listAllMoviesByYear(String yearOfpublication) {
		JpaHelper.beginTransaction();
		List<VideoArt> movies = JpaHelper.getEntityManager()
				.createQuery("select m from VideoArt m where m.yearOfpublication=:year", VideoArt.class)
				.setParameter("year", yearOfpublication).getResultList();
		for (VideoArt movie : movies) {
			System.out.println(movie.getName() + " " + movie.getYearOfpublication());
		}
		JpaHelper.commitTransaction();
	}

	public void listAllMoviesByActor(Celebrity actor) {
		JpaHelper.beginTransaction();
		List<VideoArt> movies = JpaHelper.getEntityManager()
				.createQuery("select m from VideoArt m join fetch m.actors a where a.id=:actor", VideoArt.class)
				.setParameter("actor", actor.getId()).getResultList();
		for (VideoArt movie : movies) {
			System.out.println(movie.getName() + " " + movie.getYearOfpublication());
		}
		JpaHelper.commitTransaction();
	}

	public void countAllTvSeries() {
		JpaHelper.beginTransaction();
		List<TvSeries> series = JpaHelper.getEntityManager().createQuery("select s from TvSeries s", TvSeries.class)
				.getResultList();
		System.out.println("Celkovy pocet Tv serialov v databaze je: " + series.size());
		JpaHelper.commitTransaction();
	}

	public void countAllMovies() {
		JpaHelper.beginTransaction();
		List<Movie> movies = JpaHelper.getEntityManager().createQuery("select m from Movie m", Movie.class)
				.getResultList();
		System.out.println("Celkovy pocet filmov v databaze je: " + movies.size());
		JpaHelper.commitTransaction();
	}

	public void listAllVideoByGener(Genre genre) {
		JpaHelper.beginTransaction();
		List<VideoArt> videos = JpaHelper.getEntityManager()
				.createQuery("select v from VideoArt v join fetch v.genres g where g.id=:genre", VideoArt.class)
				.setParameter("genre", genre.getId()).getResultList();
		for (VideoArt video : videos) {
			System.out.println(video.getName() + " " + video.getYearOfpublication() + " " + video.getGenres());
		}
		JpaHelper.commitTransaction();
	}

	public void listAllMoviesByReview(int rate) {
		JpaHelper.beginTransaction();
		List<Movie> movies = JpaHelper.getEntityManager()
				.createQuery("select m from Movie m join fetch m.reviews r where r.id!=null and r.rating>=:rate",
						Movie.class)
				.setParameter("rate", rate).getResultList();
		for (Movie movie : movies) {
			System.out.println(
					movie.getName() + " " + movie.getYearOfpublication() + " \nRecenzia:\n" + movie.getReviews());
		}
		JpaHelper.commitTransaction();
	}

	public void countMoviesDuration(Genre genre) {
		JpaHelper.beginTransaction();
		int count = 0;
		List<Movie> videos = JpaHelper.getEntityManager()
				.createQuery("select m from Movie m join fetch m.genres g where g.id=:genre", Movie.class)
				.setParameter("genre", genre.getId()).getResultList();
		for (Movie video : videos) {
			count = count + video.getLength();
		}
		System.out.println("V zadanom zanri filmy trvaju: " + count + "min.");
		JpaHelper.commitTransaction();
	}

	public void bestRankingMovie() {
		JpaHelper.beginTransaction();
		List<Movie> videos = JpaHelper.getEntityManager()
				.createQuery("select m from Movie m join fetch m.reviews r", Movie.class).getResultList();
		for (Movie video : videos) {
			System.out.println(video.getName() + " " + video.getYearOfpublication());
		}
		JpaHelper.commitTransaction();
	}
}
