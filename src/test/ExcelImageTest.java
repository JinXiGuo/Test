package test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelImageTest
{
	public static void main(String[] args) {  
        FileOutputStream fileOut = null;     
        BufferedImage bufferImg = null;     
       //�ȰѶ�������ͼƬ�ŵ�һ��ByteArrayOutputStream�У��Ա����ByteArray    
       try {  
           ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();     
           bufferImg = ImageIO.read(new File("d:/t/t01.png"));     
           ImageIO.write(bufferImg, "jpg", byteArrayOut);  
             
           HSSFWorkbook wb = new HSSFWorkbook();     
           HSSFSheet sheet1 = wb.createSheet("test picture");    
           //��ͼ�Ķ�����������һ��sheetֻ�ܻ�ȡһ����һ��Ҫע����㣩  
           HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();     
           //anchor��Ҫ��������ͼƬ������  
           HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 255, 255,(short) 1, 1, (short) 5, 8);     
           anchor.setAnchorType(3);     
           //����ͼƬ    
           patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));   
           fileOut = new FileOutputStream("D:/Excel.xls");     
           // д��excel�ļ�     
            wb.write(fileOut);     
            System.out.println("----Excle�ļ�������------");  
       } catch (Exception e) {  
           e.printStackTrace();  
       }finally{  
           if(fileOut != null){  
                try {  
                   fileOut.close();  
               } catch (IOException e) {  
                   e.printStackTrace();  
               }  
           }  
       }  
   }  
}
