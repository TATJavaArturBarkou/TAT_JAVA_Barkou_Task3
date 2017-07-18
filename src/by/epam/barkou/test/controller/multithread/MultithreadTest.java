package by.epam.barkou.test.controller.multithread;

import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.testng.annotations.Test;

import by.epam.barkou.controller.multithread.Dispatcher;
import by.epam.barkou.test.controller.TestBase;

public class MultithreadTest extends TestBase {

	private ArrayList<Dispatcher> inputThreadWithValuesList = new ArrayList<>();
	private ArrayList<String> expectedResultList = new ArrayList<>();
	private LinkedList<Future<String>> futuresList = new LinkedList<>();
	private LinkedList<Future<String>> actualResultList;
	private ExecutorService executorService = Executors.newCachedThreadPool();

	public String[][] dataProvider() {

		String[][] dp = {

				{ "sessionId=3b5hyk1&sign_in&admin@gmail.com&admin", "User has been signed into system" },

				{ "sessionId=3b5hyk1&add_book&Alice in Wonderland0&1", "Book has been added successfully" },
				{ "sessionId=3b5hyk1&add_book&Alice in Wonderland1&0", "Book has been added successfully" },
				{ "sessionId=3b5hyk1&add_book&Alice in Wonderland2&1", "Book has been added successfully" },

		};
		return dp;
	}

	public void fillDataArrays(String[][] dp) {

		for (int i = 0; i < dp.length; i++) {

			for (int z = 0; z < dp[i].length; z++) {

				if (z == 0) {
					inputThreadWithValuesList.add(new Dispatcher(dp[i][z]));

				} else {
					expectedResultList.add(dp[i][z]);
				}
			}
		}

	}

	public void signIn() {

		int firstCommand = 0;

		futuresList.add(executorService.submit(inputThreadWithValuesList.get(firstCommand)));

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void createThreads() {

		for (int i = 1; i < inputThreadWithValuesList.size(); i++) {

			futuresList.add(executorService.submit(inputThreadWithValuesList.get(i)));

		}
	}

	public void waitForThreadsAreDone() {
		int count = 0;
		int oneSecond = 1000;

		actualResultList = new LinkedList<>(futuresList);
		while (true) {

			if (!futuresList.isEmpty()) {

				if (futuresList.get(count).isDone() == true) {
					futuresList.poll();

				}
				try {
					Thread.sleep(oneSecond);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				break;
			}

		}
	}

	public void compareActualAndExpected() {
		try {

			for (int i = 0; i < actualResultList.size(); i++) {
				System.out.print(actualResultList.get(i).get() + " --- ");

				if (actualResultList.get(i).get().equals(expectedResultList.get(i))) {
					System.out.println(" " + true);
				} else {
					System.out.println(" " + false);
					fail("Actual result: '" + actualResultList.get(i).get() + "' NOT fits expected result: '"
							+ expectedResultList.get(i) + "' ");
				}

			}

		} catch (InterruptedException | ExecutionException e) {

			e.printStackTrace();
		}
	}

	@Test
	public void test() {

		fillDataArrays(dataProvider());
		signIn();
		createThreads();
		waitForThreadsAreDone();
		compareActualAndExpected();

	}
}
