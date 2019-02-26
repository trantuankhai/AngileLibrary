package com.angile.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.SortComparator;

@Entity
@Table(name="TB_BOOK")
public class TbBook implements java.io.Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_TB_BOOK")
	@SequenceGenerator(name = "SEQ_TB_BOOK", sequenceName = "SEQ_TB_BOOK", allocationSize = 1)
	@Column(name="ID_BOOK")
	private Integer id;
	@ManyToOne()
	@JoinColumn(name="ID_THEME")
	private TbTheme idTheme;
	@ManyToOne()
	@JoinColumn(name="ID_PUBLISHING") 
	private TbPlublishing idPublishing;
	@Column(name="NAME_BOOK")
	private String nameBook;
	@ManyToOne()
	@JoinColumn(name="ID_AUTHOR")
	private TbAuthor idAuthor;
	@Column(name="PUBLISHING_YEAR")
	private Integer publishingYear;
	@Column(name="NUMBER_OF_PAGES")
	private Integer numberOfPages;
	@Column(name="PRICE_BOOK")
	private String priceBook;
	@Column(name="STORAGE_NUMBER")
	private Integer storageNumber;
	@Column(name="LANGUAAGE")
	private Integer languaage;

	public TbTheme getIdTheme()
	{
		return idTheme;
	}

	public void setIdTheme(TbTheme idTheme)
	{
		this.idTheme = idTheme;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public TbPlublishing getIdPublishing()
	{
		return idPublishing;
	}

	public void setIdPublishing(TbPlublishing idPublishing)
	{
		this.idPublishing = idPublishing;
	}

	public String getNameBook()
	{
		return nameBook;
	}

	public void setNameBook(String nameBook)
	{
		this.nameBook = nameBook;
	}

	

	public TbAuthor getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(TbAuthor idAuthor) {
		this.idAuthor = idAuthor;
	}

	public Integer getPublishingYear()
	{
		return publishingYear;
	}

	public void setPublishingYear(Integer publishingYear)
	{
		this.publishingYear = publishingYear;
	}

	public Integer getNumberOfPages()
	{
		return numberOfPages;
	}

	public void setNumberOfPages(Integer numberOfPages)
	{
		this.numberOfPages = numberOfPages;
	}

	public String getPriceBook()
	{
		return priceBook;
	}

	public void setPriceBook(String priceBook)
	{
		this.priceBook = priceBook;
	}

	public Integer getStorageNumber()
	{
		return storageNumber;
	}

	public void setStorageNumber(Integer storageNumber)
	{
		this.storageNumber = storageNumber;
	}

	public Integer getLanguaage()
	{
		return languaage;
	}

	public void setLanguaage(Integer languaage)
	{
		this.languaage = languaage;
	}
public TbBook() {
	// TODO Auto-generated constructor stub
}
	@Override
	public int hashCode()
	{
		return this.getId().hashCode();
	}
public TbBook(Integer id, TbTheme idTheme, TbPlublishing idPublishing, String nameBook, TbAuthor idAuthor,
		Integer publishingYear, Integer numberOfPages, String priceBook, Integer storageNumber, Integer languaage) {
	super();
	this.id = id;
	this.idTheme = idTheme;
	this.idPublishing = idPublishing;
	this.nameBook = nameBook;
	this.idAuthor = idAuthor;
	this.publishingYear = publishingYear;
	this.numberOfPages = numberOfPages;
	this.priceBook = priceBook;
	this.storageNumber = storageNumber;
	this.languaage = languaage;
}
public TbBook( TbTheme idTheme, TbPlublishing idPublishing, String nameBook, TbAuthor idAuthor,
		Integer publishingYear, Integer numberOfPages, String priceBook, Integer storageNumber, Integer languaage) {
	super();
	this.idTheme = idTheme;
	this.idPublishing = idPublishing;
	this.nameBook = nameBook;
	this.idAuthor = idAuthor;
	this.publishingYear = publishingYear;
	this.numberOfPages = numberOfPages;
	this.priceBook = priceBook;
	this.storageNumber = storageNumber;
	this.languaage = languaage;
}


	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof TbBook))
			return false;
		return java.util.Objects.equals(((TbBook)obj).getId(), getId());
	}

	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append("TbBook[");
		result.append("id=");
		result.append(id);
		result.append(", nameBook=");
		result.append(nameBook);
		result.append("]");
		return result.toString();
	}
}
