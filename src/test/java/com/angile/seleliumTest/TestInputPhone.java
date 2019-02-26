package com.angile.seleliumTest;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestInputPhone {
	WebDriver driver;
	@Test(description = "Không nhập trường Phone", groups = "txtPhone", priority = 26)
	public void Add_01() {
		try {
			WebElement fieldPhone = driver.findElement(By.id("txtPhone"));
			fieldPhone.sendKeys("");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldPhone);
			assertEquals("Please fill out this field.", actual);
		} catch (Exception e) {
			fail("FAILL");
		}
	}

	@Test(description = "nhập trường Phone chứa ký tự đặc biệt (!@#$%^&*)", groups = "txtPhone", priority = 27)
	public void Add_02() {
		try {
			WebElement fieldPhone = driver.findElement(By.id("txtPhone"));
			fieldPhone.sendKeys("!@#$%^&*@com");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldPhone);
			System.out.println(actual);
			assertEquals("Please match the requested format.", actual);
		} catch (Exception e) {
			fail("FAILL");
		}

	}

	@Test(description = "nhập trường Phone chứa ký tự số 4558556", groups = "txtPhone", priority = 28)
	public void Add_03() {
		try {
			WebElement fieldPhone = driver.findElement(By.id("txtPhone"));
			fieldPhone.sendKeys("4558556");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldPhone);
			assertEquals("", actual);
		} catch (Exception e) {
			fail("FAILL");
		}

	}
	
	@Test(description = "nhập trường Phone chứa ký tự chữ a-zA-z", groups = "txtPhone", priority = 29)
	public void Add_04() {
		try {
			WebElement fieldPhone = driver.findElement(By.id("txtPhone"));
			fieldPhone.sendKeys("AzAhhGFcom");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldPhone);
			assertEquals("Please match the requested format.", actual);
		} catch (Exception e) {
			fail("FAILL");
		}

	}
	
	@Test(description = "nhập trường Phone chứa 5 kí tự", groups = "txtPhone", priority = 30)
	public void Add_05() {
		try {
			WebElement fieldPhone = driver.findElement(By.id("txtPhone"));
			fieldPhone.sendKeys("55555");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldPhone);
			assertEquals("Please lengthen this text to 6 characters or more (you are currently using 5 characters).", actual);
		} catch (Exception e) {
			fail("FAILL");
		}

	}
	
	@Test(description = "nhập trường Phone chứa 6 kí tự", groups = "txtPhone", priority = 31)
	public void Add_06() {
		try {
			WebElement fieldPhone = driver.findElement(By.id("txtPhone"));
			fieldPhone.sendKeys("555555");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldPhone);
			assertEquals("", actual);
		} catch (Exception e) {
			fail("FAILL");
		}
	}
	
	@Test(description = "nhập trường Phone chứa 13 kí tự", groups = "txtPhone", priority = 32)
	public void Add_07() {
		try {
			WebElement fieldPhone = driver.findElement(By.id("txtPhone"));
			fieldPhone.sendKeys("5555555555555");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			assertEquals(fieldPhone.getAttribute("value").length(), 13);
		} catch (Exception e) {
			fail("FAILL");
		}
	}
	
	@Test(description = "nhập trường Phone chứa 14 kí tự", groups = "txtPhone", priority = 33)
	public void Add_08() {
		try {
			WebElement fieldPhone = driver.findElement(By.id("txtEmial"));
			fieldPhone.sendKeys("55555555555555");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			System.out.println(fieldPhone.getAttribute("value").length());
			assertEquals(fieldPhone.getAttribute("value").length(), 14);
			
		} catch (Exception e) {
			fail("FAILL");
		}
	}
	
  @BeforeMethod
  public void beforeMethod() {
	  driver.get(
				"file:///C:/xampp/htdocs/QuanLyNhanVien_FrontEnd/WebContent/Admin/View/quanlynhanvien/formLogIn.html");
		WebElement element = driver.findElement(By.id("txtName"));
		element.sendKeys("Tuan Khai");
		WebElement element2 = driver.findElement(By.id("txtYear"));
		element2.sendKeys("07/03/1997");
		WebElement element3 = driver.findElement(By.id("txtSalary"));
		element3.sendKeys("100");
		WebElement element4 = driver.findElement(By.id("txtEmail"));
		element4.sendKeys("khai@gmail.com");
  }

  @AfterMethod
  public void afterMethod() {
		WebElement element = driver.findElement(By.id("txtName"));
		element.sendKeys("");
		WebElement element2 = driver.findElement(By.id("txtYear"));
		element2.sendKeys("");
		WebElement element3 = driver.findElement(By.id("txtSalary"));
		element3.sendKeys("");
		WebElement element4 = driver.findElement(By.id("txtEmail"));
		element4.sendKeys("");
		WebElement element5 = driver.findElement(By.id("txtPhone"));
		element5.sendKeys("");
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

}
