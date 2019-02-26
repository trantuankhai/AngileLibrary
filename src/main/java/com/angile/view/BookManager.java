/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angile.view;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

import com.angile.Dao.PublishingDaoImpl;
import com.angile.Service.AuhorServicesImpl;
import com.angile.Service.BookServicesImpl;
import com.angile.Service.PublishingServicesimpl;
import com.angile.Service.ThemeServicesImpl;
import com.angile.model.TbAuthor;
import com.angile.model.TbBook;
import com.angile.model.TbPlublishing;
import com.angile.model.TbTheme;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Tuan Khai
 */
@SuppressWarnings("all")
public class BookManager extends javax.swing.JFrame {

	/**
	 * Creates new form BookManager
	 */
	private DefaultTableModel tableModel = new DefaultTableModel();
	private BookServicesImpl bookServicesImpl = new BookServicesImpl();
	private ThemeServicesImpl themeServicesImpl = new ThemeServicesImpl();
	private AuhorServicesImpl auhorServicesImpl = new AuhorServicesImpl();
	private PublishingServicesimpl publishingServicesimpl = new PublishingServicesimpl();
	private int flag = 1;

	public BookManager() {
		initComponents();
		swith_Enabled(false);
		showDataTableBook();
		showDataTableTheme();
		btnGroupLanguage.add(rdoEn);
		btnGroupLanguage.add(rdoKhac);
		btnGroupLanguage.add(rdoVn);
		btnEdit.setEnabled(false);
		btnDelete.setEnabled(false);
		btnSave.setEnabled(false);
		btnIrmoge.setEnabled(false);
	}

	/// CUSTOMER METHOR
	void swith_Enabled(boolean dieukien) {
		cboPublicshing.setEnabled(dieukien);
		cboTheme.setEnabled(dieukien);
		tfCode.setEnabled(false);
		tfTitle.setEnabled(dieukien);
		tfCount.setEnabled(dieukien);
		tfPrice.setEnabled(dieukien);
		tfPage.setEnabled(dieukien);
		tfYear.setEnabled(dieukien);
		cboAuthor.setEnabled(dieukien);
		rdoEn.setEnabled(dieukien);
		rdoVn.setEnabled(dieukien);
		rdoKhac.setEnabled(dieukien);
	}
	int convertLanguage() {
		if(rdoVn.isSelected())
		{
			return 1;
		}else if(rdoEn.isSelected())
		{
			return 2;
		}else
		{
			return 0;
		}
	}
	TbBook getBookFromForm()
	{
		TbBook book = new TbBook(themeServicesImpl.searchTheme((String)cboTheme.getSelectedItem()), publishingServicesimpl.getPublishingByName((String)cboPublicshing.getSelectedItem()), tfTitle.getText(), auhorServicesImpl.getAuthorByName((String)cboAuthor.getSelectedItem()), Integer.parseInt(tfYear.getText()), Integer.parseInt(tfPage.getText()),tfPrice.getText(),Integer.parseInt(tfCount.getText()), convertLanguage());
		return book;
	}

	void showDataTableBook() {

		tableModel = (DefaultTableModel) tblBook.getModel();
		tableModel.setRowCount(0);
		if (bookServicesImpl.getBook(0, 100) != null) {
			for (TbBook x : bookServicesImpl.getBook(0, 100)) {
				tableModel.addRow(new Object[] { x.getId(), x.getNameBook(), x.getNumberOfPages() });
			}

		}

	}

	void showDataTableTheme() {
		tableModel = (DefaultTableModel) tblTheme.getModel();
		tableModel.setRowCount(0);
		for (TbTheme x : themeServicesImpl.getTheme(0, 5)) {
			tableModel.addRow(new Object[] { x.getId(), x.getNameTheme() });
		}
	}

