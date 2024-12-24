import com.example.book.controller.Book;
import com.example.book.db.Initialization;
import com.example.book.db.books.Add;
import com.example.book.db.user.Login;
import com.example.book.db.user.Login.UserInfo;
import com.example.book.view.MainFrame;
import com.example.book.view.AddBook;
import com.example.book.view.LoginDialog;
import com.example.book.view.LoginDialog.LoginObject;

public class App {
	// User
	static UserInfo user;

	private static LoginDialog LoginDialog;
	private static AddBook AddBookFrame;
	private static MainFrame mainFrame;

	private static void handleLogin(LoginObject loginObject) {
		try {
			UserInfo retUser = Login.login(loginObject.getUsername(), loginObject.getPassword());
			if (retUser.uid == -1) {
				LoginDialog.showPasswordError();
				return;
			} else {
				user = retUser;
				LoginDialog.hidePasswordError();
				LoginDialog.close();
				if (user.isAdmin)
					mainFrame.isAdmin = true;
				mainFrame.show();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void handleExitSystem() {
		mainFrame.hide();
		user = null;
		LoginDialog.reset();
		LoginDialog.show();
	}

	private static void handleCloseApp() {
		System.exit(0);
	}

	public static void main(String[] args) throws Exception {
		Initialization.SmartCreate();
		LoginDialog = new LoginDialog(App::handleLogin, App::handleCloseApp);
		LoginDialog.show();
		// Book book = new Book.BookBuilder("11")
		// .withName("name")
		// .withAuthor("author")
		// .build();
		// ;
		// Add.add(book);
		AddBookFrame = new AddBook();
		mainFrame = new MainFrame(App::handleExitSystem);
	}
}
