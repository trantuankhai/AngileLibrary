package com.angile.seleliumTest;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TestInputName {
	WebDriver driver;

	@Test
	public void add_01() throws InterruptedException {
		WebElement txtname = driver.findElement(By.id("txtName"));
		WebElement submit = driver.findElement(By.id("btnSubmit"));
		txtname.sendKeys("");
		submit.click();
		Thread.sleep(1000);
		String actual = getHtml5ValidationMessage(txtname);
		Assert.assertEquals("Please fill out this field.", actual);

	}
	@Test
	public void add_2() throws InterruptedException {
		WebElement txtname = driver.findElement(By.id("txtName"));
		WebElement submit = driver.findElement(By.id("btnSubmit"));
		txtname.sendKeys("!@#$%^&*");
		submit.click();
		Thread.sleep(1000);
		String actual = getHtml5ValidationMessage(txtname);
		Assert.assertEquals("Invalid input name.", actual);
		
	}
	@Test
	public void add_3() throws InterruptedException {
		WebElement txtname = driver.findElement(By.id("txtName"));
		WebElement submit = driver.findElement(By.id("btnSubmit"));
		txtname.sendKeys("123456789");
		submit.click();
		Thread.sleep(1000);
		String actual = getHtml5ValidationMessage(txtname);
		Assert.assertEquals("Invalid input name.", actual);
		
	}
	@Test
	public void add_4() throws InterruptedException {
		WebElement txtname = driver.findElement(By.id("txtName"));
		WebElement submit = driver.findElement(By.id("btnSubmit"));
		txtname.sendKeys("tt");
		submit.click();
		Thread.sleep(1000);
		String actual = getHtml5ValidationMessage(txtname);
		Assert.assertEquals("Please lengthen this text to 5 characters or more (you are currently using 4 characters).", actual);
		
	}
	@Test
	public void add_5() throws InterruptedException {
		WebElement txtname = driver.findElement(By.id("txtName"));
		WebElement submit = driver.findElement(By.id("btnSubmit"));
		txtname.sendKeys("ttttt");
		submit.click();
		Thread.sleep(1000);
		String actual = getHtml5ValidationMessage(txtname);
		Assert.assertEquals("", actual);
		
	}
	@Test
	public void add_6() throws InterruptedException {
		WebElement txtname = driver.findElement(By.id("txtName"));
		WebElement submit = driver.findElement(By.id("btnSubmit"));
		txtname.sendKeys("tttttttttttttttttttttttttttttt");
		submit.click();
		Thread.sleep(1000);
		Assert.assertEquals(txtname.getAttribute("value").length(), 30);
		
	}
	@Test
	public void add_7() throws InterruptedException {
		WebElement txtname = driver.findElement(By.id("txtName"));
		WebElement submit = driver.findElement(By.id("btnSubmit"));
		txtname.sendKeys("ttttttttttttttttttttttttttttttt");
		submit.click();
		Thread.sleep(1000);
		Assert.assertEquals(txtname.getAttribute("value").length(), 31);
		
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Tuan Khai\\Desktop\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(
				"file:///C:/xampp/htdocs/QuanLyNhanVien_FrontEnd/WebContent/Admin/View/quanlynhanvien/formLogIn.html");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

	public String getHtml5ValidationMessage(WebElement element) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		return (String) javascriptExecutor.executeScript("return arguments[0].validationMessage;", element);
	}
	@BeforeMethod
	public  void doAdd() {
		String url = "file:///C:/xampp/htdocs/QuanLyNhanVien_FrontEnd/WebContent/Admin/View/quanlynhanvien/formLogIn.html";
		driver.get(url);
	}

}
