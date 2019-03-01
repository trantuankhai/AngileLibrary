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

public class TestInputLuong {
	WebDriver driver;
	@Test(description = "Không nhập trường Salary", groups = "txtSalary", priority = 10)
	public void Add_01() {
		try {
			WebElement fieldSalary = driver.findElement(By.id("txtSalary"));
			fieldSalary.sendKeys("");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldSalary);
			assertEquals("Please fill out this field.", actual);
		} catch (Exception e) {
			fail("FAILL");
		}
	}
	@Test(description = "nhập trường Salary chứa ký tự đặc biệt (!@#$%^&*)", groups = "txtSalary", priority = 11)
	public void Add_02() {
		try {
			WebElement fieldSalary = driver.findElement(By.id("txtSalary"));
			fieldSalary.sendKeys("!@#$%^&*@com");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldSalary);
			System.out.println(actual);
			assertEquals("Please match the requested format.", actual);
		} catch (Exception e) {
			fail("FAILL");
		}

	}
	@Test(description = "nhập trường Salary chứa ký tự số 4558556", groups = "txtSalary", priority = 12)
	public void Add_03() {
		try {
			WebElement fieldSalary = driver.findElement(By.id("txtSalary"));
			fieldSalary.sendKeys("4558556");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldSalary);
			assertEquals("", actual);
		} catch (Exception e) {
			fail("FAILL");
		}

	}
	@Test(description = "nhập trường Salary chứa ký tự chữ a-zA-z", groups = "txtSalary", priority = 13)
	public void Add_04() {
		try {
			WebElement fieldSalary = driver.findElement(By.id("txtSalary"));
			fieldSalary.sendKeys("AzAhhGFcom");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldSalary);
			assertEquals("Please match the requested format.", actual);
		} catch (Exception e) {
			fail("FAILL");
		}

	}
	
	@Test(description = "nhập trường Salary chứa 3 kí tự", groups = "txtSalary", priority = 14)
	public void Add_05() {
		try {
			WebElement fieldSalary = driver.findElement(By.id("txtSalary"));
			fieldSalary.sendKeys("555");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldSalary);
			assertEquals("Please lengthen this text to 4 characters or more (you are currently using 3 characters).", actual);
		} catch (Exception e) {
			fail("FAILL");
		}

	}
	@Test(description = "nhập trường Salary chứa 4 kí tự", groups = "txtSalary", priority = 15)
	public void Add_06() {
		try {
			WebElement fieldSalary = driver.findElement(By.id("txtSalary"));
			fieldSalary.sendKeys("5555");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldSalary);
			assertEquals("", actual);
		} catch (Exception e) {
			fail("FAILL");
		}
	}
	@Test(description = "nhập trường Salary chứa 7 kí tự", groups = "txtSalary", priority = 16)
	public void Add_07() {
		try {
			WebElement fieldSalary = driver.findElement(By.id("txtSalary"));
			fieldSalary.sendKeys("5555555");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			assertEquals(fieldSalary.getAttribute("value").length(), 7);
		} catch (Exception e) {
			fail("FAILL");
		}
	}
	@Test(description = "nhập trường Salary chứa 8 kí tự", groups = "txtSalary", priority = 17)
	public void Add_08() {
		try {
			WebElement fieldSalary = driver.findElement(By.id("txtEmial"));
			fieldSalary.sendKeys("55555555");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			System.out.println(fieldSalary.getAttribute("value").length());
			assertEquals(fieldSalary.getAttribute("value").length(), 8);
			
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
  }

  @AfterMethod
  public void afterMethod() {
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
