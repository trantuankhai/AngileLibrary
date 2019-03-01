package com.angile.seleliumTest;

import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TestInputYear {
	WebDriver driver;

	@Test(groups = "TestYear", priority = 34)
	public void add_01() {
		try {
			WebElement fieldBirthday = driver.findElement(By.id("txtYear"));
			fieldBirthday.sendKeys("");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldBirthday);
			assertEquals("Please fill out this field.", actual);
		} catch (Exception e) {
			fail("FAILL");
		}
	}
	@Test(description = "Chỉ nhập Day trong trường txtYear", groups = "txtYear", priority = 35)
	public void Add_02() {
		try {
			WebElement fieldBirthday = driver.findElement(By.id("txtYear"));
			fieldBirthday.sendKeys("01");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldBirthday);
			assertEquals("Please enter a valid value. The field is incomplete or has an invalid date.", actual);
		} catch (Exception e) {
			fail("FAILL");
		}
	}
	@Test(description = "Chỉ nhập Day,Month  trong trường txtYear", groups = "txtYear", priority = 36)
	public void Add_03() {
		try {
			WebElement fieldBirthday = driver.findElement(By.id("txtYear"));
			fieldBirthday.sendKeys("0101");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldBirthday);
			assertEquals("Please enter a valid value. The field is incomplete or has an invalid date.", actual);
		} catch (Exception e) {
			fail("FAILL");
		}
	}
	@Test(description = "Nhập đủ  trường txtYear 03/05/1996", groups = "txtYear", priority =37)
	public void Add_04() {
		try {
			WebElement fieldBirthday = driver.findElement(By.id("txtYear"));
			fieldBirthday.sendKeys("03051996");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldBirthday);
			System.out.println(actual);
		} catch (Exception e) {
			fail("FAILL");
		}
	}
	@Test(description = "Nhập trường txtYear 31/12/2000", groups = "txtYear", priority = 38)
	public void Add_05() {
		try {
			WebElement fieldBirthday = driver.findElement(By.id("txtYear"));
			fieldBirthday.sendKeys("31122000");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldBirthday);
			System.out.println(actual);
			assertEquals("Please match the requested format.", actual);
		} catch (Exception e) {
			fail("FAILL");
		}
	}
	@Test(description = "Nhập trường txtYear 01/01/1999", groups = "txtYear", priority = 39)
	public void Add_06() {
		try {
			WebElement fieldBirthday = driver.findElement(By.id("txtYear"));
			fieldBirthday.sendKeys("01011950");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldBirthday);
			System.out.println(actual);
			assertEquals("Please match the requested format.", actual);
		} catch (Exception e) {
			fail("FAILL");
		}
	}
	@Test(description = "Nhập trường txtYear 01/01/1950", groups = "txtYear", priority = 40)
	public void Add_07() {
		try {
			WebElement fieldBirthday = driver.findElement(By.id("txtYear"));
			fieldBirthday.sendKeys("01011950");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldBirthday);
			assertEquals("Please match the requested format.", actual);
		} catch (Exception e) {
			fail("FAILL");
		}
	}
	
	@Test(description = "Nhập trường txtYear 31/12/1949", groups = "txtYear", priority = 41)
	public void Add_08() {
		try {
			WebElement fieldBirthday = driver.findElement(By.id("txtYear"));
			fieldBirthday.sendKeys("12311949");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldBirthday);
			assertEquals("Please match the requested format.", actual);
		} catch (Exception e) {
			fail("FAILL");
		}
	}
	@Test(description = "Nhập trường txtYear kí tự đặc biệt", groups = "txtYear", priority =42)
	public void Add_09() {
		try {
			WebElement fieldBirthday = driver.findElement(By.id("txtYear"));
			fieldBirthday.sendKeys("%$%^^&&**#@()!");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldBirthday);
			assertEquals("Please match the requested format.", actual);
		} catch (Exception e) {
			fail("FAILL");
		}
	}
	@Test(description = "Nhập trường txtYear kí tự chữ a-zA-z ", groups = "txtYear", priority = 43)
	public void Add_010() {
		try {
			WebElement fieldBirthday = driver.findElement(By.id("txtYear"));
			fieldBirthday.sendKeys("a-zA-z");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldBirthday);
			assertEquals("Please match the requested format.", actual);
		} catch (Exception e) {
			fail("FAILL");
		}
	}
	

	@AfterMethod
	public void afterMethod() {
		//driver.close();
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

	@BeforeMethod
	public void beforeAdd() {
		driver.get(
				"file:///C:/xampp/htdocs/QuanLyNhanVien_FrontEnd/WebContent/Admin/View/quanlynhanvien/formLogIn.html");
		WebElement element = driver.findElement(By.id("txtName"));
		element.sendKeys("Tuan Khai");
	}

	public String getHtml5ValidationMessage(WebElement element) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		return (String) javascriptExecutor.executeScript("return arguments[0].validationMessage;", element);
	}

}
