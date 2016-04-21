package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

public class WaterMarkUtils {
	/**
	 * ͼƬ���ˮӡ
	 * @param srcImgPath ��Ҫ���ˮӡ��ͼƬ��·��
	 * @param outImgPath ���ˮӡ��ͼƬ���·��
	 * @param markContentColor ˮӡ���ֵ���ɫ
	 * @param waterMarkContent ˮӡ������
	 */
	public void mark(String srcImgPath, String outImgPath, Color markContentColor, String waterMarkContent) {
		try {
            // ��ȡԭͼƬ��Ϣ
            File srcImgFile = new File(srcImgPath);
            Image srcImg = ImageIO.read(srcImgFile);
            int srcImgWidth = srcImg.getWidth(null);
            int srcImgHeight = srcImg.getHeight(null);
            // ��ˮӡ��ͼƬ��С
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight+100, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            //Font font = new Font("Courier New", Font.PLAIN, 12);
            Font font = new Font("����", Font.PLAIN, 50);  
            g.setColor(markContentColor); //����ͼƬ�ı�������ˮӡ��ɫ
            
            g.setFont(font);
            int x = srcImgWidth - getWatermarkLength(waterMarkContent, g) - 3;
            int y = srcImgHeight - 3;
            //int x = (srcImgWidth - getWatermarkLength(watermarkStr, g)) / 2;
            //int y = srcImgHeight / 2;
            g.drawString(waterMarkContent, x, y+100);
            g.dispose();
            // ���ͼƬ
            FileOutputStream outImgStream = new FileOutputStream(outImgPath);
            ImageIO.write(bufImg, "jpg", outImgStream);
            outImgStream.flush();
            outImgStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * ��ȡˮӡ�����ܳ���
	 * @param waterMarkContent ˮӡ������
	 * @param g
	 * @return ˮӡ�����ܳ���
	 */
    public int getWatermarkLength(String waterMarkContent, Graphics2D g) {
        return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
    }
    
    public static void main(String[] args) {
    	// ԭͼλ��, ���ͼƬλ��, ˮӡ������ɫ, ˮӡ����
        new WaterMarkUtils().mark("d:/t/t01.png", "d:/t/t01.png", Color.red, "ˮӡЧ������");
        new WaterMarkUtils().mark("d:/t/t01.png", "d:/t/t01.png", Color.red, "ˮӡЧ������2ˮӡЧ������2ˮӡЧ������2ˮӡЧ������2ˮӡЧ������2");
   }
}
