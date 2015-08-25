package sk.tsystems.akademia.MovieDatabase;

import java.util.Date;

import sk.tsystems.akademia.MovieDatabase.dao.CelebrityDao;
import sk.tsystems.akademia.MovieDatabase.dao.GenreDao;
import sk.tsystems.akademia.MovieDatabase.dao.MovieDao;
import sk.tsystems.akademia.MovieDatabase.dao.TvSeriesDao;
import sk.tsystems.akademia.MovieDatabase.dao.VideoArtDao;
import sk.tsystems.akademia.MovieDatabase.model.Celebrity;
import sk.tsystems.akademia.MovieDatabase.model.Genre;
import sk.tsystems.akademia.MovieDatabase.model.JpaHelper;
import sk.tsystems.akademia.MovieDatabase.model.Movie;
import sk.tsystems.akademia.MovieDatabase.model.Review;
import sk.tsystems.akademia.MovieDatabase.model.TvSeries;

public class App {
	public static void main(String[] args) {
		/**
		 * DAO objekty
		 */
		MovieDao moviedao = new MovieDao();
		TvSeriesDao tvseriesdao = new TvSeriesDao();
		VideoArtDao videoartdao=new VideoArtDao();
		CelebrityDao celebritydao=new CelebrityDao();
		GenreDao genredao=new GenreDao();
		
		genredao.listAllGenres();
//		/**
//		 * SELECTY
//		 */
//		//1.)
//		videoartdao.listAllMoviesByYear("2008");
//		//2.)
//		Celebrity actor;
//		actor=celebritydao.find(83);
//		videoartdao.listAllMoviesByActor(actor);
//		//3.)
//		videoartdao.countAllTvSeries();
//		//4.)
//		videoartdao.countAllMovies();
//		//5.)
//		Genre genre;
//		genre=genredao.find(84);
//		videoartdao.listAllVideoByGener(genre);
//		//6.)
//		videoartdao.listAllMoviesByReview(5);
//		//7.)
//		genre=genredao.find(84);
//		videoartdao.countMoviesDuration(genre);
//		//8.)
//		videoartdao.bestRankingMovie();
//		/**
//		 * Naplnenie databazy.
//		 */
//		// CELEBRITY
//		// hral v hra na hrane
//		Celebrity celebrity1 = new Celebrity("Ben", "Affleck", new Date(),
//				"Ben Affleck bol po dlhú dobu braný iba ako kolega Matta Damona, no časom si vybudoval reputáciu skvelého herca");
//		// aj herec aj reziser gran torino
//		Celebrity celebrity2 = new Celebrity("Clint", "Eastwood", new Date(),
//				"Clint Eastwood vyrastal v chodobnej, robotníckej rodine.");
//		// hral v sedem
//		Celebrity celebrity3 = new Celebrity("Brad", "Pitt", new Date(),
//				"Brad sa narodil v Oklahome a vyrástol v mestečku Springfield.");
//		Celebrity celebrity4 = new Celebrity("Tom", "Hanks", new Date(),
//				"Hanksova filmová kariéra začala v komediích, v kterých si získal publikum.");
//		// reyiser forrest
//		Celebrity celebrity5 = new Celebrity("Robert", "Zemeckis", new Date(),
//				"Okuliarnatý vizionár, producent, vedúci výroby, scenárista, režisér, tvorca amerických filmov.");
//		// reziser temny rytier
//		Celebrity celebrity6 = new Celebrity("Christopher", "Nolan", new Date(),
//				"Christopher Nolan se narodil 30. července 1970 v Londýně britskému otci a americké matce.");
//		// forrest herecka
//		Celebrity celebrity7 = new Celebrity("Robin", "Wright", new Date(),
//				"Bývalá modelka se nejprve (jak už to tak bývá) uchytila v televizních seriálech.");
//		// hrala v sedem
//		Celebrity celebrity8 = new Celebrity("Gwyneth", "Paltrow", new Date(),
//				"Gwyneth bola od malička obklopená svetom filmu a hollywoodskej smotánky.");
//		// GENRE
//		Genre genre1 = new Genre();
//		genre1.setName("akcny");
//		genre1.setDescription("Predovsetkym akcne sekvencie.");
//		Genre genre2 = new Genre();
//		genre2.setName("horor");
//		genre2.setDescription("Ulohou je vydesit divaka.");
//		Genre genre3 = new Genre();
//		genre3.setName("drama");
//		genre3.setDescription("Boj dobra a zla.");
//		Genre genre4 = new Genre();
//		genre4.setName("komedia");
//		genre4.setDescription("Ulohou je rozosmiat divaka.");
//		Genre genre5 = new Genre();
//		genre5.setName("romanticky");
//		genre5.setDescription("Filmy o laske.");
//		// REVIEW
//		Review review1 = new Review(new Date(), 4,
//				"Bez šťavy. Podobných žánroviek, ale strhujúcejších a nápaditejších sú húfy");
//		Review review2 = new Review(new Date(), 8,
//				"Tenhle film je protě dokonalost sama. A nejen proto, že jsem se díky němu stala filmovým fandou.");
//		Review review3 = new Review(new Date(), 9,
//				"Naprosto dokonalá režie dokázala z výborného scénáře udělat tento film tím nejlepším v krimi žánru co jsem viděl.");
//		Review review4 = new Review(new Date(), 10, "Ten film je v podstatě jen velká šablona, ale zpracovaná naprosto bravurně a s přehledem.");
//		Review review5 = new Review(new Date(), 7, "Láska, pomsta, šílenství, anarchie, chaos a jedna stylová motorka. Brilantní.");
//		// MOVIE
//		Movie movie1 = new Movie("Hra na hrane", new Date(), "2013", 91);
//		movie1.addGenres(genre1);
//		movie1.addGenres(genre4);
//		movie1.addActors(celebrity1);
//		movie1.addReviews(review1);
//		Movie movie2 = new Movie("Forrest Gump", new Date(), "1994", 142);
//		movie2.addGenres(genre3);
//		movie2.addGenres(genre4);
//		movie2.addActors(celebrity4);
//		movie2.addActors(celebrity7);
//		movie2.addReviews(review2);
//		Movie movie3 = new Movie("Sedem", new Date(), "1995", 127);
//		movie3.addGenres(genre1);
//		movie3.addGenres(genre3);
//		movie3.addActors(celebrity3);
//		movie3.addActors(celebrity8);
//		movie3.addReviews(review3);
//		Movie movie4 = new Movie("Gran Torino", new Date(), "2008", 116);
//		movie4.addGenres(genre3);
//		movie4.addActors(celebrity2);
//		movie4.addDirectors(celebrity2);
//		movie4.addReviews(review4);
//		Movie movie5 = new Movie("Temny rytier", new Date(), "2008", 152);
//		movie5.addGenres(genre1);
//		movie5.addGenres(genre2);
//		movie5.addGenres(genre3);
//		movie5.addDirectors(celebrity6);
//		movie5.addReviews(review5);
//		// TVSERIES
//		TvSeries series1 = new TvSeries("Simpsonovci", "1.1.1989", 50, 19, 1989, 2015);
//		TvSeries series2 = new TvSeries("Game of Thrones", "1.1.2011", 3, 50, 2011, 2020);
//		TvSeries series3 = new TvSeries("Mr. Bean", "1.1.1990", 20, 14, 1990, 2000);
//		TvSeries series4 = new TvSeries("Život", "1.1.2009", 5, 10, 2009, 2013);
//		TvSeries series5 = new TvSeries("Adams Family", "1.1.1964", 15, 64, 1964, 1990);
//		/**
//		 * Ulozenie do databazy.
//		 */
//		moviedao.saveMovie(movie1);
//		moviedao.saveMovie(movie2);
//		moviedao.saveMovie(movie3);
//		moviedao.saveMovie(movie4);
//		moviedao.saveMovie(movie5);
//		tvseriesdao.saveTvSeries(series1);
//		tvseriesdao.saveTvSeries(series2);
//		tvseriesdao.saveTvSeries(series3);
//		tvseriesdao.saveTvSeries(series4);
//		tvseriesdao.saveTvSeries(series5);

		JpaHelper.close();
	}
}