	void showDetailBook(int id_book) {
		cboTheme.removeAllItems();
		cboAuthor.removeAllItems();
		cboPublicshing.removeAllItems();
		TbBook book = bookServicesImpl.getBookById(id_book);
		tfCode.setText(book.getId() + "");
		tfTitle.setText(book.getNameBook());
		tfYear.setText(book.getPublishingYear() + "");
		tfPage.setText(book.getNumberOfPages() + "");
		tfCount.setText(book.getStorageNumber() + "");
		tfPrice.setText(book.getPriceBook());
		cboAuthor.addItem(book.getIdAuthor().getNameAuthor());
		cboPublicshing.addItem(book.getIdPublishing().getNamePublishing());
		cboTheme.addItem(book.getIdTheme().getNameTheme());
		if (book.getLanguaage() == 1) {
			rdoVn.setSelected(true);
		} else if (book.getLanguaage() == 2) {
			rdoEn.setSelected(true);
		} else {
			rdoKhac.setSelected(true);
		}
	}

	@SuppressWarnings("all")
	void addItemComboboxTheme() {
		cboTheme.removeAllItems();
		for (TbTheme x : themeServicesImpl.getTheme(0, 10)) {
			cboTheme.addItem(x.getNameTheme());
		}
	}

	@SuppressWarnings("all")
	void addItemComboboxAuthor() {
		cboAuthor.removeAllItems();
		for (TbAuthor x : auhorServicesImpl.getAuthor(0, 10)) {
			cboAuthor.addItem(x.getNameAuthor());
		}
	}

	@SuppressWarnings("all")
	void addItemComboxPublishing() {
		cboPublicshing.removeAllItems();
		for (TbPlublishing x : publishingServicesimpl.getPublishing(0, 10)) {
			cboPublicshing.addItem(x.getNamePublishing());
		}
	}

	void clearForm() {
		tfCode.setText(null);
		tfTitle.setText(null);
		tfCount.setText(null);
		tfPrice.setText(null);
		tfPage.setText(null);
		tfYear.setText(null);
		rdoVn.setSelected(true);
	}

