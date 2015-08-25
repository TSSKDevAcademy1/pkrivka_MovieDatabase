package sk.tsystems.akademia.MovieDatabase.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Movie extends VideoArt {

	@Temporal(TemporalType.DATE)
	private Date publicationDate;
	private int length;

	public Movie() {

	}

	public Movie(String name, Date publicationDate, String yearOfpublication, int length) {
		super(name, yearOfpublication);
		this.publicationDate = publicationDate;
		this.length = length;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		// builder.append(super.toString());
		builder.append("Movie [publicationDate=");
		builder.append(publicationDate);
		builder.append(", length=");
		builder.append(length);
		builder.append("]");
		return builder.toString();
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
