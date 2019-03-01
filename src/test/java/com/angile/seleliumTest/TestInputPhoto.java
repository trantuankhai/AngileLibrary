package com.angile.seleliumTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestInputPhoto {
	WebDriver driver;

	@Test(groups = "TestPhoto", priority = 33)
	public void add_01()
	{
		try {
			WebElement fieldPhoto = driver.findElement(By.id("txtPhoto"));
			fieldPhoto.sendKeys("");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldPhoto);
			Assert.assertEquals("Please select a file.", actual);
		} catch (Exception e) {
			fail("FAILL");
		}
	}
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Tuan Khai\\Desktop\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(
				"file:///C:/xampp/htdocs/QuanLyNhanVien_FrontEnd/WebContent/Admin/View/quanlynhanvien/formLogIn.html");
	}

	@BeforeMethod
	public void beforeAdd() {
		driver.get(
				"file:///C:/xampp/htdocs/QuanLyNhanVien_FrontEnd/WebContent/Admin/View/quanlynhanvien/formLogIn.html");
		WebElement element = driver.findElement(By.id("txtName"));
		element.sendKeys("Tuan Khai");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

	public String getHtml5ValidationMessage(WebElement element) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		return (String) javascriptExecutor.executeScript("return arguments[0].validationMessage;", element);
	}


}
