package sk.tsystems.akademia.MovieDatabase.dao;

import java.util.Date;

import sk.tsystems.akademia.MovieDatabase.model.Celebrity;
import sk.tsystems.akademia.MovieDatabase.model.JpaHelper;

public class CelebrityDao {
	
	public Celebrity find(long id) {
		return JpaHelper.getEntityManager().find(Celebrity.class, id);
	}
	
	public void createCelebrity(String firstname,String surname,Date dateOfBirth, String biography){
		Celebrity celebrity=new Celebrity(firstname, surname, dateOfBirth, biography);
		JpaHelper.beginTransaction();
		JpaHelper.getEntityManager().persist(celebrity);
		JpaHelper.commitTransaction();
	}
}