	boolean validateBook() {
		if (tfTitle.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập tiêu đề sách");
			return false;
		} else if (tfYear.getText().equals("") || tfYear.getText().matches("^[1-9]+$")==false) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập năm xuất bản hoặc không đúng định dạng");
				return false;
		} else if (tfPage.getText().equals("") || tfYear.getText().matches("^[0-9]+$")==false) {
			JOptionPane.showMessageDialog(null,"Bạn chưa nhập số trang hoặc không đúng định dạng");
			return false;
		} else if (tfPrice.getText().equals("")|| tfYear.getText().matches("^[0-9]+$")==false) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập giá hoặc không đúng định dạng");
			return false;

		} else if (tfCount.getText().equals("")|| tfYear.getText().matches("^[0-9]+$")==false) {
			JOptionPane.showMessageDialog(null,"Bạn chưa nhập số bản lưu hoặc không đúng định dạng");
			return false;
		}else {
			return true;
		}
	}

	void addBook(TbBook book) {
		if(bookServicesImpl.addBook(book)==true)
		{
			showDataTableBook();
			clearForm();
		}else
		{
			JOptionPane.showMessageDialog(null,"Thêm sách không thành công");
		}
	}
	void updateBook(Integer id , TbBook book)
	{
		if(bookServicesImpl.editBook(id, book)==true)
		{
			showDataTableBook();
			
		}else
		{
			JOptionPane.showMessageDialog(null, "Lỗi trong quá trình cập nhập");
		}
	}
	void deleteBook(int id)
	{
		if (bookServicesImpl.removeBook(id)==true) {
			JOptionPane.showMessageDialog(null, "xóa thành công");
			showDataTableBook();
		}else {
			JOptionPane.showMessageDialog(null, "Lỗi trong quá trình xóa");
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		btnGroupLanguage = new javax.swing.ButtonGroup();
		jLabel1 = new javax.swing.JLabel();
		pnLeft = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblTheme = new javax.swing.JTable();
		tblTheme.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			List<TbBook> books=	 bookServicesImpl.showBookByIdThem((Integer) tblTheme.getValueAt(tblTheme.getSelectedRow(),0));

			tableModel = (DefaultTableModel) tblBook.getModel();
			tableModel.setRowCount(0);
		
				for (TbBook x :books) {
					tableModel.addRow(new Object[] { x.getId(), x.getNameBook(), x.getNumberOfPages() });
				}

			
			}
		});
		jCheckBox1 = new javax.swing.JCheckBox();
		jCheckBox1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(jCheckBox1.isSelected()==true)
				{
				List<TbTheme> theme=themeServicesImpl.showThemeIsBook();
				if(theme != null)
				{
					tableModel = (DefaultTableModel) tblTheme.getModel();
					tableModel.setRowCount(0);
					for (TbTheme x : theme) {
						tableModel.addRow(new Object[] { x.getId(), x.getNameTheme() });
					}
				}
				}else
				{
					List<TbTheme> theme=themeServicesImpl.getTheme(0,100);
					if(theme != null)
					{
						tableModel = (DefaultTableModel) tblTheme.getModel();
						tableModel.setRowCount(0);
						for (TbTheme x : theme) {
							tableModel.addRow(new Object[] { x.getId(), x.getNameTheme() });
						}
					}
				}
			}
		});
		jPanel1 = new javax.swing.JPanel();
		btnAdd = new javax.swing.JButton();
		btnEdit = new javax.swing.JButton();
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag = 3;
				swith_Enabled(true);
				btnSave.setEnabled(true);
				btnIrmoge.setEnabled(true);
				addItemComboboxAuthor();
				addItemComboboxTheme();
				addItemComboxPublishing();
			}
		});
		btnDelete = new javax.swing.JButton();
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không")==0) {
					deleteBook((Integer)tblBook.getValueAt(tblBook.getSelectedRow(), 0));
				}
			}
		});
		btnSave = new javax.swing.JButton();
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == 2) {
					if(validateBook()==true)
					{
						addBook(getBookFromForm());
					}
				}else if(flag == 3)
				{
					if (validateBook()) {
						updateBook((Integer)tblBook.getValueAt(tblBook.getSelectedRow(),0), getBookFromForm());
						
					}
				}
			}
		});
		btnIrmoge = new javax.swing.JButton();
		btnIrmoge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnIrmoge.setEnabled(false);
				btnSave.setEnabled(false);
				btnEdit.setEnabled(false);
				btnDelete.setEnabled(false);
				if (flag == 2) {
					swith_Enabled(false);
				} else if (flag == 3) {
					swith_Enabled(false);
				}
			}
		});
		btnExport = new javax.swing.JButton();
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookServicesImpl.exportExcel();
			}
		});
		jLabel2 = new javax.swing.JLabel();
		cboTheme = new javax.swing.JComboBox();
		jLabel3 = new javax.swing.JLabel();
		tfCode = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		cboPublicshing = new javax.swing.JComboBox();
		jLabel5 = new javax.swing.JLabel();
		tfTitle = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		tfYear = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		tfPage = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		tfPrice = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		tfCount = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		rdoEn = new javax.swing.JRadioButton();
		rdoVn = new javax.swing.JRadioButton();
		rdoKhac = new javax.swing.JRadioButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		tblBook = new javax.swing.JTable();
		cboAuthor = new javax.swing.JComboBox();
		tblBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showDetailBook((Integer) tblBook.getValueAt(tblBook.getSelectedRow(), 0));
				btnEdit.setEnabled(true);
				btnDelete.setEnabled(true);
				swith_Enabled(false);
			}
		});
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenuItem3 = new javax.swing.JMenuItem();
		jMenuItem4 = new javax.swing.JMenuItem();
		jMenuItem5 = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Quản Lý Sách");

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		jLabel1.setText("Quản Lý Sách");

		pnLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

		tblTheme.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null, null }, { null, null },
				{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
				{ null, null }, { null, null }, { null, null }, { null, null }, { null, null } },
				new String[] { "STT", "Chủ Đề" }));
		jScrollPane1.setViewportView(tblTheme);

		jCheckBox1.setText("Chỉ hiện thị chủ đề có sách");
		jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnLeftLayout = new javax.swing.GroupLayout(pnLeft);
		pnLeft.setLayout(pnLeftLayout);
		pnLeftLayout.setHorizontalGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnLeftLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pnLeftLayout.createSequentialGroup().addComponent(jCheckBox1)
										.addContainerGap(41, Short.MAX_VALUE))
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
										Short.MAX_VALUE))));
		pnLeftLayout.setVerticalGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						pnLeftLayout.createSequentialGroup().addContainerGap().addComponent(jCheckBox1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

		btnAdd.setText("Thêm");
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAddActionPerformed(evt);
			}
		});

		btnEdit.setText("Sửa");

		btnDelete.setText("Xóa");

		btnSave.setText("Lưu");

		btnIrmoge.setText("Bỏ Qua");

		btnExport.setText("Kết Xuất");

		jLabel2.setText("Chủ Đề");

		jLabel3.setText("Mã Sách");

		jLabel4.setText("Nhà Xuất Bản");

		jLabel5.setText("Tiêu Đề");

		jLabel6.setText("Tác Giả");

		jLabel7.setText("Năm Xuất Bản");

		tfYear.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tfYearActionPerformed(evt);
			}
		});

		jLabel8.setText("Số Trang");

		jLabel9.setText("Giá");

		tfPrice.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tfPriceActionPerformed(evt);
			}
		});

		jLabel10.setText("Số Bản Lưu");

		jLabel11.setText("Ngôn Ngữ");

		rdoEn.setText("Tiếng Anh");
		rdoEn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				rdoEnActionPerformed(evt);
			}
		});

		rdoVn.setText("Tiếng Việt");
		rdoVn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				rdoVnActionPerformed(evt);
			}
		});

		rdoKhac.setText("Khác");
		rdoKhac.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				rdoKhacActionPerformed(evt);
			}
		});

		tblBook.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null },
				{ null, null, null }, { null, null, null }, { null, null, null } },
				new String[] { "Mã Sách", "Tiêu Đề", "Số Bản Lưu" }));
		jScrollPane2.setViewportView(tblBook);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING,
								jPanel1Layout.createSequentialGroup().addGap(35).addComponent(jScrollPane2,
										GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(25).addGroup(jPanel1Layout
								.createParallelGroup(Alignment.TRAILING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE)
														.addGap(16))
												.addComponent(jLabel2).addComponent(jLabel6).addComponent(jLabel7)
												.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
														.addComponent(jLabel5).addComponent(jLabel3)))
										.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(tfYear, GroupLayout.PREFERRED_SIZE, 94,
																GroupLayout.PREFERRED_SIZE)
														.addGap(18).addComponent(jLabel8).addGap(34)
														.addComponent(tfPage, GroupLayout.PREFERRED_SIZE, 77,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(
														jPanel1Layout.createSequentialGroup()
																.addComponent(btnEdit, GroupLayout.DEFAULT_SIZE, 57,
																		Short.MAX_VALUE)
																.addGap(24)
																.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addGap(24)
																.addComponent(btnSave, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addGap(18)
																.addComponent(btnIrmoge, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(btnExport, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addGap(40))
												.addComponent(tfTitle, 437, 437, Short.MAX_VALUE)
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(tfCode, GroupLayout.PREFERRED_SIZE, 121,
																GroupLayout.PREFERRED_SIZE)
														.addGap(34).addComponent(jLabel4).addGap(18)
														.addComponent(cboPublicshing, 0, 187, Short.MAX_VALUE))
												.addComponent(cboTheme, 0, 437, Short.MAX_VALUE)
												.addComponent(cboAuthor, 0, 437, Short.MAX_VALUE)))
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel10).addGap(18)
										.addComponent(tfCount, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE).addGap(18)
										.addComponent(jLabel11).addGap(18).addComponent(rdoEn).addGap(18)
										.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
												.addGroup(jPanel1Layout.createSequentialGroup().addComponent(rdoVn)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(rdoKhac))
												.addGroup(jPanel1Layout.createSequentialGroup().addGap(18)
														.addComponent(jLabel9).addGap(18).addComponent(tfPrice,
																GroupLayout.PREFERRED_SIZE, 104,
																GroupLayout.PREFERRED_SIZE)))))))
						.addGap(20)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout
				.createSequentialGroup().addGap(12)
				.addGroup(jPanel1Layout
						.createParallelGroup(Alignment.BASELINE).addComponent(btnAdd).addComponent(btnEdit)
						.addComponent(btnDelete).addComponent(btnSave).addComponent(btnIrmoge).addComponent(btnExport))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel2).addComponent(
						cboTheme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel3)
						.addComponent(tfCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel4).addComponent(cboPublicshing, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel5))
				.addGap(18)
				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel6).addComponent(
						cboAuthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(24)
				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel7)
						.addComponent(tfYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel8)
						.addComponent(tfPage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel9).addComponent(tfPrice, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel10)
						.addComponent(tfCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel11).addComponent(rdoEn).addComponent(rdoVn).addComponent(rdoKhac))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(15, Short.MAX_VALUE)));
		jPanel1.setLayout(jPanel1Layout);

		jMenu1.setText("Chức Năng");

		jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, 0));
		jMenuItem2.setText("Quản Lý Nhà Xuất Bản");
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem2ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem2);

		jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, 0));
		jMenuItem3.setText("Quản Lý Chủ Đề");
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem3ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem3);

		jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, 0));
		jMenuItem4.setText("Quản Lý Tác Giả");
		jMenu1.add(jMenuItem4);
		jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem4ActionPerformed(evt);
			}
		});

		jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, 0));
		jMenuItem5.setText("Quản Lý Độc Giả");
		jMenu1.add(jMenuItem5);

		jMenuBar1.add(jMenu1);

		jMenu2.setText("Đăng Xuất");
		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(pnLeft, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(283, 283, 283)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(7, 7, 7).addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(pnLeft, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	private void tfYearActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfYearActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_tfYearActionPerformed

	private void tfPriceActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfPriceActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_tfPriceActionPerformed

	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem2ActionPerformed
		// TODO add your handling code here:
		this.setVisible(false);
		PublishingManager publishingManager = new PublishingManager();
		publishingManager.setVisible(true);
	}// GEN-LAST:event_jMenuItem2ActionPerformed

	private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem3ActionPerformed
		this.setVisible(false);
		ThemeManager themeManager = new ThemeManager();
		themeManager.setVisible(true);
	}// GEN-LAST:event_jMenuItem3ActionPerformed

	private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem3ActionPerformed
		this.setVisible(false);
		AuthorManager authorManager = new AuthorManager();
		authorManager.setVisible(true);
	}// GEN-LAST:event_jMenuItem3ActionPerformed

	private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jCheckBox1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jCheckBox1ActionPerformed

	private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed
		// TODO add your handling code here:
		btnSave.setEnabled(true);
		btnIrmoge.setEnabled(true);
		flag = 2;
		swith_Enabled(true);
		clearForm();
		addItemComboboxAuthor();
		addItemComboboxTheme();
		addItemComboxPublishing();

