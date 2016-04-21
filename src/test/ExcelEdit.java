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
			Workbook wb = null; // ����һ��workbook����
			try
			{
				InputStream is = new FileInputStream(excelpath); // ����һ���ļ���������Excel�ļ�
				wb = Workbook.getWorkbook(is); // ���ļ���д�뵽workbook����
			} catch (BiffException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// jxl.Workbook ������ֻ���ģ��������Ҫ�޸�Excel����Ҫ����һ���ɶ��ĸ���������ָ��ԭExcel�ļ����������new
			// File(excelpath)��
			jxl.write.WritableWorkbook wbe = Workbook.createWorkbook(new File(excelpath), wb);// ����workbook�ĸ���
			WritableSheet sheet = wbe.getSheet("��¡"); // ��ȡ��һ��sheet
			WritableCell cell = sheet.getWritableCell(0,0);// ��ȡ��һ����Ԫ��
			jxl.format.CellFormat cf = cell.getCellFormat();// ��ȡ��һ����Ԫ��ĸ�ʽ
			jxl.write.Label lbl = new jxl.write.Label(0, 0, "�޸ĺ��ֵ");// ����һ����Ԫ���ֵ��Ϊ���޸����ֵ��
			lbl.setCellFormat(cf);// ���޸ĺ�ĵ�Ԫ��ĸ�ʽ�趨�ɸ�ԭ��һ��

			sheet.addCell(lbl);// ���Ĺ��ĵ�Ԫ�񱣴浽sheet
			wbe.write();// ���޸ı��浽workbook --��һ��Ҫ����
			wbe.close();// �ر�workbook���ͷ��ڴ� ---��һ��Ҫ�ͷ��ڴ�

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
		modifyExcel("D:/t/ip����.xls");
		System.out.println("ok");
	}
}
