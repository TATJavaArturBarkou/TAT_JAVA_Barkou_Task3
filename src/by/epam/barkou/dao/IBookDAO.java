package by.epam.barkou.dao;

import java.util.ArrayList;

import by.epam.barkou.bean.Book;
import by.epam.barkou.dao.exception.DAOException;

public interface IBookDAO {
	void addBook(Book book) throws DAOException;

	void updateBook(Book book) throws DAOException;

	ArrayList<Book> getAllAvailableBooks() throws DAOException;

	String getAvailableBook(Book book) throws DAOException;
}
