package com.angile.Service;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.angile.Dao.BookDAOImpl;
import com.angile.model.TbBook;

public class BookServicesImpl implements BookServices {
	BookDAOImpl bookDaoImpl = new BookDAOImpl();

	@Override
	public List<TbBook> getBook(int min, int max) {
		// TODO Auto-generated method stub
		return bookDaoImpl.getBook(min, max);
	}

	@Override
	public boolean addBook(TbBook book) {
//		if (book.getNameBook().equals("")) {
//			JOptionPane.showMessageDialog(null, "Bạn chưa nhập tiêu đề sách");
//			return false;
//		} else if (book.getPublishingYear().equals("") || book.getPublishingYear().matches("^[0-3]+$")==false) {
//			JOptionPane.showMessageDialog(null, "Bạn chưa nhập năm xuất bản hoặc không đúng định dạng");
//				return false;
//		} else if (book.getNumberOfPages().equals("") || book.getNumberOfPages().matches("^[0-9]+$")==false) {
//			JOptionPane.showMessageDialog(null,"Bạn chưa nhập số trang hoặc không đúng định dạng");
//			return false;
//		} else if (book.getPriceBook().equals("")|| book.getPriceBook().matches("^[0-9]+$")==false) {
//			JOptionPane.showMessageDialog(null, "Bạn chưa nhập giá hoặc không đúng định dạng");
//			return false;
//
//		} else if (tfCount.getText().equals("")|| tfYear.getText().matches("^[0-9]+$")==false) {
//			JOptionPane.showMessageDialog(null,"Bạn chưa nhập số bản lưu hoặc không đúng định dạng");
//			return false;
//		}else {
		return bookDaoImpl.addBook(book);
		// }
	}

	@Override
	public boolean editBook(int id_book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeBook(int id_book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TbBook getBookById(int id_book) {
		if (id_book > 0) {
			return bookDaoImpl.getBookById(id_book);
		}
		return null;
	}

	@Override
	public boolean exportExcel() {

		if (bookDaoImpl.getBook(0, 100).size() > 0) {
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Theme sheet");
			List<TbBook> list = bookDaoImpl.getBook(0, 100);
			int rownum = 0;
			Cell cell;
			Row row;
			//
			HSSFCellStyle style = createStyleForTitle(workbook);
			row = sheet.createRow(rownum);
			// EmpNo
			cell = row.createCell(0, org.apache.poi.ss.usermodel.CellType.STRING);
			cell.setCellValue("ID");
			cell.setCellStyle(style);
			// EmpName
			cell = row.createCell(1, org.apache.poi.ss.usermodel.CellType.STRING);
			cell.setCellValue("Tên chủ đề");
			cell.setCellStyle(style);
			cell = row.createCell(2, org.apache.poi.ss.usermodel.CellType.STRING);
			cell.setCellValue("Tên nhà xuất bản");
			cell.setCellStyle(style);
			cell = row.createCell(3, org.apache.poi.ss.usermodel.CellType.STRING);
			cell.setCellValue("Tên sách");
			cell.setCellStyle(style);
			cell = row.createCell(4, org.apache.poi.ss.usermodel.CellType.STRING);
			cell.setCellValue("Tên tác giả");
			cell.setCellStyle(style);
			cell = row.createCell(5, org.apache.poi.ss.usermodel.CellType.STRING);
			cell.setCellValue("Năm xuất bản");
			cell.setCellStyle(style);
			cell = row.createCell(6, org.apache.poi.ss.usermodel.CellType.STRING);
			cell.setCellValue("Giá cuốn sách");
			cell.setCellStyle(style);
			cell = row.createCell(7, org.apache.poi.ss.usermodel.CellType.STRING);
			cell.setCellValue("Số bản lưu");
			cell.setCellStyle(style);
			cell = row.createCell(8, org.apache.poi.ss.usermodel.CellType.STRING);
			cell.setCellValue("Giá");
			cell.setCellStyle(style);
			cell = row.createCell(9, org.apache.poi.ss.usermodel.CellType.STRING);
			cell.setCellValue("ngôn ngữ");
			cell.setCellStyle(style);
			// Data
			for (TbBook emp : list) {
				rownum++;
				row = sheet.createRow(rownum);
				cell = row.createCell(0, org.apache.poi.ss.usermodel.CellType.STRING);
				cell.setCellValue(emp.getId());
				cell = row.createCell(1, org.apache.poi.ss.usermodel.CellType.STRING);
				cell.setCellValue(emp.getIdTheme().getNameTheme());
				cell = row.createCell(2, org.apache.poi.ss.usermodel.CellType.STRING);
				cell.setCellValue(emp.getIdPublishing().getNamePublishing());
				cell = row.createCell(3, org.apache.poi.ss.usermodel.CellType.STRING);
				cell.setCellValue(emp.getNameBook());
				cell = row.createCell(4, org.apache.poi.ss.usermodel.CellType.STRING);
				cell.setCellValue(emp.getIdAuthor().getNameAuthor());
				cell = row.createCell(5, org.apache.poi.ss.usermodel.CellType.STRING);
				cell.setCellValue(emp.getPublishingYear());
				cell = row.createCell(6, org.apache.poi.ss.usermodel.CellType.STRING);
				cell.setCellValue(emp.getNumberOfPages());
				cell = row.createCell(7, org.apache.poi.ss.usermodel.CellType.STRING);
				cell.setCellValue(emp.getPriceBook());
				cell = row.createCell(8, org.apache.poi.ss.usermodel.CellType.STRING);
				cell.setCellValue(emp.getStorageNumber());
				if (emp.getLanguaage() == 1) {
					cell = row.createCell(9, org.apache.poi.ss.usermodel.CellType.STRING);
					cell.setCellValue("Tiếng Việt");
				} else if (emp.getLanguaage() == 2) {
					cell = row.createCell(9, org.apache.poi.ss.usermodel.CellType.STRING);
					cell.setCellValue("Tiếng Anh");
				} else {
					cell = row.createCell(9, org.apache.poi.ss.usermodel.CellType.STRING);
					cell.setCellValue("Ngỗn ngữ khác");
				}
			}
			File file = new File("C:/demo/book.xls");
			file.getParentFile().mkdirs();

			try {
				FileOutputStream outFile = new FileOutputStream(file);
				workbook.write(outFile);
				System.out.println("Created file: " + file.getAbsolutePath());
				if (Desktop.isDesktopSupported() && new File(file.getAbsolutePath()).exists()) {
					Desktop.getDesktop().open(new File(file.getAbsolutePath()));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	private HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
		HSSFFont font = workbook.createFont();
		font.setBold(true);
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);
		return style;
	}

	@Override
	public List<TbBook> showBookByIdThem(int id) {
		// TODO Auto-generated method stub
		return bookDaoImpl.showBookByIdThem(id);
	}
}
