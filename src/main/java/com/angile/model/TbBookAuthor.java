package com.angile.model;

public class TbBookAuthor implements java.io.Serializable
{
	private TbBook idBook;
	private TbAuthor idAuthor;

	public TbBook getIdBook()
	{
		return idBook;
	}

	public void setIdBook(TbBook idBook)
	{
		this.idBook = idBook;
	}

	public TbAuthor getIdAuthor()
	{
		return idAuthor;
	}

	public void setIdAuthor(TbAuthor idAuthor)
	{
		this.idAuthor = idAuthor;
	}

	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append("TbBookAuthor[");
		result.append(", idBook=");
		result.append(idBook);
		result.append("]");
		return result.toString();
	}
}
