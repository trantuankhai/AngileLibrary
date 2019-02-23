package com.angile.LibraryTest;

import org.testng.annotations.Test;

import com.angile.Service.ThemeServicesImpl;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;

public class ThemeTest {
	private static ThemeServicesImpl themeServices;

	@DataProvider(name = "dataTest")
	public static Object[][] dataTestTheme() {
		return new Object[][] { { "Sách Thiếu Nhi" }, { null } };
	}

	@Test(groups = "Theme", dataProvider = "dataTest")
	public void addTheme(String name) {
		boolean kq = themeServices.addTheme(name);
		Assert.assertEquals(kq,false );
	}

	@BeforeTest
	public void beforeTest() {
		themeServices = new ThemeServicesImpl();
	}

	@AfterTest
	public void afterTest() {
		// delete theme
	}

}
