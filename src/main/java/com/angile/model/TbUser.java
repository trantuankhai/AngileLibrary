package com.angile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USER")
public class TbUser implements java.io.Serializable
{
        @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TB_USER")
	@SequenceGenerator(name = "SEQ_TB_USER", sequenceName = "SEQ_TB_USER", allocationSize = 1)
        @Column(name = "ID_USER")
	private Integer id;
        @Column(name = "USER_NAME")
	private String userName;
        @Column(name = "PASS_WORD")
	private String passWord;
        @Column(name = "FULLNAME")
	private String fullname;
        @Column(name = "EMAIL")
	private String email;
        @Column (name = "ROLE")
	private Integer role;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassWord()
	{
		return passWord;
	}

	public void setPassWord(String passWord)
	{
		this.passWord = passWord;
	}

	public String getFullname()
	{
		return fullname;
	}

	public void setFullname(String fullname)
	{
		this.fullname = fullname;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Integer getRole()
	{
		return role;
	}

	public void setRole(Integer role)
	{
		this.role = role;
	}

    public TbUser() {
    }

    public TbUser(Integer id, String userName, String passWord, String fullname, String email, Integer role) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.fullname = fullname;
        this.email = email;
        this.role = role;
    }
        
	@Override
	public int hashCode()
	{
		return this.getId().hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof TbUser))
			return false;
		return java.util.Objects.equals(((TbUser)obj).getId(), getId());
	}

	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append("TbUser[");
		result.append("id=");
		result.append(id);
		result.append(", userName=");
		result.append(userName);
		result.append("]");
		return result.toString();
	}
}
