package com.angile.Service;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.angile.Dao.PublishingDaoImpl;
import com.angile.model.TbAuthor;
import com.angile.model.TbPlublishing;

public class PublishingServicesimpl implements PublishingServices {
	private PublishingDaoImpl PublishingServicesimpl = new PublishingDaoImpl();

	@Override
	public List<TbPlublishing> getPublishing(int min, int max) {
		// TODO Auto-generated method stub
		return PublishingServicesimpl.getPublishing(min, max);
	}

	@Override
	public boolean addPublishing(TbPlublishing Publishing) {
		// TODO Auto-generated method stub
		return PublishingServicesimpl.addPublishing(Publishing);
	}
	@Override
	public boolean removePublishing(int id_Publishing) {
		// TODO Auto-generated method stub
		return PublishingServicesimpl.removePublishing(id_Publishing);
	}

	@Override
	public TbPlublishing getPublishingById(int id_Publishing) {
		// TODO Auto-generated method stub
		return PublishingServicesimpl.getPublishingById(id_Publishing);
	}

	@Override
	public boolean editPublishing(int id_Publishing, TbPlublishing plublishing) {
		// TODO Auto-generated method stub
		return PublishingServicesimpl.editPublishing(id_Publishing, plublishing);
	}

	@Override
	public boolean exportExcel() {
		if (PublishingServicesimpl.getPublishing(0, 100).size() > 0) {
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Theme sheet");
			List<TbPlublishing> list = PublishingServicesimpl.getPublishing(0, 100);
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
			cell.setCellValue("Tên NBX");
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
			for (TbPlublishing emp : list) {
				rownum++;
				row = sheet.createRow(rownum);
				cell = row.createCell(0, org.apache.poi.ss.usermodel.CellType.STRING);
				cell.setCellValue(emp.getId());
				cell = row.createCell(1, org.apache.poi.ss.usermodel.CellType.STRING);
				cell.setCellValue(emp.getNamePublishing());
				cell = row.createCell(2, org.apache.poi.ss.usermodel.CellType.STRING);
				cell.setCellValue(emp.getPhonePublishing());
				cell = row.createCell(3, org.apache.poi.ss.usermodel.CellType.STRING);
				cell.setCellValue(emp.getAddressPublishing());
				cell = row.createCell(4, org.apache.poi.ss.usermodel.CellType.STRING);
				cell.setCellValue(emp.getEmailPublishing());
			}
			File file = new File("C:/demo/plublishing.xls");
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
	}


