import com.example.book.controller.UserInfo;
import com.example.book.db.Initialization;
import com.example.book.db.user.Login;
import com.example.book.db.user.ResetPasswordDb;
import com.example.book.view.MainFrame;
import com.example.book.view.ResetPassword;
import com.example.book.view.AddBook;
import com.example.book.view.LoginDialog;
import com.example.book.view.LoginDialog.LoginObject;
import com.example.book.view.ResetPassword.ResetPasswordCallbackParam;

public class App {
	// User
	static UserInfo user;

	private static LoginDialog LoginDialog;
	private static AddBook AddBookFrame;
	private static MainFrame mainFrame;
	private static ResetPassword ResetPasswordDialog;

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
				mainFrame.toggleAdmin(user.isAdmin);
				mainFrame.show();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void handleResetPassword() {
		mainFrame.hide();
		ResetPasswordDialog.show(user.uid);
	}

	private static void handleResetPasswordCallback(ResetPasswordCallbackParam returningData) {
		try {
			ResetPasswordDb.reset(returningData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResetPasswordDialog.hide();
		mainFrame.show();
	}

	private static void NavigateResetPasswordToMain() {
		ResetPasswordDialog.hide();
		mainFrame.show();
	}

	private static void handleExitSystem() {
		mainFrame.hide();
		user = null;
		LoginDialog.reset();
		LoginDialog.show();
	}

	public static void main(String[] args) throws Exception {
		Initialization.SmartCreate();
		LoginDialog = new LoginDialog(App::handleLogin);
		ResetPasswordDialog = new ResetPassword(App::handleResetPasswordCallback, App::NavigateResetPasswordToMain);
		LoginDialog.show();
		// Book book = new Book.BookBuilder("11")
		// .withName("name")
		// .withAuthor("author")
		// .build();
		// ;
		// Add.add(book);
		AddBookFrame = new AddBook();
		mainFrame = new MainFrame(App::handleResetPassword, App::handleExitSystem);
	}
}
