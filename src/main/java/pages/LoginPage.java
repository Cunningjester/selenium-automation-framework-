package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	private By usernameTextBox = By.id("username");
	private By passwordTextBox = By.id("login_password");
	private By loginButton = By.id("login-submit");
	private By signUpButton = By.cssSelector("a.sign-up-account");
	private By forgotPasswordButton = By.cssSelector("a[href='/user/forgotpassword']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUsername(String username) {
		driver.findElement(usernameTextBox).clear();
		driver.findElement(usernameTextBox).sendKeys("username");
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys("password");
	}
	public void clickLogin() {
		
		driver.findElement(loginButton).click();
		
	}
}
