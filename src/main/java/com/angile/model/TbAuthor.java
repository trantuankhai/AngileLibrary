package com.angile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_AUTHOR")
public class TbAuthor implements java.io.Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator= "SEQ_TB_AUTHOR")
	@SequenceGenerator(name="SEQ_TB_AUTHOR",sequenceName="SEQ_TB_AUTHOR",allocationSize=1)
	@Column(name="ID_AUTHOR")
	private Integer id;
	@Column(name="NAME_AUTHOR")
	private String nameAuthor;
	@Column(name="ADDRESS_AUTHOR")
	private String addressAuthor;
	@Column(name="PHONE_AUTHOR")
	private String phoneAuthor;
	@Column(name="EMAIL_AUTHOR")
	private String emailAuthor;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getNameAuthor()
	{
		return nameAuthor;
	}

	public void setNameAuthor(String nameAuthor)
	{
		this.nameAuthor = nameAuthor;
	}

	public String getAddressAuthor()
	{
		return addressAuthor;
	}

	public void setAddressAuthor(String addressAuthor)
	{
		this.addressAuthor = addressAuthor;
	}

	public String getPhoneAuthor()
	{
		return phoneAuthor;
	}

	public void setPhoneAuthor(String phoneAuthor)
	{
		this.phoneAuthor = phoneAuthor;
	}

	public String getEmailAuthor()
	{
		return emailAuthor;
	}

	public void setEmailAuthor(String emailAuthor)
	{
		this.emailAuthor = emailAuthor;
	}
	public TbAuthor() {
		// TODO Auto-generated constructor stub
	}
	

	public TbAuthor(Integer id, String nameAuthor, String addressAuthor, String phoneAuthor, String emailAuthor) {
		super();
		this.id = id;
		this.nameAuthor = nameAuthor;
		this.addressAuthor = addressAuthor;
		this.phoneAuthor = phoneAuthor;
		this.emailAuthor = emailAuthor;
	}

	@Override
	public int hashCode()
	{
		return this.getId().hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof TbAuthor))
			return false;
		return java.util.Objects.equals(((TbAuthor)obj).getId(), getId());
	}

	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append("TbAuthor[");
		result.append("id=");
		result.append(id);
		result.append(", nameAuthor=");
		result.append(nameAuthor);
		result.append("]");
		return result.toString();
	}
}
