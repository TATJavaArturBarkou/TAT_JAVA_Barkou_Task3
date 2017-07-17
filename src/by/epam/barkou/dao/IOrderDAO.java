package by.epam.barkou.dao;

import by.epam.barkou.bean.Order;
import by.epam.barkou.dao.exception.DAOException;

public interface IOrderDAO {

	void orderBook(Order order) throws DAOException;

}
