package by.epam.barkou.bean;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = -8225452666387003759L;
	private String idBook;
	private String name;
	private String availability;

	public Book(String name, String availability) {
		this.name = name;
		this.availability = availability;
	}

	public Book(String id) {
		this.idBook = id;
	}
	
	public Book(String idBook, String name, String availability) {
		this.name = name;
		this.idBook = idBook;
		this.availability = availability;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getIdBook() {
		return idBook;
	}

	public void setIdBook(String idBook) {
		this.idBook = idBook;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idBook == null) ? 0 : idBook.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (idBook == null) {
			if (other.idBook != null)
				return false;
		} else if (!idBook.equals(other.idBook))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [idBook=" + idBook + ", name=" + name + "]";
	}

}
