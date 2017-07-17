package by.epam.barkou.bean;

import java.io.Serializable;

public class Session implements Serializable {

	private static final long serialVersionUID = -8900162898680818971L;
	private String sessionId;
	private int userId;
	private int userRole;

	public Session(String sessionId, int userId, int userRole) {
		this.sessionId = sessionId;
		this.userId = userId;
		this.userRole = userRole;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
		result = prime * result + userId;
		result = prime * result + userRole;
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
		Session other = (Session) obj;
		if (sessionId == null) {
			if (other.sessionId != null)
				return false;
		} else if (!sessionId.equals(other.sessionId))
			return false;
		if (userId != other.userId)
			return false;
		if (userRole != other.userRole)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Session [sessionId=" + sessionId + ", userId=" + userId + ", userRole=" + userRole + "]";
	}

	
}
