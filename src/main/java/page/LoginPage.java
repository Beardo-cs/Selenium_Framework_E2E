package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class LoginPage extends BasePage {
   

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        inputUsername(username);
        System.out.println("Fetch the Locator from Yaml file " + getLocator("userName"));
        inputPassword(password);
        clickLoginButton();
    }

    private void inputUsername(String email) {
        sendKeys(By.id("loginusername"), email);
    }

    private void inputPassword(String password) {
        sendKeys(By.id("loginpassword"), password);
    }

    private void clickLoginButton() {
        click(By.xpath("//button[@onclick='logIn()']"));
    }
}
