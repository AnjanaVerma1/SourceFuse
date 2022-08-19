package com.java.pom;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class TestPage extends Page{

	@BeforeTest
	public void launchBrowser() {
	System.out.println("launching Chrome browser");
	System.setProperty("webdriver.chrome.driver", driverPath);
	driver = new ChromeDriver();
	driver.get(baseUrl);
	driver.manage().window().maximize();
	}
	
	public String generateRandomEmail() {
        String email = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder A = new StringBuilder();
        Random rnd = new Random();
        while (A.length() < 10) { 
            int index = (int) (rnd.nextFloat() * email.length());
            A.append(email.charAt(index));
        }
        String saltStr = A.toString();
        return saltStr;

    }
	
	
	@Test
	public void signIn() {
		WebElement button_signIn =driver.findElement(By.linkText(buttonSignIn));  
		button_signIn.click();
		WebElement textbox_email = driver.findElement(By.xpath("//input[@id='email_create']"));
		textbox_email.click();
		textbox_email.sendKeys(generateRandomEmail()+"@gmail.com");
		WebElement button_create_account= driver.findElement(By.id("SubmitCreate"));
		button_create_account.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement Title_radio_button=driver.findElement(By.xpath("//*[@class='radio' and @id='uniform-id_gender2']"));
		Title_radio_button.click();
		WebElement First_name=driver.findElement(By.id("customer_firstname"));
		First_name.sendKeys("Anjana");
		WebElement Last_name=driver.findElement(By.id("customer_lastname"));
		Last_name.sendKeys("Verma");
		WebElement password=driver.findElement(By.id("passwd"));
		password.sendKeys("anjver");
		Select Date = new Select(driver.findElement(By.id("days")));
		Date.selectByValue("1");
		Select Month = new Select(driver.findElement(By.id("months")));
		Month.selectByValue("5");
		Select Year = new Select(driver.findElement(By.name("years")));
		Year.selectByValue("1995");
		WebElement Company= driver.findElement(By.id("company"));
		Company.click();
		Company.sendKeys("Sourcefuse");
		WebElement Address= driver.findElement(By.id("address1"));
		Address.sendKeys("Sector 70, Mohali");
		WebElement City= driver.findElement(By.id("city"));
		City.sendKeys("Mohali");
		Select State=new Select(driver.findElement(By.id("id_state")));
		State.selectByVisibleText("California");
		WebElement pincode= driver.findElement(By.id("postcode"));
		pincode.sendKeys("90212");
		WebElement contactnumber=driver.findElement(By.id("phone_mobile"));
		contactnumber.sendKeys("89765466655");
		WebElement register_button=driver.findElement(By.xpath("//button[@id='submitAccount']"));
		register_button.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement Women_button=driver.findElement(By.xpath("//a[@title='Women']"));
		Actions hoverAction = new Actions(driver);
		hoverAction.moveToElement(Women_button).perform();
		WebElement SummerDresses=driver.findElement(By.xpath("//a[@Title='Summer Dresses'][1]"));
		SummerDresses.click();
		WebElement sizeCheckboxM=driver.findElement(By.xpath("//input[@id='layered_id_attribute_group_2']"));
		sizeCheckboxM.click();
		Select sortDropdown=new Select(driver.findElement(By.id("selectProductSort")));
		sortDropdown.selectByVisibleText("Price: Lowest first");
		driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
		WebElement ImageDress2=driver.findElement(By.xpath("//*[@class='product_img_link' and @title='Printed Chiffon Dress']"));
		hoverAction.moveToElement(ImageDress2).perform();
		driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
		WebElement addCartChoice2=driver.findElement(By.xpath("//*[@class='button ajax_add_to_cart_button btn btn-default' and @title='Add to cart' and @data-id-product='7']"));
		addCartChoice2.click();
		driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
		WebElement continueshopButton=driver.findElement(By.xpath("//span[@title='Continue shopping']"));
		continueshopButton.click();
		System.out.println("here");
		driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
		WebElement ImageDress1=driver.findElement(By.xpath("//a[@title='Printed Summer Dress' and @class='product_img_link']"));
		hoverAction.moveToElement(ImageDress1).perform();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("here2");
		WebElement addDress1=driver.findElement(By.xpath("//*[@class='button ajax_add_to_cart_button btn btn-default' and @title='Add to cart' and @data-id-product='5']"));
    	addDress1.click();
		WebElement proceedToCartButton=driver.findElement(By.xpath("//a[@title='Proceed to checkout' and @class='btn btn-default button button-medium']"));
		proceedToCartButton.click();
		WebElement TotalAmount=driver.findElement(By.id("total_product"));
		Assert.assertEquals(45.38, TotalAmount);
	
	}
	
		
		
	@AfterTest
	public void terminateBrowser(){
	driver.close();
	}
}
