package com.assignment.automation.stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.assignment.automation.base.BaseClass;


//import com.assignment.automation.base.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;

public class Assignment_stepdefination extends BaseClass  {
	
	public static WebElement element;
	public static Actions  action;
	public static String  actualTitle;
	public static String  expectedTitle;
	@Test
	@Given("^navigate to shopping site$")
	public void navigate_to_shopping_site() throws Throwable {
		 
		machint_launchBrowser("Chrome","http://automationpractice.com/index.php");
		
	}
	@Test
	@And("^scroll to Best sellers$")
	public void scroll_to_Best_sellers() throws Throwable {
	    
		
		
		 JavascriptExecutor js = (JavascriptExecutor)driver;
         js.executeScript("window.scrollBy(0,500)"); 
	    
	}
@Test
	@And("^validate Best sellers title$")
	public void validate_Best_sellers_title() throws Throwable {
		
		driver.findElement(By.xpath("//a[@class='blockbestsellers']")).click();
		 actualTitle =  driver.findElement(By.xpath("//a[contains(text(),'Best Sellers')]")).getText();
		 
		 expectedTitle = "BEST SELLERS";
	    Assert.assertEquals( actualTitle, expectedTitle);
	    
	}
@Test
	@Given("^enter the search item$")
	public void enter_the_search_item() throws Throwable {
		
	    driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		action = new Actions(driver);
		      element = driver.findElement(By.id("search_query_top"));
		             action.moveToElement(element) ; 
		             element.click();
		             element.sendKeys("Dresses");
		             element.sendKeys(Keys.ENTER);
          	  
               	    
	}
@Test
	@And("^validate search title$")
	public void validate_search_title() throws Throwable {
	    
	String text = driver.findElement(By.xpath("//span[@class='lighter']")).getText();
	 actualTitle = text.substring(1, text.length()-1);
	 System.out.println("Actual title is:" + actualTitle);
      
     
	
	    
	}
@Test
	@Given("^select a item$")
	public void select_a_item() throws Throwable {
	    
		// JavascriptExecutor js = (JavascriptExecutor)driver;
        // js.executeScript("window.scrollBy(0,500)");
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
         action = new Actions(driver);
       element = driver.findElement(By.xpath("(//*[@title='Printed Dress'])[5]"));
                action.moveToElement(element).perform();
         
	    
	}
@Test
	@Then("^click on add to cart$")
	public void click_on_add_to_cart() throws Throwable {
	    
	 element =	driver.findElement(By.xpath("(//*[@data-id-product='3'])[1]"));
	 element.click();
	    
	}

@Test
	@And("^click on proceed to checkout$")
	public void click_on_proceed_to_checkout() throws Throwable {
		
		
		element = driver.findElement(By.xpath("//a[@class='btn btn-default button button-medium']"));
		element.click();
	    
	}
@Test
	@And("^validate your shopping cart title$")
	public void validate_your_shopping_cart_title() throws Throwable {
	    Thread.sleep(2000);
	   actualTitle =  driver.findElement(By.xpath(" //*[@id=\"columns\"]/div[1]/span[2]")).getText();
	   System.out.println("shopping cart title is:"+actualTitle);
	   expectedTitle = "Your shopping cart";
	   Assert.assertEquals( actualTitle, expectedTitle);
	    
	}
@Test
	@Given("^contact us$")
	public void contact_us() throws Throwable {
	  element = 	driver.findElement(By.xpath("//a[@title='Contact Us']"));
	  element.click();
	    
	}
@Test
	@Then("^validate title$")
	public void validate_title() throws Throwable {
	    
		actualTitle =	driver.findElement(By.xpath("//h1[@class='page-heading bottom-indent']")).getText();
		
		  expectedTitle =  "CUSTOMER SERVICE - CONTACT US";
		  Assert.assertEquals( actualTitle, expectedTitle);
	}
@Test
	@And("^Select subject heading$")
	public void select_subject_heading() throws Throwable {
	    
		Select se = new Select(driver.findElement(By.xpath("//select[@id='id_contact']")));
		se.selectByIndex(1);
	    
	}
@Test
	@And("^Enter Email address$")
	public void enter_Email_address() throws Throwable {
	    
		element = driver.findElement(By.xpath("//input[@id='email']"));
		element.sendKeys("thota.vijay1@gmail.com");
		  	
	}
@Test
	@And("^Enter order refference$")
	public void enter_order_refference() throws Throwable {
		
	element=	driver.findElement(By.xpath("//input[@name='id_order']"));
	    element.sendKeys("Order456");
	    
	   
	}
@Test	
	@And("^Enter Message$")
	public void enter_Message() throws Throwable {
		 element  =	driver.findElement(By.id("message"));
			element.sendKeys("Heloo welcome to  E-shopping site");
	    
	}
@Test
	@And("^Attach file$")
	public void attach_file() throws Throwable {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
         js.executeScript("window.scrollBy(0,700)"); 
         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 element = driver.findElement(By.xpath("//*[@id='fileUpload']"));
		 element.sendKeys("C:\\Users\\User1\\Pictures\\Testimage.jpeg");
		 
	    
	}
@Test
	@And("^click on send$")
	public void click_on_send() throws Throwable {
	
	element  =	driver.findElement(By.xpath("//button[@id='submitMessage']"));
	element.click();
	
	    
	}
	
@Test	
	@And("^validate Success message$")
	public void validate_Success_message() throws Throwable {
	    
		actualTitle =	driver.findElement(By.xpath("//*[@id='center_column']//p['text()']")).getText();
		 expectedTitle =  "Your message has been successfully sent to our team.";
		 // System.out.println("Actual success message"+actualTitle );
		 Assert.assertEquals( actualTitle, expectedTitle);
		
	}

@Test
	@Given("^click on sign in$")
	public void click_on_sign_in() throws Throwable {
		
		
		element  =	driver.findElement(By.xpath("//*[@title='Log in to your customer account']"));
		element.click();
	    
	}
	
@Test
	@When("^User enter email$")
	public void user_enter_email() throws Throwable {
	    
		
		element  =	driver.findElement(By.id("email_create"));
		element.sendKeys("aaa@gmail");
	    
	}
@Test
	@Then("^click on create account$")
	public void click_on_create_account() throws Throwable {
		
		element  =	driver.findElement(By.id("SubmitCreate"));
		element.click();
		Thread.sleep(1000);
		
	}
@Test
	@And("^validate the message$")
	public void validate_the_message() throws Throwable {
              
	            
	
				actualTitle =	driver.findElement(By.xpath("//div[@class='alert alert-danger']//li[text()]")).getText();
				System.out.println("message is:"+actualTitle);
				  expectedTitle =  "Invalid email address.";
				 Assert.assertEquals( actualTitle, expectedTitle);
	    driver.quit();
	}

     
}
