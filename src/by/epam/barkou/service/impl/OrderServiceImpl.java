package by.epam.barkou.service.impl;

import by.epam.barkou.bean.Order;
import by.epam.barkou.dao.IOrderDAO;
import by.epam.barkou.dao.exception.DAOException;
import by.epam.barkou.dao.factory.DAOFactory;
import by.epam.barkou.service.IOrderService;
import by.epam.barkou.service.exception.ServiceException;

public class OrderServiceImpl implements IOrderService {
	DAOFactory daoObjectFactory = DAOFactory.getInstance();
	IOrderDAO orderDAO = daoObjectFactory.getOrderDAO();
	boolean response;
	
	@Override
	public void orderBook(Order order) throws ServiceException {
		// check parameters, e.g. length, special symbols


		try {
			orderDAO.orderBook(order);
			
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}
}