//		for (TbPlublishing x:themeServicesImpl.getTheme(0, 10)) {
//			cboTheme.addItem(x.getNameTheme());			
//		}

	}// GEN-LAST:event_btnAddActionPerformed

	private void rdoEnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rdoEnActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_rdoEnActionPerformed

	private void rdoVnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rdoVnActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_rdoVnActionPerformed

	private void rdoKhacActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rdoKhacActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_rdoKhacActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(BookManager.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(BookManager.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(BookManager.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(BookManager.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new BookManager().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnAdd;
	private javax.swing.JButton btnDelete;
	private javax.swing.JButton btnEdit;
	private javax.swing.JButton btnExport;
	private javax.swing.ButtonGroup btnGroupLanguage;
	private javax.swing.JButton btnIrmoge;
	private javax.swing.JButton btnSave;
	private javax.swing.JComboBox cboPublicshing;
	private javax.swing.JComboBox cboTheme;
	private javax.swing.JComboBox cboAuthor;
	private javax.swing.JCheckBox jCheckBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JMenuItem jMenuItem5;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable tblBook;
	private javax.swing.JPanel pnLeft;
	private javax.swing.JRadioButton rdoEn;
	private javax.swing.JRadioButton rdoKhac;
	private javax.swing.JRadioButton rdoVn;
	private javax.swing.JTable tblTheme;
	private javax.swing.JTextField tfCode;
	private javax.swing.JTextField tfCount;
	private javax.swing.JTextField tfPage;
	private javax.swing.JTextField tfPrice;
	private javax.swing.JTextField tfTitle;
	private javax.swing.JTextField tfYear;
}
