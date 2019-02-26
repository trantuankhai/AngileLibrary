package com.angile.Service;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.annotation.Retention;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.angile.Dao.AuthorDaoImpl;
import com.angile.model.TbAuthor;
import com.angile.model.TbTheme;

public class AuhorServicesImpl implements AuthorServices {
	private AuthorDaoImpl AuhorDAO = new AuthorDaoImpl();

	@Override
	public List<TbAuthor> getAuthor(int min, int max) {
		// TODO Auto-generated method stub
		return AuhorDAO.getAuthor(min, max);
	}

	@Override
	public boolean addAuthor(TbAuthor Author) {
		if (Author.getNameAuthor() == null) {
			return false;
		} else if (Author.getPhoneAuthor() == null || Author.getPhoneAuthor().matches("0[0-9s.-]{9,10}") == false) {
			return false;
		} else if (Author.getEmailAuthor() == null
				|| Author.getEmailAuthor().matches("[a-zA-Z0-9_\\.]+@[a-zA-Z]+\\.[a-zA-Z]+(\\.[a-zA-Z]+)*") == false) {
			return false;
		} else if (Author.getAddressAuthor().equals("")) {
			return false;
		} else {
			return AuhorDAO.addAuthor(Author);
		}

	}

	@Override
	public boolean editAuthor(int id_author, TbAuthor author) {
		// TODO Auto-generated method stub
		return AuhorDAO.editAuthor(id_author, author);
	}

	@Override
	public boolean removeAuthor(int id_Author) {

		return AuhorDAO.removeAuthor(id_Author);
	}

	@Override
	public TbAuthor getAuthorById(Integer id_Author) {
		// TODO Auto-generated method stub
		return AuhorDAO.getAuthorById(id_Author);
	}

	@Override
	public boolean exportExcel() {
		if (AuhorDAO.getAuthor(0, 100).size() > 0) {
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Theme sheet");
			List<TbAuthor> list = AuhorDAO.getAuthor(0, 100);
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
			cell.setCellValue("Tên Tác Giả");
			cell.setCellStyle(style);
			cell = row.createCell(2, org.apache.poi.ss.usermodel.CellType.STRING);
			cell.setCellValue("Số Điện Thoại");
			cell.setCellStyle(style);
			cell = row.createCell(3, org.apache.poi.ss.usermodel.CellType.STRING);
			cell.setCellValue("Địa Chỉ");
			cell.setCellStyle(style);
			cell = row.createCell(4, org.apache.poi.ss.usermodel.CellType.STRING);
			cell.setCellValue("Email");
			cell.setCellStyle(style);
			// Data
			for (TbAuthor emp : list) {
				rownum++;
				row = sheet.createRow(rownum);
				cell = row.createCell(0, org.apache.poi.ss.usermodel.CellType.STRING);
				cell.setCellValue(emp.getId());
				cell = row.createCell(1, org.apache.poi.ss.usermodel.CellType.STRING);
				cell.setCellValue(emp.getNameAuthor());
				cell = row.createCell(2, org.apache.poi.ss.usermodel.CellType.STRING);
				cell.setCellValue(emp.getPhoneAuthor());
				cell = row.createCell(3, org.apache.poi.ss.usermodel.CellType.STRING);
				cell.setCellValue(emp.getAddressAuthor());
				cell = row.createCell(4, org.apache.poi.ss.usermodel.CellType.STRING);
				cell.setCellValue(emp.getEmailAuthor());
			}
			File file = new File("C:/demo/theme.xls");
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
	public TbAuthor getAuthorByName(String name) {
		if (!name.equals("")) {
			return AuhorDAO.getAuthorByName(name);
		}
		return null;
	}

}
