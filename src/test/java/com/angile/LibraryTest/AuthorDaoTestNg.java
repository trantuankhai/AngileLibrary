package com.angile.LibraryTest;

import org.testng.annotations.Test;

import com.angile.Service.AuhorServicesImpl;
import com.angile.model.TbAuthor;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AuthorDaoTestNg {
	private static AuhorServicesImpl authorServices;
	@DataProvider(name="dataTest")
	public static Object[] dataAuthorTest()
	{
		return new Object[][]{
			{null,"0964365479","Hà Nội",  "khaittph05424@fpt.edu.com"},//bỏ trống trường tên tác giả
			{"Tô Hoài", "0964365479",null,  "khaittph05424@fpt.edu.com"},//Bỏ trống trường địa chỉ
			{"Tô Hoài", null,"Hà Nội",  "khaittph05424@fpt.edu.com"},// null trường số điện thoại
			{"Tô Hoài", "0964365479","Hà Nội",  null},// null trường email
			{"Tô Hoài","123457984", "Hà Nội",  "khaittph05424@fpt.edu.com"},// nhập sai định dạng số điện thoại
			{"Tô Hoài", "abc","Hà Nội",  "khaittph05424@fpt.edu.com"},// nhập số điện thoại là chữ
			{"Tô Hoài", "!@#","Hà Nội",  "khaittph05424@fpt.edu.com"},// nhập số điệnt thoại là ký tự đặc biệt
			{"Tô Hoài", "0964365479999", "Hà Nội", "khaittph05424@fpt.edu.com"},// nhập số điện thoại là 13 số
			{"Tô Hoài","0964365479", "Hà Nội", "khaittph05424"}, // nhập sai định dạng email
			{"Tô Hoài", "0964365479","Hà Nội","khai@gmail.com"},//nhập đúng
		};
	}
  @Test(groups="Author",dataProvider="dataTest")
  public void addAuthor(String name, String phone,String address,String email) 
  {
	  boolean kq = authorServices.addAuthor(new TbAuthor(name,phone,address,email));
	  Assert.assertEquals(kq, false);
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  authorServices = new AuhorServicesImpl();
  }

  @AfterMethod
  public void afterMethod() 
  {
	  // delete all
  }

}
