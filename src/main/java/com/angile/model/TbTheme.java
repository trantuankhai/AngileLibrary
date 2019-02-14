package com.angile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_THEME")
public class TbTheme implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TB_THEME")
	@SequenceGenerator(name = "SEQ_TB_THEME", sequenceName = "SEQ_TB_THEME", allocationSize = 1)
	@Column(name = "ID_THEME")
	private Integer id;
	@Column(name = "NAME_THEME")
	private String nameTheme;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameTheme() {
		return nameTheme;
	}

	public void setNameTheme(String nameTheme) {
		this.nameTheme = nameTheme;
	}

	@Override
	public int hashCode() {
		return this.getId().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TbTheme))
			return false;
		return java.util.Objects.equals(((TbTheme) obj).getId(), getId());
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("TbTheme[");
		result.append("id=");
		result.append(id);
		result.append(", nameTheme=");
		result.append(nameTheme);
		result.append("]");
		return result.toString();
	}

	public TbTheme(Integer id, String nameTheme) {
		super();
		this.id = id;
		this.nameTheme = nameTheme;
	}

	public TbTheme(String nameTheme) {
		this.nameTheme = nameTheme;
	}

	public TbTheme() {
		// TODO Auto-generated constructor stub
	}
}
