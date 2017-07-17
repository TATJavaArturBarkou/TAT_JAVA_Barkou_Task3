package by.epam.barkou.bean;

import java.io.Serializable;

public class Order implements Serializable{

	private static final long serialVersionUID = -5400276964669562791L;
	private String userId;
	private String bookId;
	private String onHands;

	public Order(String userId, String bookId) {
		this.userId = userId;
		this.bookId = bookId;
	
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getOnHands() {
		return onHands;
	}

	public void setOnHands(String onHands) {
		this.onHands = onHands;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((onHands == null) ? 0 : onHands.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Order other = (Order) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (onHands == null) {
			if (other.onHands != null)
				return false;
		} else if (!onHands.equals(other.onHands))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
