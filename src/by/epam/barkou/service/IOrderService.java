package by.epam.barkou.service;

import by.epam.barkou.bean.Order;
import by.epam.barkou.service.exception.ServiceException;

public interface IOrderService {
	void orderBook(Order order) throws ServiceException;
}
