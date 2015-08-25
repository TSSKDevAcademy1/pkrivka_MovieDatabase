package sk.tsystems.akademia.MovieDatabase.dao;

import java.util.Date;

import sk.tsystems.akademia.MovieDatabase.model.JpaHelper;
import sk.tsystems.akademia.MovieDatabase.model.Movie;

public class MovieDao {
	
	public void saveMovie(Movie movie){
		JpaHelper.beginTransaction();
		JpaHelper.getEntityManager().persist(movie);
		JpaHelper.commitTransaction();
	}
	
	public void createMovie(String name, Date publicationDate, String yearOfpublication, int length){
		Movie movie=new Movie(name, publicationDate, yearOfpublication, length);
		JpaHelper.beginTransaction();
		JpaHelper.getEntityManager().persist(movie);
		JpaHelper.commitTransaction();
	}
}
