package by.epam.barkou.service.impl;

import java.util.ArrayList;

import by.epam.barkou.bean.Book;
import by.epam.barkou.bean.Order;
import by.epam.barkou.dao.IBookDAO;
import by.epam.barkou.dao.exception.DAOException;
import by.epam.barkou.dao.factory.DAOFactory;
import by.epam.barkou.service.ILibraryService;
import by.epam.barkou.service.exception.ServiceException;

public class LibraryServiceImpl implements ILibraryService {
	DAOFactory daoObjectFactory = DAOFactory.getInstance();
	IBookDAO bookDAO = daoObjectFactory.getBookDAO();
	boolean response;
	
	private final static String ERROR_INCORRECT_BOOK_DATA = "Incorrect book data";
	
	@Override
	public void addNewBook(Book book) throws ServiceException {

		// check parameters, e.g. length, special symbols

		if (book == null || book.getName().isEmpty()) {
			throw new ServiceException(ERROR_INCORRECT_BOOK_DATA);
		}
		try {
			bookDAO.addBook(book);
			
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		
	
	}

	@Override
	public void updateBook(Book book) throws ServiceException {
		// check parameters, e.g. length, special symbols
		if (book == null || book.getName().isEmpty()) {
			throw new ServiceException(ERROR_INCORRECT_BOOK_DATA);
		}
		try {
			bookDAO.updateBook(book);
			
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public ArrayList<Book> getAllAvailableBooks() throws ServiceException {

		try {
			return bookDAO.getAllAvailableBooks();
			
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

	@Override
	public String getAvailableBook(Book book) throws ServiceException {
		try {
			return bookDAO.getAvailableBook(book);
			
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}



}
