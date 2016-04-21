package test;
import java.io.File;
import java.net.URL;

import jxl.CellView;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.io.FileUtils;
public class CreateExcel
{
	public static void main(String args[])
	{
		try
		{
			// ���ļ�
			WritableWorkbook book = Workbook.createWorkbook(new File("D://test.xls"));
			// ������Ϊ����һҳ���Ĺ���������0��ʾ���ǵ�һҳ
			WritableSheet sheet = book.createSheet("��һҳ", 0);
			// �ϲ���Ԫ�� �ڶ��е�һ�е��ڶ��еڶ��кϲ�
			//sheet.mergeCells(0, 1, 1, 1);
			// �趨��Ԫ��߶����� �趨��һ�и߶�200 �趨��һ�п��30
			//sheet.setRowView(0, 5000);
			//sheet.setColumnView(0, 30);
			// ָ��������ʽ������TIMES,�ֺ�16,�Ӵ���ʾ��
			// WritableFont()���Բ���
			// ���� WritableFont.TIMES
			// ��С 18
			// �Ƿ�Ϊ���� WritableFont.BOLD WritableFont.NO_BOLD
			// �Ƿ�Ϊб�� true
			// ��ʽ UnderlineStyle.NO_UNDERLINE �»���
			// ��ɫ jxl.format.Colour.RED ������ɫΪ��ɫ
			WritableFont font1 = new WritableFont(WritableFont.TIMES, 16, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.RED);
			// WritableCellFormat�࣬ͨ��������ָ����Ԫ��ĸ�������
			// ������ָ�����ݶ��뷽ʽ ˮƽ���� ��ֱ����
			WritableCellFormat format1 = new WritableCellFormat(font1);
			format1.setAlignment(jxl.format.Alignment.LEFT);
			format1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			// ��Label����Ĺ�������ָ����Ԫ��λ���ǵ�һ�е�һ��(0,0)
			// �Լ���Ԫ������Ϊtest
			// Label()������������ 1������ 2������ 3��Ҫд������� 4����ʽ����ѡ�
			Label label = new Label(0, 0, "test", format1);

			// ������õĵ�Ԫ����ӵ���������
			sheet.addCell(label);
			sheet.addCell(new Label(0, 1, null, format1));

			// ����һ���������ֵĵ�Ԫ�� ����ʹ��Number��������·�����������﷨���� ��Ԫ��λ���ǵڶ��У���һ�У�ֵΪ789.123
			jxl.write.Number number = new jxl.write.Number(1, 0, 555.12541);
			sheet.addCell(number);

			// ����ͼƬ
			URL url = new URL("http://img.salesmanb2b.com/BB/attachment/pro2014/HPPS103520.jpg");
			File imgFile = new File("d:\\t\\t.png");
			FileUtils.copyURLToFile(url, imgFile);
			
			//BufferedImage input= ImageIO.read(imgFile);
			// WritableImage(col, row, width, height, imgFile);
			//String path=imgFile.getAbsolutePath();  
            //File outputFile = new File(path.substring(0,path.lastIndexOf('.')+1)+"png");  
            //ImageIO.write(input, "PNG", outputFile);  
			// col row��ͼƬ����ʼ����ʼ�� width height�Ƕ���ͼƬ��Խ������������
			WritableImage image = new WritableImage(0, 1, 1, 1, imgFile);
//			sheet.setColumnView(4, 50);
			sheet.addImage(image);
			// д�����ݲ��ر��ļ�
			sheet.setRowView(1, 2000);
			sheet.setColumnView(0, 25);
			book.write();
			book.close();

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
}
