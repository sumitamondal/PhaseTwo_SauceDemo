package stepdefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStepDef {

	WebDriver driver = Hooks.driver;

	@Given("I have launched the application")
	public void i_have_launched_the_application() {
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

	}

	@When("I enter the correct username and password")
	public void i_enter_the_correct_username_and_password() {
	   		
		WebElement UserName = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		UserName.sendKeys("problem_user");

		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys("secret_sauce");
	}

	@When("I clcik on Login Button")
	public void i_clcik_on_Login_Button() {
	   
		WebElement login =driver.findElement(By.xpath("//input[@name='login-button']"));
		login.click();
	}

	@Then("I should land on the home page")
	public void i_should_land_on_the_home_page() {
	   
	}

	@When("I enter the incorrect username and password")
	public void i_enter_the_incorrect_username_and_password() {
	   
		WebElement UserName = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		UserName.sendKeys("abc_xyz@gmail.com");
		
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys("Abc_efg");
	}

	@Then("I should get the error message {string}")
	public void i_should_get_the_error_message(String ExpError) {
	    
		WebElement Error = driver.findElement(By.xpath("//div[@class='error-message-container error']"));
		String ActError = Error.getText();
		Assert.assertEquals(ExpError, ActError);
	}



	
}
