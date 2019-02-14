package com.angile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Tuan Khai
 *
 */
@Entity
@Table(name="TB_PLUBLISHING")
public class TbPlublishing implements java.io.Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="SEQ_TB_PLUBLISHING")
	@SequenceGenerator(name="SEQ_TB_PLUBLISHING",sequenceName="SEQ_TB_PLUBLISHING",allocationSize=1)
	@Column(name="ID_PUBLISHING",nullable=false)
	private Integer id;
	@Column(name="NAME_PUBLISHING")
	private String namePublishing;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getNamePublishing()
	{
		return namePublishing;
	}

	public void setNamePublishing(String namePublishing)
	{
		this.namePublishing = namePublishing;
	}

	@Override
	public int hashCode()
	{
		return this.getId().hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof TbPlublishing))
			return false;
		return java.util.Objects.equals(((TbPlublishing)obj).getId(), getId());
	}

	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append("TbPlublishing[");
		result.append("id=");
		result.append(id);
		result.append(", namePublishing=");
		result.append(namePublishing);
		result.append("]");
		return result.toString();
	}

	public TbPlublishing(Integer id, String namePublishing) {
		super();
		this.id = id;
		this.namePublishing = namePublishing;
	}
	public TbPlublishing() {
	}
}