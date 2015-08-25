package sk.tsystems.akademia.MovieDatabase.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private long id;
	@Temporal(TemporalType.DATE)
	private Date datetimeOfCreation;
	@ManyToOne
	private VideoArt reviewed;
	private int rating;
	@Column(length = 5000)
	private String text;

	public Review() {

	}

	public Review(Date datetimeOfCreation, int rating, String text) {
		super();
		this.datetimeOfCreation = datetimeOfCreation;
		this.rating = rating;
		this.text = text;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Review [id=");
		builder.append(id);
		builder.append(", datetimeOfCreation=");
		builder.append(datetimeOfCreation);
		builder.append(", reviewed=");
		builder.append(reviewed);
		builder.append(", rating=");
		builder.append(rating);
		builder.append(", text=");
		builder.append(text);
		builder.append("]");
		return builder.toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDatetimeOfCreation() {
		return datetimeOfCreation;
	}

	public void setDatetimeOfCreation(Date datetimeOfCreation) {
		this.datetimeOfCreation = datetimeOfCreation;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public VideoArt getReviewed() {
		return reviewed;
	}

	public void setReviewed(VideoArt reviewed) {
		this.reviewed = reviewed;
	}

}
