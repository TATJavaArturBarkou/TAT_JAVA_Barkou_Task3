package by.epam.barkou.dao;

import by.epam.barkou.bean.User;
import by.epam.barkou.dao.exception.DAOException;

public interface IUserDAO {
	User signIn(String login, String password) throws DAOException;

	void signUp(User user) throws DAOException;

	void updateProfile(User user) throws DAOException;

	void addAdminRights(String string) throws DAOException;

	void setUserBanned(String id, String bannedValue) throws DAOException;

	User getUser(String string) throws DAOException;
}
