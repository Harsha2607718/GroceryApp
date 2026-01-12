package constant;

public class Constant {
	public static final String TESTDATAFILE = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xlsx";
	public static final String APPLE = System.getProperty("user.dir") + "\\src\\test\\resources\\tomato.jpg";
	public static final String CONFIGFILE = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\config.properties";
	public static final String ADMINUSERS_ERROR = "FAILURE: Neither the user creation success alert nor the existing user alert was displayed.";
	public static final String CONTACTUS_ERROR = "FAILURE: Success alert was not displayed correctly after updating contact details.";
	public static final String VALIDLOGIN_ERROR = "FAILURE: User login failed despite using valid credentials.";
	public static final String LOGININCORRECTPASSWORD_ERROR = "FAILURE: Invalid credentials alert was not displayed for correct username and incorrect password.";
	public static final String LOGININCORRECTUNAME_ERROR = "FAILURE: Invalid credentials alert was not displayed for incorrect username and correct password.";
	public static final String INVALIDLOGIN_ERROR = "FAILURE: Invalid credentials alert was not displayed for incorrect username and incorrect password.";
	public static final String LOGOUT_ERROR = "FAILURE: User logout was unsuccessful.";
	public static final String MANAGECATEGORY_ERROR = "FAILURE: Neither the new category success alert nor the existing category alert was displayed.";
	public static final String MANAGEFOOTER_ERROR = "FAILURE: Success alert was not displayed correctly after updating the footer text.";
	public static final String MANAGENEWS_ERROR = "FAILURE: Success alert was not displayed correctly after creating the news.";
}
