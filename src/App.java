import com.example.book.controller.UserInfo;
import com.example.book.db.Initialization;
import com.example.book.db.user.Login;
import com.example.book.db.user.ResetPasswordDb;
import com.example.book.utils.PortTester;
import com.example.book.view.Main;
import com.example.book.view.ResetPassword;
import com.example.book.view.UpdateBook;
import com.example.book.view.AddBook;
import com.example.book.view.BookQuery;
import com.example.book.view.LoginDialog;
import com.example.book.view.LoginDialog.LoginObject;
import com.example.book.view.ResetPassword.ResetPasswordCallbackParam;
import com.example.book.view.alerts.DbNotRunning;
import com.example.book.view.alerts.UnexpectedError;

public class App {
	// User
	static UserInfo user;

	private static LoginDialog LoginDialog;
	private static AddBook AddBookFrame;
	private static UpdateBook UpdateBookFrame;
	private static BookQuery QueryBookFrame;
	private static Main MainFrame;
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
				MainFrame.toggleAdmin(user.isAdmin);
				MainFrame.show();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void handleResetPassword() {
		MainFrame.hide();
		ResetPasswordDialog.show(user.uid);
	}

	private static void handleResetPasswordCallback(ResetPasswordCallbackParam returningData) {
		try {
			ResetPasswordDb.reset(returningData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResetPasswordDialog.hide();
		MainFrame.show();
	}

	private static void NavigateResetPasswordToMain() {
		ResetPasswordDialog.hide();
		MainFrame.show();
	}

	private static void handleExitSystem() {
		MainFrame.hide();
		user = null;
		LoginDialog.reset();
		LoginDialog.show();
	}

	private static void handleExitApp(int status) {
		System.out.println("Program exiting with status " + status + " . ");
		System.exit(status);
	}

	public static void main(String[] args) throws Exception {
		try {
			PortTester tester = new PortTester();
			if (!tester.isPortOpen("127.0.0.1", 3306)) {
				DbNotRunning.show(App::handleExitApp);
			} else {
				Initialization.SmartCreate();
				LoginDialog = new LoginDialog(App::handleLogin);
				ResetPasswordDialog = new ResetPassword(App::handleResetPasswordCallback,
						App::NavigateResetPasswordToMain);
				MainFrame = new Main(App::handleResetPassword, App::handleExitSystem);
				LoginDialog.show();
				AddBookFrame = new AddBook();
				UpdateBookFrame = new UpdateBook();
				QueryBookFrame = new BookQuery();
			}
		} catch (Exception e) {
			UnexpectedError.show(App::handleExitApp);
			System.exit(1);
		}
	}
}
