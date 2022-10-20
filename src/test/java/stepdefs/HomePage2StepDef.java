package stepdefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class HomePage2StepDef {

	WebDriver driver = Hooks.driver;
	
	@When("I clcik Add To cart on product {string}")
	public void i_clcik_Add_To_cart_on_product(String ProductName) {
		
		String Xpath = "//div[text()='" +  ProductName + "']//following::button[1]";
		WebElement Item =driver.findElement(By.xpath(Xpath));
		Item.click();

		
	}

	@Then("Basket item number should be {int}")
	public void basket_item_number_should_be(Integer int1) {
	   
		WebElement CartItem =driver.findElement(By.xpath("//div/a/span[@class=\"shopping_cart_badge\"]"));
		String items=CartItem.getText();
		Assert.assertEquals(items, "1");
	}


}
