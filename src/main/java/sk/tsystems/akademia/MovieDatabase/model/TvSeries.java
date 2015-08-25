package sk.tsystems.akademia.MovieDatabase.model;

import javax.persistence.Entity;

@Entity
public class TvSeries extends VideoArt {

	private int seriesCount;
	private int episodeCount;
	private int startYear;
	private int endYear;

	public TvSeries() {

	}

	public TvSeries(String name, String yearOfpublication, int seriesCount, int episodeCount, int startYear,
			int endYear) {
		super(name, yearOfpublication);
		this.seriesCount = seriesCount;
		this.episodeCount = episodeCount;
		this.startYear = startYear;
		this.endYear = endYear;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("TvSeries [seriesCount=");
		builder.append(seriesCount);
		builder.append(", episodeCount=");
		builder.append(episodeCount);
		builder.append(", startYear=");
		builder.append(startYear);
		builder.append(", endYear=");
		builder.append(endYear);
		builder.append("]");
		return builder.toString();
	}

	public int getSeriesCount() {
		return seriesCount;
	}

	public void setSeriesCount(int seriesCount) {
		this.seriesCount = seriesCount;
	}

	public int getEpisodeCount() {
		return episodeCount;
	}

	public void setEpisodeCount(int episodeCount) {
		this.episodeCount = episodeCount;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getEndYear() {
		return endYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}

}
