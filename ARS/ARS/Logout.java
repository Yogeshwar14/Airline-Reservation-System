package ARS;

public class Logout {
	public static void logOut(Mainpage mainpage) {
		LoginSession.isloggedin = false;
		LoginSession.isAdmin = false;
		//mainpage.setVisible(true);
		//loginform.setVisible(true);
	}
	
}
