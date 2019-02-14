package com.angile.model;

public class TbMuonTra implements java.io.Serializable
{
	private Integer id;
	private String ngayMuon;
	private String ngayTra;
	private String soCuon;
	private Integer status;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getNgayMuon()
	{
		return ngayMuon;
	}

	public void setNgayMuon(String ngayMuon)
	{
		this.ngayMuon = ngayMuon;
	}

	public String getNgayTra()
	{
		return ngayTra;
	}

	public void setNgayTra(String ngayTra)
	{
		this.ngayTra = ngayTra;
	}

	public String getSoCuon()
	{
		return soCuon;
	}

	public void setSoCuon(String soCuon)
	{
		this.soCuon = soCuon;
	}

	public Integer getStatus()
	{
		return status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	@Override
	public int hashCode()
	{
		return this.getId().hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof TbMuonTra))
			return false;
		return java.util.Objects.equals(((TbMuonTra)obj).getId(), getId());
	}

	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append("TbMuonTra[");
		result.append("id=");
		result.append(id);
		result.append(", ngayMuon=");
		result.append(ngayMuon);
		result.append("]");
		return result.toString();
	}
}
