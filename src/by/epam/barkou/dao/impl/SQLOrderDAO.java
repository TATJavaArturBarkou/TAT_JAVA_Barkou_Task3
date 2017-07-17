package by.epam.barkou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.epam.barkou.bean.Order;
import by.epam.barkou.dao.IOrderDAO;
import by.epam.barkou.dao.exception.DAOException;
import by.epam.barkou.dao.util.SQLConnection;

public class SQLOrderDAO implements IOrderDAO{
	private final static String SQL_ORDER_BOOK = "INSERT INTO orders (userId, bookId) VALUES (?,?)";

	private SQLConnection sqlConnection = SQLConnection.getInstance();
	
	@Override
	public void orderBook(Order order) throws DAOException {
		Connection connection = sqlConnection.getConnection();
		PreparedStatement ps = null;
		int userIdIndex = 1;
		int bookIdIndex = 2;
		try {
			ps = connection.prepareStatement(SQL_ORDER_BOOK);
			
			ps.setString(userIdIndex, order.getUserId());
			ps.setString(bookIdIndex, order.getBookId());
			ps.executeUpdate();

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {
			if (ps != null || connection != null) {
				try {
					ps.close();
					connection.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			}
		}
		
	}

}
