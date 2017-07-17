package by.epam.barkou.service;

import java.util.ArrayList;

import by.epam.barkou.bean.Book;
import by.epam.barkou.bean.Order;
import by.epam.barkou.service.exception.ServiceException;

public interface ILibraryService {
	void addNewBook(Book book) throws ServiceException;

	void updateBook(Book book) throws ServiceException;

	ArrayList<Book> getAllAvailableBooks() throws ServiceException;

	String getAvailableBook(Book book) throws ServiceException;

	
}
