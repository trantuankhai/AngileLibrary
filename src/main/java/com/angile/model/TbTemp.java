package com.angile.model;

public class TbTemp implements java.io.Serializable
{
	private TbBook idBook;
	private TbMuonTra idMuonTraSach;

	public TbBook getIdBook()
	{
		return idBook;
	}

	public void setIdBook(TbBook idBook)
	{
		this.idBook = idBook;
	}

	public TbMuonTra getIdMuonTraSach()
	{
		return idMuonTraSach;
	}

	public void setIdMuonTraSach(TbMuonTra idMuonTraSach)
	{
		this.idMuonTraSach = idMuonTraSach;
	}

	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append("TbTemp[");
		result.append(", idBook=");
		result.append(idBook);
		result.append("]");
		return result.toString();
	}
}
