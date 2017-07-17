package by.epam.barkou.test.controller;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class TestBase {
	
	@BeforeClass
	public void dropAndCreateDB() {
		Fixture fixture = new Fixture();
		fixture.dropDB();
		fixture.createClearDB();
		fixture.createAdminUser();
		
	}
	@DataProvider
	public Object[][] dp() {
		return new Object[][] {

				new Object[] { "add_book&Alice in Wonderland", "Book has been added successfully" },
				new Object[] { "update_book&1&Alice&1", "Book has been updated successfully" },
				new Object[] { "sign_up&barkou@mail.ru&password", "User is registred successfully" },
				new Object[] { "sign_in&barkou@mail.ru&password", "User has been signed into system" },
				
				new Object[] { "get_all_available_books&", "Alice in Wonderland&" }, 
				new Object[] { "show_profile&", "barkou@mail.ru" },
				new Object[] { "update_profile&barkou@mail.ru&password", "User is updated successfully" },
				new Object[] { "add_admin_rights&1", "User rights are updated successfully" },
				new Object[] { "set_user_banned&1&1", "User is updated successfully" },
				
				new Object[] { "order_book&1", "Book has been ordered" },
				new Object[] { "sign_out&", "User has been signed out" },
				new Object[] { "get_available_book&1", "Alice in Wonderland" },
				new Object[] { "get_user&1", "admin@gmail.com" },
				new Object[] { "get_book&1", "Alice in Wonderland" },
		};
	}
}
