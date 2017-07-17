package by.epam.barkou.service.impl;

import by.epam.barkou.bean.User;
import by.epam.barkou.dao.IUserDAO;
import by.epam.barkou.dao.exception.DAOException;
import by.epam.barkou.dao.factory.DAOFactory;
import by.epam.barkou.service.IClientService;
import by.epam.barkou.service.exception.ServiceException;

public class ClientServiceImpl implements IClientService {
	DAOFactory daoObjectFactory = DAOFactory.getInstance();
	IUserDAO userDAO = daoObjectFactory.getUserDAO();
	User user;
	
	private final static String ERROR_INCORRECT_LOGIN = "Incorrect login";
	
	@Override
	public User signIn(String login, String password) throws ServiceException {
		// check parameters, e.g. length, special symbols
		
		if (login == null || login.isEmpty()) {
			throw new ServiceException(ERROR_INCORRECT_LOGIN);
		}
		try {
			 user = userDAO.signIn(login, password);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return user;
	}


	@Override
	public void signUp(User user) throws ServiceException {
		// check parameters, e.g. length, special symbols
		try {
			userDAO.signUp(user);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public void updateProfile(User user) throws ServiceException {
		// check parameters, e.g. length, special symbols
	
		try {
			userDAO.updateProfile(user);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public void addAdminRights(String id) throws ServiceException {
		try {
			userDAO.addAdminRights(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public void setUserBanned(String id, String bannedValue) throws ServiceException {
	
		try {
			userDAO.setUserBanned(id, bannedValue);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	
	}


	@Override
	public User getUser(String string) throws ServiceException {
		if (string == null || string.isEmpty()) {
			throw new ServiceException(ERROR_INCORRECT_LOGIN);
		}
		try {
			 user = userDAO.getUser(string);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return user;
	}

}
