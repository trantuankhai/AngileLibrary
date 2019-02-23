package com.angile.Service;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.angile.Dao.ThemeDAO;
import com.angile.Dao.ThemeDAOImpl;
import com.angile.model.TbTheme;
import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class ThemeServicesImpl implements ThemeServices {
	ThemeDAOImpl themeDAo = new ThemeDAOImpl();

	@Override
	public List<TbTheme> getTheme(int min, int max) {
		return themeDAo.getTheme(min, max);
	}

	@Override
	public boolean addTheme(String name_Theme) {
		if (!name_Theme.equals("")) {
			if (themeDAo.addTheme(name_Theme)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

	@Override
	public boolean removeTheme(int id_Theme) {
		// TODO Auto-generated method stub
		return themeDAo.removeTheme(id_Theme);
	}

	@Override
	public boolean editTheme(int id_Theme, String name_Theme) {
		if (!name_Theme.equals("")) {
			if (themeDAo.editTheme(id_Theme, name_Theme) == true) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public TbTheme showThemeById(int id_Theme) {
		// TODO Auto-generated method stub
		return themeDAo.showThemeById(id_Theme);
	}

	@Override
	public TbTheme searchTheme(String nameTheme) {
		if (!nameTheme.equals("")) {
			return themeDAo.searchTheme(nameTheme);
		} else {
			return null;
		}
	}

	@Override
	public boolean exportExcel() throws IOException {
		if (themeDAo.getTheme(0, 100).size() > 0) {
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Theme sheet");
			List<TbTheme> list = themeDAo.getTheme(0, 100);
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
			cell.setCellValue("Tên Chủ Đề");
			cell.setCellStyle(style);
			// Data
			for (TbTheme emp : list) {
				rownum++;
				row = sheet.createRow(rownum);
				cell = row.createCell(0, org.apache.poi.ss.usermodel.CellType.STRING);
				cell.setCellValue(emp.getId());
				cell = row.createCell(1, org.apache.poi.ss.usermodel.CellType.STRING);
				cell.setCellValue(emp.getNameTheme());
			}
			File file = new File("C:/demo/theme.xls");
			file.getParentFile().mkdirs();

			FileOutputStream outFile = new FileOutputStream(file);
			workbook.write(outFile);
			System.out.println("Created file: " + file.getAbsolutePath());
			if (Desktop.isDesktopSupported() && new File(file.getAbsolutePath()).exists()) {
				Desktop.getDesktop().open(new File(file.getAbsolutePath()));
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

}
