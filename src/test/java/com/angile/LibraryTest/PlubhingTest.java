package com.angile.LibraryTest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.angile.Dao.PublishingDaoImpl;
import com.angile.Service.PublishingServicesimpl;
import com.angile.model.TbPlublishing;

public class PlubhingTest {
	private PublishingServicesimpl plubhingServices;
	@DataProvider(name="DataTest")
	public Object[][] dataTest()
	{
		return new Object[][] {
			{null,"0964365479","Hà Nội",  "khaittph05424@fpt.edu.com"},//bỏ trống trường tên tác giả
			{"NBX Hà Nội", "0964365479",null,  "khaittph05424@fpt.edu.com"},//Bỏ trống trường địa chỉ
			{"NBX Hà Nội", null,"Hà Nội",  "khaittph05424@fpt.edu.com"},// null trường số điện thoại
			{"NBX Hà Nội", "0964365479","Hà Nội",  null},// null trường email
			{"NBX Hà Nội","123457984", "Hà Nội",  "khaittph05424@fpt.edu.com"},// nhập sai định dạng số điện thoại
			{"NBX Hà Nội", "abc","Hà Nội",  "khaittph05424@fpt.edu.com"},// nhập số điện thoại là chữ
			{"NBX Hà Nội", "!@#","Hà Nội",  "khaittph05424@fpt.edu.com"},// nhập số điệnt thoại là ký tự đặc biệt
			{"NBX Hà Nội", "0964365479999", "Hà Nội", "khaittph05424@fpt.edu.com"},// nhập số điện thoại là 13 số
			{"NBX Hà Nội","0964365479", "Hà Nội", "khaittph05424"}, // nhập sai định dạng email
			{"NBX Hà Nội", "0964365479","Hà Nội","khai@gmail.com"}//nhập đúng
		};
	}
	@Test(groups="Plublishing",dataProvider="DataTest")
	public void addPublishing(String namePublishing , String Phone , String addRess , String email) 
	{
		boolean kq = plubhingServices.addPublishing(new TbPlublishing(namePublishing, Phone, addRess, email));
		Assert.assertEquals(kq, false);
		
	}

	@BeforeTest
	public void beforeTest() {
		plubhingServices = new PublishingServicesimpl();
	}

	@AfterTest
	public void afterTest() {
	}
}
