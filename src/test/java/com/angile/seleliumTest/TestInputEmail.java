package com.angile.seleliumTest;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestInputEmail {
	WebDriver driver;

	@Test(description = "Không nhập trường Email",groups="testEmail" , priority=1)
	public void Add_01() {
		try {
			WebElement fieldEmail = driver.findElement(By.id("txtEmail"));
			fieldEmail.sendKeys("");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldEmail);
			assertEquals("Please fill out this field.", actual);
		} catch (Exception e) {
			fail("FAILL");
		}
	}

	@Test(description = "nhập trường Email chứa ký tự đặc biệt (!@#$%^&*)" ,groups="testEmail" , priority=2)
	public void Add_02() {
		try {
			WebElement fieldEmail = driver.findElement(By.id("txtEmail"));
			fieldEmail.sendKeys("!@#$%^&*@com");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldEmail);
			assertEquals("A part following '@' should not contain the symbol '#'.", actual);
		} catch (Exception e) {
			fail("FAILL");
		}

	}

	@Test(description = "nhập trường Email chứa ký tự số 4558556",groups="testEmail" , priority=3)
	public void Add_03() {
		try {
			WebElement fieldEmail = driver.findElement(By.id("txtEmail"));
			fieldEmail.sendKeys("4558556@com");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldEmail);
			assertEquals("", actual);
		} catch (Exception e) {
			fail("FAILL");
		}

	}

	@Test(description = "nhập trường Email chứa ký tự chữ a-zA-z",groups="testEmail" , priority=4)
	public void Add_04() {
		try {
			WebElement fieldEmail = driver.findElement(By.id("txtEmail"));
			fieldEmail.sendKeys("AzAhhGF@com");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldEmail);
			assertEquals("", actual);
		} catch (Exception e) {
			fail("FAILL");
		}

	}

	@Test(description = "nhập trường Email chứa 7 kí tự",groups="testEmail" , priority=5)
	public void Add_05() {
		try {
			WebElement fieldEmail = driver.findElement(By.id("txtEmail"));
			fieldEmail.sendKeys("HHH@com");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldEmail);
			assertEquals("Please lengthen this text to 8 characters or more (you are currently using 7 characters).",
					actual);
		} catch (Exception e) {
			fail("FAILL");
		}

	}

	@Test(description = "nhập trường Email chứa 8 kí tự",groups="testEmail" , priority=6)
	public void Add_06() {
		try {
			WebElement fieldEmail = driver.findElement(By.id("txtEmail"));
			fieldEmail.sendKeys("HHHH@com");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldEmail);
			assertEquals("", actual);
		} catch (Exception e) {
			fail("FAILL");
		}
	}

	@Test(description = "nhập trường Email chứa 50 kí tự",groups="testEmail" , priority=7)
	public void Add_07() {
		try {
			WebElement fieldEmail = driver.findElement(By.id("txtEmail"));
			fieldEmail.sendKeys("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH@com");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			assertEquals(fieldEmail.getAttribute("value").length(), 50);
		} catch (Exception e) {
			fail("FAILL");
		}
	}

	@Test(description = "nhập trường Email chứa 51 kí tự",groups="testEmail" , priority=8)
	public void Add_08() {
		try {
			WebElement fieldEmail = driver.findElement(By.id("txtEmial"));
			fieldEmail.sendKeys("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH@com");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			System.out.println(fieldEmail.getAttribute("value").length());
			assertEquals(fieldEmail.getAttribute("value").length(), 51);

		} catch (Exception e) {
			fail("FAILL");
		}
	}

	@Test(description = "nhập trường Email sai định dạng",groups="testEmail" , priority=9)
	public void Add_09() {
		try {
			WebElement fieldEmail = driver.findElement(By.id("txtEmail"));
			fieldEmail.sendKeys("@com");
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			submit.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(fieldEmail);
			assertEquals("Please enter a part followed by '@'. '@com' is incomplete.", actual);
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
