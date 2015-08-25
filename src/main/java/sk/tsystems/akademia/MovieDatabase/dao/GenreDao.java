package sk.tsystems.akademia.MovieDatabase.dao;

import java.util.List;

import sk.tsystems.akademia.MovieDatabase.model.Genre;
import sk.tsystems.akademia.MovieDatabase.model.JpaHelper;

public class GenreDao {
	
	public void createNewGenre(String name, String description){
		Genre genre=new Genre(name, description);
		JpaHelper.beginTransaction();
		JpaHelper.getEntityManager().persist(genre);
		JpaHelper.commitTransaction();
	}
	
	public void listAllGenres(){
		JpaHelper.beginTransaction();
		List<Genre> genres=JpaHelper.getEntityManager()
				.createQuery("select g from Genre g", Genre.class).getResultList();
		for (Genre genre : genres) {
			System.out.println(genre);
		}
		JpaHelper.commitTransaction();
	}
	
	public Genre find(long id) {
		return JpaHelper.getEntityManager().find(Genre.class, id);
	}
	

}
