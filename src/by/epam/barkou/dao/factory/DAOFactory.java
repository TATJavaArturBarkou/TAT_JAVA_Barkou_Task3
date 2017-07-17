package by.epam.barkou.dao.factory;

import by.epam.barkou.dao.IBookDAO;
import by.epam.barkou.dao.IOrderDAO;
import by.epam.barkou.dao.IUserDAO;
import by.epam.barkou.dao.impl.SQLBookDAO;

import by.epam.barkou.dao.impl.SQLOrderDAO;
import by.epam.barkou.dao.impl.SQLUserDAO;


public final class DAOFactory {
	private static final DAOFactory INSTANCE = new DAOFactory();

	private final IBookDAO sqlBookImpl = new SQLBookDAO();
	private final IUserDAO sqlUserImpl = new SQLUserDAO();
	private final IOrderDAO sqlOrderImpl = new SQLOrderDAO();
	
	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return INSTANCE;
	}

	public IBookDAO getBookDAO() {
		return sqlBookImpl;
	}
	public IUserDAO getUserDAO() {
		return sqlUserImpl;
	}
	public IOrderDAO getOrderDAO() {
		return sqlOrderImpl;
	}
}
