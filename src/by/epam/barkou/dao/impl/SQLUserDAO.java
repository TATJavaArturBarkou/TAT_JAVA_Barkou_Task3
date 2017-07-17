package by.epam.barkou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.epam.barkou.bean.User;
import by.epam.barkou.dao.IUserDAO;
import by.epam.barkou.dao.exception.DAOException;
import by.epam.barkou.dao.util.SQLConnection;

public class SQLUserDAO implements IUserDAO {

	private SQLConnection sqlConnection = SQLConnection.getInstance();

	private final static String SQL_SIGN_IN = "SELECT id, email, password, role, banned FROM users WHERE email=? and password=?";
	private final static String SQL_SIGN_UP = "INSERT INTO users (email, password) VALUES (?,?)";
	private final static String SQL_UPDATE_PROFILE = "UPDATE users SET email=?, password=? WHERE id=?";
	private final static String SQL_ADD_ADMIN_RIGHTS = "UPDATE users SET role=2 WHERE id=?";
	private final static String SQL_SET_BANNED = "UPDATE users SET banned=? WHERE id=?";
	private final static String SQL_GET_USER = "SELECT id, email, password, role, banned FROM users WHERE id=?";


	
	@Override
	public User signIn(String login, String encryptedPassword) throws DAOException {
		Connection connection = sqlConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		User user = null;
		int userEmailIndex = 1;
		int userPasswordIndex = 2;
		String userId = "id";
		String email = "email";
		String password = "password";
		String role = "role";

		try {

			ps = connection.prepareStatement(SQL_SIGN_IN);

			ps.setString(userEmailIndex, login);
			ps.setString(userPasswordIndex, encryptedPassword);

			resultSet = ps.executeQuery();

			while (resultSet.next()) {

				user = new User(resultSet.getString(userId), resultSet.getString(email), resultSet.getString(password),
						Integer.parseInt(resultSet.getString(role)));

			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {
			if (ps != null || connection != null) {
				try {
					resultSet.close();
					ps.close();
					connection.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			}
		}
		return user;
	}

	@Override
	public void signUp(User user) throws DAOException {
		Connection connection = sqlConnection.getConnection();
		PreparedStatement ps = null;
		int userEmailIndex = 1; 
		int userPasswordIndex = 2;

		try {

			ps = connection.prepareStatement(SQL_SIGN_UP);

			ps.setString(userEmailIndex, user.getEmail());
			ps.setString(userPasswordIndex, user.getPassword());

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


	@Override
	public void updateProfile(User user) throws DAOException {
		Connection connection = sqlConnection.getConnection();
		PreparedStatement ps = null;
		int userEmailIndex = 1; 
		int userPasswordIndex = 2;
		int userIdIndex = 3;
		try {

			ps = connection.prepareStatement(SQL_UPDATE_PROFILE);

			ps.setString(userEmailIndex, user.getEmail());
			ps.setString(userPasswordIndex, user.getPassword());
			ps.setString(userIdIndex, user.getId());
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

	@Override
	public void addAdminRights(String string) throws DAOException {
		Connection connection = sqlConnection.getConnection();
		PreparedStatement ps = null;

		try {

			ps = connection.prepareStatement(SQL_ADD_ADMIN_RIGHTS);

			int id = Integer.parseInt(string);
			int userIdIndex = 1;
			
			ps.setInt(userIdIndex, id);
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

	@Override
	public void setUserBanned(String idValue, String bannedValue) throws DAOException {
		Connection connection = sqlConnection.getConnection();
		PreparedStatement ps = null;

		try {

			ps = connection.prepareStatement(SQL_SET_BANNED);

			int id = Integer.parseInt(idValue);
			int banned = Integer.parseInt(bannedValue);
			int userBannedIndex = 1;
			int userIdIndex = 2;
			
			
			ps.setInt(userBannedIndex, banned);
			ps.setInt(userIdIndex, id);
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

	@Override
	public User getUser(String string) throws DAOException {
		Connection connection = sqlConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		User user = null;
		int userIdIndex = 1;

		String userId = "id";
		String email = "email";
		String password = "password";
		String role = "role";

		try {

			ps = connection.prepareStatement(SQL_GET_USER);

			ps.setString(userIdIndex, string);
			

			resultSet = ps.executeQuery();

			while (resultSet.next()) {

				user = new User(resultSet.getString(userId), resultSet.getString(email), resultSet.getString(password),
						Integer.parseInt(resultSet.getString(role)));

			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {
			if (ps != null || connection != null) {
				try {
					resultSet.close();
					ps.close();
					connection.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			}
		}
		return user;
	}

}
