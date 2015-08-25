package sk.tsystems.akademia.MovieDatabase.dao;

import sk.tsystems.akademia.MovieDatabase.model.JpaHelper;
import sk.tsystems.akademia.MovieDatabase.model.TvSeries;

public class TvSeriesDao {
	
	public void saveTvSeries(TvSeries tvseries){
		JpaHelper.beginTransaction();
		JpaHelper.getEntityManager().persist(tvseries);
		JpaHelper.commitTransaction();
	}
	
	public void createTvSeries(String name, String yearOfpublication, int seriesCount, int episodeCount, int startYear,
			int endYear){
		TvSeries tvseries=new TvSeries(name, yearOfpublication, seriesCount, episodeCount, startYear,
			endYear);
		JpaHelper.beginTransaction();
		JpaHelper.getEntityManager().persist(tvseries);
		JpaHelper.commitTransaction();
	}

}
