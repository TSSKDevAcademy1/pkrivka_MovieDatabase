package sk.tsystems.akademia.MovieDatabase.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Celebrity {

	@Id
	@GeneratedValue
	private long id;
	private String firstname;
	private String surname;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Column(length = 3000)
	private String biography;
	@ManyToMany(mappedBy = "directors", cascade = CascadeType.ALL)
	private List<VideoArt> directed = new ArrayList<>();
	@ManyToMany(mappedBy = "actors", cascade = CascadeType.ALL)
	private List<VideoArt> actedAt = new ArrayList<>();

	public Celebrity() {

	}

	public Celebrity(String firstname, String surname, Date dateOfBirth, String biography) {
		super();
		this.firstname = firstname;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.biography = biography;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Celebrity [id=");
		builder.append(id);
		builder.append(", firstname=");
		builder.append(firstname);
		builder.append(", surname=");
		builder.append(surname);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append(", biography=");
		builder.append(biography);
		builder.append(", directed=");
		builder.append(directed);
		builder.append(", actedAt=");
		builder.append(actedAt);
		builder.append("]");
		return builder.toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public List<VideoArt> getDirected() {
		return directed;
	}

	public void addDirected(VideoArt direct) {
		directed.add(direct);
		direct.addDirectors(this);
	}

	public List<VideoArt> getActedAt() {
		return actedAt;
	}

	public void addActedAt(VideoArt actAt) {
		actedAt.add(actAt);
		actAt.addActors(this);
	}

}
