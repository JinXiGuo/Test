package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WriteException;

public class ExcelEdit
{
	public static void modifyExcel(String excelpath)
	{
		try
		{
			Workbook wb = null; // 创建一个workbook对象
			try
			{
				InputStream is = new FileInputStream(excelpath); // 创建一个文件流，读入Excel文件
				wb = Workbook.getWorkbook(is); // 将文件流写入到workbook对象
			} catch (BiffException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// jxl.Workbook 对象是只读的，所以如果要修改Excel，需要创建一个可读的副本，副本指向原Excel文件（即下面的new
			// File(excelpath)）
			jxl.write.WritableWorkbook wbe = Workbook.createWorkbook(new File(excelpath), wb);// 创建workbook的副本
			WritableSheet sheet = wbe.getSheet("万隆"); // 获取第一个sheet
			WritableCell cell = sheet.getWritableCell(0,0);// 获取第一个单元格
			jxl.format.CellFormat cf = cell.getCellFormat();// 获取第一个单元格的格式
			jxl.write.Label lbl = new jxl.write.Label(0, 0, "修改后的值");// 将第一个单元格的值改为“修改後的值”
			lbl.setCellFormat(cf);// 将修改后的单元格的格式设定成跟原来一样

			sheet.addCell(lbl);// 将改过的单元格保存到sheet
			wbe.write();// 将修改保存到workbook --》一定要保存
			wbe.close();// 关闭workbook，释放内存 ---》一定要释放内存

		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args)
	{
		modifyExcel("D:/t/ip地区.xls");
		System.out.println("ok");
	}
}
