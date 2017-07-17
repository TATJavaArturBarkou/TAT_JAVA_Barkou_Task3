package by.epam.barkou.service;

import by.epam.barkou.bean.User;
import by.epam.barkou.service.exception.ServiceException;

public interface IClientService {
	User signIn(String login, String encryptedPassword) throws ServiceException;

	void signUp(User user) throws ServiceException;

	void updateProfile(User user) throws ServiceException;

	void addAdminRights(String string) throws ServiceException;

	void setUserBanned(String string, String string2)throws ServiceException;

	User getUser(String string) throws ServiceException;

}
