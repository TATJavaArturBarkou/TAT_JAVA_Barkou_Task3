package by.epam.barkou.service.factory;

import by.epam.barkou.service.IClientService;
import by.epam.barkou.service.ILibraryService;
import by.epam.barkou.service.IOrderService;
import by.epam.barkou.service.impl.ClientServiceImpl;
import by.epam.barkou.service.impl.LibraryServiceImpl;
import by.epam.barkou.service.impl.OrderServiceImpl;

public class ServiceFactory {
	public static final ServiceFactory instance = new ServiceFactory();
	private final IClientService clientService = new ClientServiceImpl();
	private final ILibraryService libraryService = new LibraryServiceImpl();
	private final IOrderService iOrderService = new OrderServiceImpl();
	private ServiceFactory() {

	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public IClientService getClientService() {
		return clientService;
	}

	public ILibraryService getLibraryService() {
		return libraryService;
	}
	public IOrderService getIOrderService() {
		return iOrderService;
	}
}
