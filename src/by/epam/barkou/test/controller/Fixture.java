package by.epam.barkou.test.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.epam.barkou.controller.exception.ControllerException;
import by.epam.barkou.controller.security.Encryptor;
import by.epam.barkou.dao.exception.DAOException;
import by.epam.barkou.dao.util.SQLConnection;

public class Fixture {
	private final static String SQL_CREATE_USERS = "CREATE TABLE users(id INT not null AUTO_INCREMENT primary key, email VARCHAR(40) UNIQUE, password VARCHAR(40), role tinyint(1) DEFAULT 1, banned BOOL default 0);";
	private final static String SQL_CREATE_ORDERS = "CREATE TABLE orders (userId INT not null, bookId int not null, onHands bool default 0);";
	private final static String SQL_CREATE_ORDERS_KEY = "ALTER TABLE orders ADD FOREIGN KEY (userId) references users(id);";
	private final static String SQL_CREATE_BOOKS = "CREATE TABLE books (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(40) UNIQUE, availability BOOL DEFAULT 1);";
	private final static String SQL_DROP_TABLES = "DROP TABLE orders, users, books;";
	private final static String SQL_INSERT_ADMIN = "INSERT INTO users (email, password, role) VALUES (?,?,?)";
	
	private SQLConnection sqlConnection = SQLConnection.getInstance();

	public void createClearDB() {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = sqlConnection.getConnection();
			ps = connection.prepareStatement(SQL_CREATE_BOOKS);
			ps.executeUpdate();
	
			ps = connection.prepareStatement(SQL_CREATE_USERS);
			ps.executeUpdate();
			
			ps = connection.prepareStatement(SQL_CREATE_ORDERS);
			ps.executeUpdate();
			
			ps = connection.prepareStatement(SQL_CREATE_ORDERS_KEY);
			ps.executeUpdate();
			
		} catch (SQLException | DAOException e) {
			e.printStackTrace();

		} finally {
			if (ps != null || connection != null) {
				try {
					ps.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void dropDB() {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = sqlConnection.getConnection();
			ps = connection.prepareStatement(SQL_DROP_TABLES);
			ps.execute(SQL_DROP_TABLES);

		} catch (SQLException | DAOException e) {
			e.printStackTrace();

		} finally {
			if (ps != null || connection != null) {
				try {
					ps.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
	public void addAdminUser() {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = sqlConnection.getConnection();
			ps = connection.prepareStatement(SQL_DROP_TABLES);
			ps.execute(SQL_DROP_TABLES);

		} catch (SQLException | DAOException e) {
			e.printStackTrace();

		} finally {
			if (ps != null || connection != null) {
				try {
					ps.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void createAdminUser() {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = sqlConnection.getConnection();
			ps = connection.prepareStatement(SQL_INSERT_ADMIN);
			int userEmailIndex = 1; 
			int userPasswordIndex = 2;
			int userRoleIndex = 3;
			
			String admin = "admin@gmail.com";
			String password = "admin";
			int role = 2;
			
			try {
				password = Encryptor.encrypt("admin");
			} catch (ControllerException e) {
				e.printStackTrace();
			}
			
			
			
			ps.setString(userEmailIndex, admin);
			ps.setString(userPasswordIndex, password);
			ps.setInt(userRoleIndex, role);
			
			ps.executeUpdate();
	
			
		} catch (SQLException | DAOException e) {
			e.printStackTrace();

		} finally {
			if (ps != null || connection != null) {
				try {
					ps.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
