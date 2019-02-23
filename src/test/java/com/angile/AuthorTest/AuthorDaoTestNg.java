package com.angile.AuthorTest;

import org.testng.annotations.Test;

import com.angile.Service.AuhorServicesImpl;
import com.angile.model.TbAuthor;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AuthorDaoTestNg {
  @Test
  public void addAuthor_01() 
  {
	  AuhorServicesImpl auhorServicesImpl = new AuhorServicesImpl();
	  boolean kq = auhorServicesImpl.addAuthor(new TbAuthor(null, "Hà Nội", "0964365479", "khaittph05424@fpt.edu.cn"));
	  Assert.assertFalse(kq);
  }
  @Test
  public void addAuthor_02() 
  {
	  AuhorServicesImpl auhorServicesImpl = new AuhorServicesImpl();
	  boolean kq = auhorServicesImpl.addAuthor(new TbAuthor("Tô Hoài", "Hà Nội", "0964365479", "khaittph05424@fpt.edu.cn"));
	  Assert.assertFalse(kq);
  }
  @BeforeMethod
  public void beforeMethod() 
  {
  }

  @AfterMethod
  public void afterMethod() 
  {
  }

}
