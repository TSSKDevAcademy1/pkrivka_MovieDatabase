package sk.tsystems.akademia.MovieDatabase.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public abstract class VideoArt {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String yearOfpublication;
	@ManyToMany(cascade = CascadeType.ALL)
	List<Genre> genres = new ArrayList<>();
	@JoinTable(name="directors")@ManyToMany(cascade = CascadeType.ALL)
	List<Celebrity> directors = new ArrayList<>();
	@JoinTable(name="actors")@ManyToMany(cascade = CascadeType.ALL)
	List<Celebrity> actors = new ArrayList<>();
	@OneToMany(mappedBy = "reviewed", cascade = CascadeType.ALL)
	List<Review> reviews = new ArrayList<>();
	@ElementCollection
	private List<String> additionalInfo = new ArrayList<>();

	public VideoArt() {

	}

	public VideoArt(String name, String yearOfpublication) {
		super();
		this.name = name;
		this.yearOfpublication = yearOfpublication;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VideoArt [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", yearOfpublication=");
		builder.append(yearOfpublication);
		builder.append(", genres=");
		builder.append(genres);
		builder.append(", directors=");
		builder.append(directors);
		builder.append(", actors=");
		builder.append(actors);
		builder.append(", reviews=");
		builder.append(reviews);
		builder.append(", additionalInfo=");
		builder.append(additionalInfo);
		builder.append("]");
		return builder.toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYearOfpublication() {
		return yearOfpublication;
	}

	public void setYearOfpublication(String yearOfpublication) {
		this.yearOfpublication = yearOfpublication;
	}

	public List<String> getAdditionalInfo() {
		return additionalInfo;
	}

	public void addAdditionalInfo(String addInfo) {
		additionalInfo.add(addInfo);
	}

	public void setAdditionalInfo(List<String> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void addGenres(Genre genre) {
		genres.add(genre);
	}

	public List<Celebrity> getDirectors() {
		return directors;
	}

	public void addDirectors(Celebrity director) {
		directors.add(director);
	}

	public List<Celebrity> getActors() {
		return actors;
	}

	public void addActors(Celebrity actor) {
		actors.add(actor);
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReviews(Review review) {
		reviews.add(review);
		review.setReviewed(this);
	}

}
