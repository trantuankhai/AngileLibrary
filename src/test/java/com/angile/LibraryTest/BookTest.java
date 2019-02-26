package com.angile.LibraryTest;

import org.testng.annotations.Test;

import com.angile.Dao.BookDAOImpl;
import com.angile.Service.BookServicesImpl;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class BookTest {
	private BookServicesImpl bookServices;
	private BookDAOImpl bookDao;
	@DataProvider(name = "dataTest1")
	public Object[][] dataTest() {
		return new Object[][] { 
			{ null, "1", "Đắc Nhân Tâm", "1", "1997", "20", "300000", "200", "1"},//bỏ trống mã chủ đề
			{ "1", null, "Đắc Nhân Tâm","1", "1997", "20", "300000", "200", "1"},//bỏ trống mã tác giả
			{ "1", "1", null, "1", "1997", "20", "300000","200", "1"},//bỏ trống trường tên sách
			{ "1", "1", "Đắc Nhân Tâm", null, "1997", "20", "300000", "200", "1"},//bỏ trống trường tên sách
			{ "1", "1", "Đắc Nhân Tâm", "1", null, "20", "300000", "200", "1"},//bỏ trống trường tên sách
	        { "1", "1", "Đắc Nhân Tâm"," 1", "1997", null, "300000", "200", "1"},//bỏ trống trường tên sách
	        { "1", "1", "Đắc Nhân Tâm", "1", "1997", "20", null, "200", "1"},//bỏ trống trường tên sách
	        { "1", "1", "Đắc Nhân Tâm", "1", "1997", "20", "300000", null, "1"},//bỏ trống trường tên sách
	        { "1", "1", "Đắc Nhân Tâm", "1", "1997", "20", "300000", "200", null},//bỏ trống trường tên sách
	        { "1", "1", "Đắc Nhân Tâm", "1", "-1997", "20", "300000", "200", "1"},//bỏ trống trường tên sách
	        { "1", "1", "Đắc Nhân Tâm", "1", "1997", "20", "300000", "200", "abc"},//bỏ trống trường tên sách
	        { "1", "1", "Đắc Nhân Tâm", "1", "1997", "20", "300000", "200", "!@#"}//bỏ trống trường tên sách
		};
	}
	@DataProvider(name="dataTest2")
	public Object[][] dataTest2() {
		return new Object[][] {
			{ "1", "1", "Đắc Nhân Tâm", "1", "abc", "20", "300000", "200", "1"},//bỏ trống trường tên sách
	        { "1", "1", "Đắc Nhân Tâm", "1", "!@#", "20", "300000", "200", "1"},//bỏ trống trường tên sách
	        { "1", "1", "Đắc Nhân Tâm", "1", "1997", "-20", "300000", "200", "1"},//bỏ trống trường tên sách
	        { "1", "1", "Đắc Nhân Tâm", "1", "1997", "abc", "300000", "200", "1"},//bỏ trống trường tên sách
	        { "1", "1", "Đắc Nhân Tâm", "1", "1997", "20", "-300000", "200", "1"},//bỏ trống trường tên sách
	        { "1", "1", "Đắc Nhân Tâm", "1", "1997", "20", "abc", "200", "1"},//bỏ trống trường tên sách
	        { "1", "1", "Đắc Nhân Tâm", "1", "1997", "20", "!@#", "200", "1"},//bỏ trống trường tên sách
	        { "1", "1", "Đắc Nhân Tâm", "1", "1997", "20", "300000", "-200", "1"},//bỏ trống trường tên sách
	        { "1", "1", "Đắc Nhân Tâm", "1", "1997", "20", "300000", "abc", "1"},//bỏ trống trường tên sách
	        { "1", "1", "Đắc Nhân Tâm", "1", "1997", "20", "300000", "!@#", "1"},//bỏ trống trường tên sách
	        { "1", "1", "Đắc Nhân Tâm", "1", "1997", "20", "300000", "200", "-1"},//bỏ trống trường tên sách
	        { "1", "1", "Đắc Nhân Tâm", "1", "1997", "20", "300000", "200", "5"}//bỏ trống trường tên sách
		};
	}
	@DataProvider(name="dataTest3")
	public Object[][] dataTest3() {
		return new Object[][] {
			{ "-1", "1", "Đắc Nhân Tâm", "1", "abc", "20", "300000", "200", "1"},//bỏ trống trường tên sách
			{ "abc", "1", "Đắc Nhân Tâm", "1", "abc", "20", "300000", "200", "1"},//bỏ trống trường tên sách
			{ "!@#", "1", "Đắc Nhân Tâm", "1", "abc", "20", "300000", "200", "1"},//bỏ trống trường tên sách
			{ "1", "-1", "Đắc Nhân Tâm", "1", "abc", "20", "300000", "200", "1"},//bỏ trống trường tên sách
			{ "1", "abc", "Đắc Nhân Tâm", "1", "abc", "20", "300000", "200", "1"},//bỏ trống trường tên sách
			{ "1", "!@#", "Đắc Nhân Tâm", "1", "abc", "20", "300000", "200", "1"},//bỏ trống trường tên sách
			{ "1", "1", "Đắc Nhân Tâm", "-1", "abc", "20", "300000", "200", "1"},//bỏ trống trường tên sách
			{ "1", "1", "Đắc Nhân Tâm", "abc", "abc", "20", "300000", "200", "1"},//bỏ trống trường tên sách
			{ "1", "1", "Đắc Nhân Tâm", "!@#", "abc", "20", "300000", "200", "1"},//bỏ trống trường tên sách
		};
	}
	@Test(groups = "Book", dataProvider = "dataTest1")
	public void addBook(String idTheme, String idPublishing, String nameBook, String idAuthor,
			String publishingYear, String numberOfPages, String priceBook, String storageNumber, String languaage) {
		boolean kq = bookServices.addBookValidate(idTheme, idPublishing, nameBook, idAuthor, publishingYear, numberOfPages, priceBook, storageNumber, languaage);
		Assert.assertEquals(kq, false);
	}
	@Test(groups = "Book", dataProvider = "dataTest2")
	public void addBook2(String idTheme, String idPublishing, String nameBook, String idAuthor,
			String publishingYear, String numberOfPages, String priceBook, String storageNumber, String languaage) {
		boolean kq = bookServices.addBookValidate(idTheme, idPublishing, nameBook, idAuthor, publishingYear, numberOfPages, priceBook, storageNumber, languaage);
		Assert.assertEquals(kq, false);
	}

@Test(groups = "Book", dataProvider = "dataTest3")
public void addBook3(String idTheme, String idPublishing, String nameBook, String idAuthor,
		String publishingYear, String numberOfPages, String priceBook, String storageNumber, String languaage) {
	boolean kq = bookServices.addBookValidate(idTheme, idPublishing, nameBook, idAuthor, publishingYear, numberOfPages, priceBook, storageNumber, languaage);
	Assert.assertEquals(kq, false);
}
	@BeforeTest
	public void beforeTest() {
		bookServices = new BookServicesImpl();
		bookDao = new BookDAOImpl();
	}
@BeforeMethod
public void deleteAll()
{
	bookDao.deleteAll();
}
	@AfterTest
	public void afterTest() {
	}

}
